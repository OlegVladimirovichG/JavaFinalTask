import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalTask {
    public static void main(String[] args) throws FileNotFoundException {
        Notebook notebook = new Notebook();
        notebook.readFile();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int choice = menu(scanner);
            System.out.println();
            switch (choice) {
                case 1 -> notebook.printFile(notebook.nb);
                case 2 -> filtration(notebook, scanner);
                case 0 -> {
                    flag = false;
                    System.out.println("Спасибо, приходите ещё!");
                }
            }
        }
    }

    private static int menu(Scanner input) {
        System.out.println("Выберите пункт меню:");
        System.out.print("""
                1. Отобразить доступные ноутбуки
                2. Поиск ноутбука по заданным параметрам
                0. Выход из программы
                : """);
        return input.nextInt();
    }

    private static void filtration(Notebook book, Scanner input) {
        System.out.println("Выберите параметр поиска: ");
        book.printFields();
        System.out.print(": ");
        int choose = input.nextInt() - 1;
        System.out.println();
        ArrayList<String> resultSearch = book.findParameters(choose);
        book.printSet(resultSearch, choose);
        System.out.print(": ");
        String chooseParam = resultSearch.get(input.nextInt() - 1);
        System.out.println();
        ArrayList<String[]> result = book.findFiltered(choose, chooseParam);
        book.printFile(result);
    }
}