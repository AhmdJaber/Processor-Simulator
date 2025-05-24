import java.util.ArrayList;
import java.util.List;

public class Processor {
    private final Integer processorID;
    private boolean available;
    private Task currentTask;

    public Processor(Integer processorID) {
        this.processorID = processorID;
        available = true;
        currentTask = null;
    }

    public void assignTask(Task task) {
        currentTask = task;
        available = false;
    }

    public void execute(){
        if (currentTask == null) {
            return;
        }

        currentTask.setDuration(currentTask.getDuration() - 1);
        if (currentTask.getDuration() <= 0) {
            Main.numOfFinishedTasks++;
            setAvailable(true);
            currentTask = null;
        }
    }

    public static List<Processor> initProcessors(Integer numOfProcessors) {
        List<Processor> processors = new ArrayList<>();
        for(int i = 1; i <= numOfProcessors; i++){
            processors.add(new Processor(i));
        }
        return processors;
    }

    public Integer getProcessorID() {
        return processorID;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
    }
}