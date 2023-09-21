import java.util.HashMap;

public class Table {

    HashMap<Integer, String> table = new HashMap<Integer, String>();

    public Table() {
        table.put(1, "1");
        table.put(2, "2");
        table.put(3, "3");
        table.put(4, "4");
        table.put(5, "5");
        table.put(6, "6");
        table.put(7, "7");
        table.put(8, "8");
        table.put(9, "9");
    }

    public String get(int index) {
        return table.get(index);
    }

    public void put(int index, String symbol) {
        table.put(index, symbol);
    }

    public boolean isSlotEmpty(int slot) {
        if (table.get(slot).equals("X") || table.get(slot).equals("O"))
            return false;
        else
            return true;
    }
}
