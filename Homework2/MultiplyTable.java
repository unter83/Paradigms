public class MultiplyTable {
    public static void main(String[] args) {
        System.out.println("Программа выводит таблицу умножения\n");

        for (int i = 1; i <= 10; i+=5) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(j + " х " + i + " = " + i * j + " \t\t"
                        + j + " х " + (i + 1) + " = " + (i + 1) * j + " \t\t"
                        + j + " х " + (i + 2) + " = " + (i + 2) * j + " \t\t"
                        + j + " х " + (i + 3) + " = " + (i + 3) * j + " \t\t"
                        + j + " х " + (i + 4) + " = " + (i + 4) * j + " \t\t");
            }
            System.out.println();
        }

    }


}
