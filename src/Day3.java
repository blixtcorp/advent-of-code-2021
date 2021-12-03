import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Day3 {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> input = new ArrayList<>();

        File file = new File("src/resources/myData3");
        Scanner data = new Scanner(file);

        while (data.hasNextLine()) {
            input.add((data.nextLine()));
        }

        partA(input);
    }

    static void partA(ArrayList<String> input){
        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();
        int temp;

        for(int i = 0; i < input.get(0).length(); i++){
            temp = loop(input, i);

            if(temp == 1){
                gammaRate.append(1);
                epsilonRate.append(0);
            } else {
                gammaRate.append(0);
                epsilonRate.append(1);
            }
        }

        int gamma = binaryToDecimal(gammaRate.toString());
        int epsilon = binaryToDecimal(epsilonRate.toString());

        int result = gamma * epsilon;

        System.out.println("The result in part A is: " + result);

    }

    static int loop(ArrayList<String> input, int index){
        int ones = 0;
        int zeros = 0;

        for(int i = 0; i < input.size(); i++){
            String val = input.get(i);
            String[] valArr = val.split("");

            if(valArr[index].equals("1")){
                ones++;
            } else {
                zeros++;
            }

        }
        if(ones > zeros){
            return 1;
        } else {
            return 0;
        }
    }

    static int binaryToDecimal(String input){
        String[] binary = input.split("");
        int decVal = 0;
        int temp;

        for(int i = 0; i < binary.length; i++){
            temp = (int) (Integer.parseInt(binary[i]) * Math.pow(2, 11-i));
            decVal += temp;
        }
        return decVal;
    }
}
