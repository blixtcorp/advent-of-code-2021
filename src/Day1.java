import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> data = new ArrayList<>();
        File numbers = new File("src/resources/myData");
        Scanner input = new Scanner(numbers);

        while(input.hasNextLine()){
            data.add(Integer.parseInt(input.nextLine()));
        }
        partA(data);
        partB(data);
    }

    static void partA(ArrayList<Integer> data) {
        int result = 0;

        for(int i = 1; i < data.size(); i++){
        //checking recursively to dodge nullpointers
            if(data.get(i) > data.get(i-1)){
               result++;
            }
        }
        System.out.println("Result from part A is: " + result);
    }

    static void partB(ArrayList<Integer> data){
        int result = 0;
        int currentValue;
        int previousValue = data.get(0) + data.get(1) + data.get(2);

        for(int i = 1; i < data.size() - 2; i++){
            currentValue = data.get(i) + data.get(i+1) + data.get(i+2);
            if(currentValue - previousValue > 0){
                result++;
            }
            previousValue = currentValue;
        }
        System.out.println("Result from part B is: " + result);
    }
}
