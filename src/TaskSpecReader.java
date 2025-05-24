import java.io.BufferedReader;
import java.io.FileReader;

public class TaskSpecReader {
    public static Integer numOfTasks;

    public static Integer[][] getTaskSpec(String pathToTaskSpec) {
        try(BufferedReader reader = new BufferedReader(new FileReader(pathToTaskSpec))) {
            numOfTasks = Integer.parseInt(reader.readLine());
            Integer[][] taskSpec = new Integer[numOfTasks][3];
            for(int i = 0; i < numOfTasks; i++){
                String[] spec = reader.readLine().split(" ");
                for(int j = 0; j < 3; j++){
                    taskSpec[i][j] = Integer.parseInt(spec[j]);
                }
            }
            return taskSpec;
        }
        catch(Exception e) {
             throw new IllegalArgumentException("Error with this file path.\n" + e);
        }
    }
}