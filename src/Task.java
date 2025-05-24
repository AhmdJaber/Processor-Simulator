import java.util.ArrayList;
import java.util.List;

public class Task {
    private final Integer taskID;
    private Integer duration;
    private Integer priority;

    public Task(Integer taskID, Integer duration, Integer priority) {
        this.taskID = taskID;
        this.duration = duration;
        this.priority = priority;
    }

    public static List<Task>[] prepareTasks(Integer[][] taskSpec, Integer numOfCycles){
        List<Task>[] tasks = new List[numOfCycles + 1];
        for(int i = 0; i < numOfCycles + 1; i++){
            tasks[i] = new ArrayList<>();
        }
        for(int i = 0; i < taskSpec.length; i++){
            if (taskSpec[i][0] <= numOfCycles) {
                tasks[taskSpec[i][0]].add(new Task(i + 1, taskSpec[i][1], taskSpec[i][2]));
            }
        }

        return tasks;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getTaskID() {
        return taskID;
    }
}