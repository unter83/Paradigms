public class Controller {
    private Table table;
    private User user1;
    private User user2;
    ConsoleInterface console;

    int step = 1;

    public Controller(Table table, User user1, User user2) {
        this.table = table;
        this.user1 = user1;
        this.user2 = user2;
        this.console = new ConsoleInterface(table, user1, user2);
    }

    public void run() {
        while (true) {
            int slot;
            if (step % 2 != 0) {
                slot = console.chooseSlot(user1);
                user1.makeTurn(slot);
                console.showTurn(user1);
            } else {
                slot = console.chooseSlot(user2);
                user2.makeTurn(slot);
                console.showTurn(user2);
            }
            console.showTable();
            step++;
        }
    }

    public boolean checkVictory() {
        if (step < 6)
            return false;

    }

    public int getStep() {
        return step;
    }





}
