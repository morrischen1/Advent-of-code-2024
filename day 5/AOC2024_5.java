import java.io.File;
import java.io.FileNotFoundException;
import java.util.stream.Collectors;
import java.util.*;

public class AOC2024_5 {
    public static List<List<Integer>> extract_data_1(){
        List<List<Integer>> list1 = new ArrayList<>();
            try{
                File file = new File("data_1.txt");
                Scanner scanner = new Scanner(file);
                while(scanner.hasNext()){
                    String data = scanner.nextLine();
                    List<Integer> temp = Arrays.stream(data.split("\\|"))
                                            .map(String::trim)
                                            .filter(s -> !s.isEmpty()) 
                                            .map(s -> Integer.parseInt(s))
                                            .collect(Collectors.toList());

                    list1.add(temp);
    
                }
                scanner.close();
                
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
                System.out.println("empty");
            }
            return list1;
        }
    
    public static List<List<Integer>> extract_data_2(){
        List<List<Integer>> list2 = new ArrayList<>();
        try{
            File file = new File("data_2.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String data = scanner.nextLine();
                List<Integer> temp = Arrays.stream(data.split(","))
                                       .map(String::trim)
                                       .map(s -> Integer.parseInt(s))
                                       .collect(Collectors.toList());
                list2.add(temp);

            }
            scanner.close();
            
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("empty");
        }
        return list2;
    }

    public static int summarize_part1(List<List<Integer>> list1, List<List<Integer>> list2){
        int sum = 0;
        for(List<Integer> update : list2){
            boolean isValid = true;

            for(List<Integer> rule : list1){
                int num1 = rule.get(0);
                int num2 = rule.get(1);

                if(update.contains(num1) && update.contains(num2)){
                    if(update.indexOf(num1) >= update.indexOf(num2)){
                        isValid = false;
                        break;
                    }
                }
            }
            if(isValid){
                sum += update.get(update.size() / 2);
            }
        }

        return sum;
    }

    public static void main(String[] args){
        List<List<Integer>> list1 = extract_data_1();
        List<List<Integer>> list2 = extract_data_2();
        int sum = summarize_part1(list1, list2);
        System.out.println(sum);

    }
}
