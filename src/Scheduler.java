import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Scheduler {
    private final PriorityQueue<Task> queue;

    public Scheduler() {
        queue = new PriorityQueue<>((A, B) -> Integer.compare(B.getDuration(), A.getDuration()));
    }

    public static Task decide(List<Scheduler> schedulers) {
        int numOfPriorities = schedulers.size();
        for(int j = numOfPriorities - 1; j >= 0; j--){
            if (schedulers.get(j).queue.isEmpty()){
                continue;
            }
            Task currentTask = schedulers.get(j).getQueue().poll();
            if (currentTask != null && currentTask.getDuration() > 0){
                return currentTask;
            }
        }
        return null;
    }

    public void addTask(Task task) {
        queue.add(task);
    }

    public static List<Scheduler> initSchedulers(int numOfPriorities){
        List<Scheduler> schedulers = new ArrayList<>();
        for(int i = 0; i < numOfPriorities; i++){
            schedulers.add(new Scheduler());
        }

        return schedulers;
    }

    public PriorityQueue<Task> getQueue() {
        return queue;
    }
}