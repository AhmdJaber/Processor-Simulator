import java.util.List;

public class Report {
    public static final String reset = "\033[0m";
    public static final String red = "\033[0;31m";
    public static final String green = "\033[0;32m";
    public static final String blue = "\033[0;34m";
    public static final String orange = "\033[38;2;255;165;0m";
    public static final String bold = "\033[1m";

    public static void processors(List<Processor> processors) {
        System.out.print("\t\t" + blue + bold);
        for (Processor processor : processors) {
            System.out.print("P" + processor.getProcessorID() + "\t");
        }
        System.out.println();
        System.out.print(reset + "\t ----");
        for (int i = 0; i < processors.size(); i++) {
            System.out.print("----");
        }
        System.out.println();
    }

    public static void cycleDetails(Cycle cycle, List<Processor> processors, List<Task> createdTasks) {
        System.out.print(red + bold + "C" + cycle.getCycleID() + reset + "\t|\t" + green);
        for (Processor processor : processors) {
            if (processor.getCurrentTask() != null) {
                if (processor.getCurrentTask().getDuration() == 1){
                    System.out.print(reset + bold + "T" + processor.getCurrentTask().getTaskID() + "\t" + green);
                }
                else {
                    System.out.print("T" + processor.getCurrentTask().getTaskID() + "\t");
                }
            }
            else {
                System.out.print(reset + "_\t" + green);
            }
        }

        System.out.print(reset + " |");
        if (!createdTasks.isEmpty()) {
            System.out.print(" Tasks: { " + orange + bold);
            for (Task task : createdTasks) {
                System.out.print("T" + task.getTaskID() + " ");
            }
            System.out.print(reset + "} Created!");
        }
        System.out.println();
    }
}