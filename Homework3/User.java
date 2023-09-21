public class User {

    private String symbol;

    Table table;
    public User(Table table, String symbol) {
        this.table = table;
        this.symbol = symbol;
    }

    public void makeTurn(int slot) {
        table.put(slot, symbol);
    }

    public String getSymbol() {
        return symbol;
    }
}
