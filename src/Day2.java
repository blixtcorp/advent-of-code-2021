import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> commands = new ArrayList<>();

        File input = new File("src/resources/myData2");
        Scanner data = new Scanner(input);

        while (data.hasNextLine()) {
            commands.add(data.nextLine());
        }

        partA(commands);
    }

    static void partA(ArrayList<String> commands){
        int horizontal = 0;
        int depth = 0;

        for (String command : commands) {
            String[] cmd = command.split(" ");
            if(cmd[0].equals("forward")){
                horizontal += Integer.parseInt(cmd[1]);
            } else if(cmd[0].equals("down")){
                depth += Integer.parseInt(cmd[1]);
            } else if(cmd[0].equals("up")){
                depth -= Integer.parseInt(cmd[1]);
            }
        }

        int result = horizontal * depth;
        System.out.println("The result is: " + result);
    }
}
