import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AOC2024_2{

    public static void readFile(List<List<Integer>> list){
        try{
            File file = new File("data.txt");
            Scanner scanner = new Scanner(file);
            
            while(scanner.hasNextLine()){

                String data = scanner.nextLine();
                List<Integer> intList = new ArrayList<>();
                for (String input : data.split(" ")) {
                    try {
                        intList.add(Integer.parseInt(input));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                list.add(intList);
            }
            scanner.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static boolean checkReport(List<Integer> list){
        boolean increasing = true;
        boolean decreasing = true;
        for(int i = 0; i < list.size() - 1; i++){
            int diff = list.get(i+1) - list.get(i);

            if(Math.abs(diff) < 1 || Math.abs(diff) > 3){
                return false;
            }

            if(diff < 0){
                increasing = false;
            }
            else if(diff > 0){
                decreasing = false;
            }
        }
        return increasing || decreasing;
        
    }

    public static boolean checkReportDamper(List<Integer> list){
        if(checkReport(list)){
            return true;
        }

        for(int i = 0; i < list.size(); i++){
            List<Integer> temp = new ArrayList<>(list);
            temp.remove(i);

            if(checkReport(temp)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();
        readFile(list);
        int sum = 0;
        for (List<Integer> smolL : list) {
            if(checkReportDamper(smolL)){
                sum += 1;
            }
        }
        System.out.println(sum);
    }
}
