import java.util.List;

public class Simulator {
    private final Integer numOfCycles;
    private final Integer numOfTasks;
    private final Integer numOfPriorities;
    private final Integer[][] taskSpec;
    private final List<Processor> processors;
    private List<Scheduler> schedulers;

    public Simulator(Integer numOfProcessors, Integer numOfCycles,
                     Integer numOfTasks, Integer numOfPriorities, Integer[][] taskSpec) {
        this.numOfCycles = numOfCycles;
        this.numOfTasks = numOfTasks;
        this.numOfPriorities = numOfPriorities;
        this.taskSpec = taskSpec;
        processors = Processor.initProcessors(numOfProcessors);
    }

    public void start(){
        schedulers = Scheduler.initSchedulers(numOfPriorities);
        List<Task>[] tasks = Task.prepareTasks(taskSpec, numOfCycles);

        Report.processors(processors);

        for(int i = 1; i <= numOfCycles; i++){
            Cycle cycle = new Cycle(i);
            if (i <= numOfTasks) {
                for (Task task : tasks[i]) {
                    schedulers.get(task.getPriority()).addTask(task);
                }
            }
            assignTasksToProcessors(processors);
            Report.cycleDetails(cycle, processors, tasks[i]);

            for(Processor processor : processors){
                processor.execute();
            }
            cycle.run();
        }
    }

    private void assignTasksToProcessors(List<Processor> processors){
        for(Processor processor : processors){
            if (!processor.isAvailable()){
                continue;
            }

            Task currentTask = Scheduler.decide(schedulers);
            if (currentTask != null)
                processor.assignTask(currentTask);
        }
    }
}