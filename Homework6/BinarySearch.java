import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("Программа реализует бинарный поиск");
        System.out.println("Введите массив: ");
        int[] array = promtIntArray("Введите массив цифр, разделяя их пробелом: ");
        for (int i:
                array) {
            System.out.print(i + ", ");
        }
//        int[] array = new int[] {
//                1, 4, 7, 9
//        };
        System.out.println();
        System.out.println(binarySearch(array, 4));
    }

    private static int[] promtIntArray(String msg) throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        String text = scanner.nextLine();
        return Arrays.stream(text.split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
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
