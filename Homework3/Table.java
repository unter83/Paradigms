import java.util.HashMap;

public class Table {

    private HashMap<Integer, String> table = new HashMap<Integer, String>();
    private int rank;
    private int size;

    private final String[][] array;

    public int getSize() {
        return size;
    }

    public Table(int rank) {
        this.size = rank*rank;
        this.rank = rank;
        for (int i = 1; i <= size; i++) {
            table.put(i, String.valueOf(i));
        }
        array = new String[rank][rank];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = table.get(++k);
            }
        }

    }
    public String get(int index) {
        return table.get(index);
    }

    public void put(int index, String symbol) {
        table.put(index, symbol);
        putToArray(index, symbol);
    }

    public boolean isSlotEmpty(int slot) {
        if (table.get(slot).equals("X") || table.get(slot).equals("O"))
            return false;
        else
            return true;
    }

    private void putToArray(int slot, String symbol) {

        int[] index = calculateArrayIndex(slot);
        array[index[0]][index[1]] = symbol;
    }

    int[] calculateArrayIndex(int slot) {
        int[] index = new int[2];
        int row = -1;
        int col = 0;

        for (int i = 1; i <= rank; i++) {
            if (slot % rank == i)
                col = i - 1;
            if (slot % rank == 0)
                col = rank - 1;
        }

        if (col < 0) throw  new RuntimeException("Произошла чудовищная ошибка!");

//        System.out.println("Колонка " + col);
        row = (slot - col - 1) / rank;
//        System.out.println("Строка " + row);
        index[0] = row;
        index[1] = col;
        return index;
    }

    public void showArray() {
        for (String[] strings : array) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(strings[j] + " . ");
            }
            System.out.println();
        }
    }

    public boolean checkMainDag(String symbol) {
        int symbolCount = 0;
//        System.out.println("Проверка победи по главной диагонали");
        for (int i = 0; i < array.length; i++) {
             if (array[i][i].equals(symbol))
                 symbolCount++;
        }
//        System.out.println("Количество " + symbol + " " + symbolCount);
        return symbolCount == rank;
    }

    public boolean checkSecondDag(String symbol) {
        int symbolCount = 0;
//        System.out.println("Проверка победи по второстепенной диагонали");
        for (int i = 0; i < array.length; i++) {
            if (array[array.length - i - 1][i].equals(symbol))
                symbolCount++;
        }
//        System.out.println("Количество " + symbol + " " + symbolCount);
        return symbolCount == rank;
    }

    public boolean checkColumn(int slot, String symbol) {
        int[] index = calculateArrayIndex(slot);
        int symbolCount = 0;
//        System.out.println("Проверка победы по вертикали");
        for (int i = 0; i < array.length; i++) {
            if (array[i][index[1]].equals(symbol))
                symbolCount++;
        }
//        System.out.println("Количество " + symbol + " " + symbolCount);
        return symbolCount == rank;
    }

    public boolean checkRow(int slot, String symbol) {
        int[] index = calculateArrayIndex(slot);
        int symbolCount = 0;
//        System.out.println("Проверка победы по горизонтали");
        for (int i = 0; i < array.length; i++) {
            if (array[index[0]][i].equals(symbol))
                symbolCount++;
        }
//        System.out.println("Количество " + symbol + " " + symbolCount);
        return symbolCount == rank;
    }



//    private void fullTableArray() {
//        int count = 1;
//        for (int i = 1; i <= rank; i++) {
//            for (int j = 0; j <= rank ; j++) {
//                table_array[i][j] = table.get(count);
//                count++;
//            }
//        }
//    }


    public int getRank() {
        return rank;
    }


}
