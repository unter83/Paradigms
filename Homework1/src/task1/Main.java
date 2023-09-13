package task1;

//

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Программа реализует сортировку в 2-х стилях: императивном и в декларативном стиле\n");

        List<Integer> listOne = new ArrayList<Integer>();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            int num = rnd.nextInt(10) - rnd.nextInt(10);
            System.out.print(num + " ");
            listOne.add(num);
        }
        System.out.println("\nИмперативный стиль:");
        imperativeBubbleSearch(listOne);
        System.out.println(listOne);

        System.out.println();

        List<Integer> listTwo = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int num = rnd.nextInt(10) - rnd.nextInt(10);
            System.out.print(num + " ");
            listTwo.add(num);
        }
        System.out.println("\nДекларативный стиль:");
        declarativeBubbleSearch(listTwo);
        System.out.println(listTwo);
    }

    static void imperativeBubbleSearch(List<Integer> list) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    finish = false;
                }
            }
        } while (!finish);
    }

    static void declarativeBubbleSearch(List<Integer> list) {
        Collections.sort(list);
    }
}
