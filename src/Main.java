import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static int numOfFinishedTasks = 0;

    public static void main(String[] args) {
        System.out.print("Enter the number of the Processors: ");
        int numOfProcessors = scan.nextInt();

        System.out.print("Enter the number of the Cycles: ");
        int numOfCycles = scan.nextInt();

        System.out.print("Enter the full path to your Task Specifications: ");
        String pathToTaskSpec = scan.next();

        Integer[][] taskSpec = TaskSpecReader.getTaskSpec(pathToTaskSpec);
        int numOfTasks = taskSpec.length;

        Simulator simulator = new Simulator(numOfProcessors, numOfCycles,
                numOfTasks, 2, taskSpec);

        System.out.println("\n");
        System.out.println(Report.bold + "The following is a report that shows the execution process for the "+ numOfTasks +" tasks" +
                ", in " + numOfProcessors + " processors.");
        System.out.println(Report.reset + "Colors explanation:");
        System.out.println("\t" + Report.bold + Report.blue + "Blue\t" + Report.reset + "The color of the Processor");
        System.out.println("\t" + Report.bold + Report.red + "Red \t" + Report.reset + "The color of the Cycle");
        System.out.println("\t" + Report.bold + Report.orange + "Orange\t" + Report.reset + "The color of the Created Task");
        System.out.println("\t" + Report.bold + Report.green + "Green\t" + Report.reset + "The color of the Task begin processed");
        System.out.println("\t" + Report.bold + "White\t" + Report.reset + "The color of the completed Task");
        System.out.println(Report.bold + "\n----------------------------------------------------------------------" +
                Report.reset + "\n");

        simulator.start(); // start the simulation

        System.out.println("\n\n");
        System.out.println(Report.bold + "Number of tasks that have been finished: " + Report.green + numOfFinishedTasks + Report.reset);
        System.out.println(Report.bold + "Number of tasks that haven't been finished: " + Report.red + (numOfTasks - numOfFinishedTasks) + Report.reset);
    }
}