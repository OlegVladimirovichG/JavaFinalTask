import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Notebook {
    ArrayList<String[]> nb = new ArrayList<>();
    String[] fields = {"Производитель", "Модель", "Экран", "CPU", "GPU", "RAM", "SSD", "OS", "Цвет", "Цена"};

    public void readFile() throws FileNotFoundException {
        File nb_BD = new File("D:/учеба/GB/TheFinalTest/JavaFinalTask/JavaFinalTask");
        Scanner sc = new Scanner(nb_BD);
        while (sc.hasNextLine()) {
            String[] tmp = sc.nextLine().split(" - ");
            nb.add(tmp);
        }sc.close();
    }

    public void printFile(ArrayList<String[]> forPrint) {
        int c = 1;
        for (String[] notebook : forPrint) {
            System.out.printf("#%d\n", c);
            for (int i = 0; i < notebook.length; i++) {
                System.out.printf("%s: %s\n", fields[i], notebook[i]);
            }
            System.out.println();
            c++;
        }
    }
    public void printFields(){
        for (int i = 0; i < fields.length; i++) {
            System.out.printf("%d: %s\n", i+1, fields[i]);
        }
    }
    public ArrayList<String> findParameters(int index){
        ArrayList<String> result = new ArrayList<>();
        Set<String> tmpSet = new HashSet<>();
        for (String[] notebook : nb) {
            tmpSet.add(notebook[index]);
        }
        for (String item : tmpSet ) {
            result.add(item);
        }
        return result;
    }
    public void printSet(ArrayList<String> set, int index){
        int c = 1;
        System.out.printf("%s:\n", fields[index]);
        for (String i : set) {
            System.out.printf("%d: %s\n", c, i);
            c++;
        }
    }
    public ArrayList<String[]> findFiltered(int index, String searchStr){
        ArrayList<String[]> result = new ArrayList<>();
        for (String[] notebook : nb){
            if (notebook[index].equals(searchStr)){
                result.add(notebook);
            }
        }
        return result;
    }
}