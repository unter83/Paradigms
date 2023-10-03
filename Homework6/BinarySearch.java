import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("Программа реализует бинарный поиск\n");
        int[] array = new int[] {1, 4, 7, 8, 9, 13, 15, 19};
        for (int i : array) {
            System.out.print(i + " ");
        }

        int number = promtInt("\nВведите число для поиска: ");

        System.out.println();

        int index = binarySearch(array, number);
        if (index >= 0)
            System.out.println("Число \"" + number + "\" находится на месте " + (index + 1));
        else
            System.out.println("Число \"" + number + "\" не найдено");
    }


    private static int promtInt(String msg) throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        return scanner.nextInt();
    }



    public static int  binarySearch(int[] array, int n) {
        return binarySearch(array, n, 0, array.length - 1);
    }


    public  static int binarySearch(int[] array, int n, int min, int max) {
        int midPoint;

        if (min > max)
            return -1;

        midPoint = (max - min) / 2 + min;

        if (array[midPoint] > n) {
            return binarySearch(array, n, min, midPoint - 1);
        }
        else {
            if (array[midPoint] < n) {
                return binarySearch(array, n, midPoint + 1, max);
            }
            else
                return midPoint;
        }

    }
}
