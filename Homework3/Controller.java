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
                console.showTable();
                if (checkVictory(slot, user1))
                    console.showVictory(user1);
            } else {
                slot = console.chooseSlot(user2);
                user2.makeTurn(slot);
                console.showTurn(user2);
                console.showTable();
                if (checkVictory(slot, user2))
                    console.showVictory(user2);
            }
            step++;

//            table.showArray();
        }
    }

    public boolean checkVictory(int slot, User user) {
        boolean victory = false;
        if (step < 2 * table.getRank() - 1)
            return victory;

        if (slot  == (table.getSize()) / 2 + 1) {
            victory = table.checkMainDag(user.getSymbol())
                    || table.checkSecondDag(user.getSymbol())
                    || table.checkColumn(slot, user.getSymbol())
                    || table.checkRow(slot, user.getSymbol());
        }

        if (!victory && (slot  == 1 || slot == table.getSize())) {
            victory = table.checkMainDag(user.getSymbol())
                    || table.checkColumn(slot, user.getSymbol())
                    || table.checkRow(slot, user.getSymbol());
        }

        if (!victory && (slot  == table.getRank() || slot == table.getSize() - table.getRank() + 1)) {
            victory = table.checkSecondDag(user.getSymbol())
                    || table.checkColumn(slot, user.getSymbol())
                    || table.checkRow(slot, user.getSymbol());
        }

        if (!victory) {
            victory = table.checkColumn(slot, user.getSymbol()) || table.checkRow(slot, user.getSymbol());
        }

        return victory;
    }

    public int getStep() {
        return step;
    }





}
