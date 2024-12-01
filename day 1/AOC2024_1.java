import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AOC2024_1{

    public static void readFile(List<String> list1, List<String> list2){
        try{
            File file = new File("\\Advent Of Code 2024\\day 1\\list.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] temp = data.split("   ");
                list1.add(temp[0]);
                list2.add(temp[1]);
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static List<Integer> sortListToInteger(List<String> list){
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            temp.add(Integer.parseInt(list.get(i)));
        }
        Collections.sort(temp);
  
        return temp;
    }

    public static int sum(List<Integer> left, List<Integer> right){
        int sum = 0;
        for(int i = 0; i < left.size(); i++){
            int temp = (left.get(i) - right.get(i));
            if(temp < 0){
                temp *= -1;
            }
            sum += temp;
        }
        return sum;
    }

    public static int similarity_score(List<Integer> left, List<Integer> right){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < right.size(); i++){
            if(map.containsKey(right.get(i))){
                map.put(right.get(i), map.get(right.get(i)) + 1);
            }
            else{
                map.putIfAbsent(right.get(i), 1);
            }
        }

        int similarity_score = 0;
        for(int i = 0; i < left.size(); i++){
            if(map.containsKey(left.get(i))){
                similarity_score += left.get(i) * map.get(left.get(i));
            }
        }
        return similarity_score;
    }

    public static void main(String[] args){
        List<String> left = new ArrayList<>();
        List<String> right = new ArrayList<>();

        readFile(left, right);

        List<Integer> leftInt = sortListToInteger(left);
        List<Integer> rightInt = sortListToInteger(right);

        System.out.println(similarity_score(leftInt, rightInt));
    }
}