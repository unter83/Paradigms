import java.util.Scanner;


public class ConsoleInterface {

    private Table table;
    private User user1;
    private User user2;


    public ConsoleInterface(Table table, User user1, User user2) {
        this.table = table;
        this.user1 = user1;
        this.user2 = user2;
        showGreetengs();
        showTable();
//        int slot;
//        while (true) {
//            showTable();
//            slot = chooseSlot();
//            user1.makeTurn(slot);
//            showTable();
//            slot = chooseSlot();
//            user2.makeTurn(slot);
//        }
    }


    public void showGreetengs() {
        System.out.println("Игра \"Крестики-нолики\"\n");
    }

    public void showTable() {
        int count = 1;
        for (int i = 1; i <= table.getRank()*table.getRank(); i++) {
            System.out.print(" ");
            if (count == table.getRank()) {
                System.out.println(table.get(i));
                count = 1;
            }
            else {
                System.out.print(table.get(i) + " | ");
                count++;
            }
//            System.out.print(" ");
//            for (int j = 1; j <= table.getRank() * i; j++) {
//                System.out.print(table.get(j));
////                if (j != table.getRank() - 1)
////                    System.out.print(" | ");
////                else
////                    System.out.print(" ");
//            }
            //System.out.println();
 //           System.out.println(" " + table.get(i) + " | " + table.get(i + 1) + " | " + table.get(i + 2) + " ");
        }
    }

    public void showVictory(User user) {
        System.out.println("\nИгрок \"" + user.getSymbol() + "\" победил\n");
        System.exit(0);
    }

    public void showTurn(User user) {
        System.out.println("\nИгрок \"" + user.getSymbol() + "\" делает ход\n");
    }

    public int chooseSlot(User user){
        while (true) {
            try {
                int slot = promtInt("\nИгрок \"" + user.getSymbol() + "\", выберите ячейку: ");
                if ((slot >= 1 && slot <= 9 && table.isSlotEmpty(slot)))
                    return slot;
                else
                    System.out.println("Проверьте правильность ввода");
            } catch (NumberFormatException e) {
                System.out.println("Проверьте правильность ввода");
            }

        }
    }

    private int promtInt(String msg) throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        String text = scanner.nextLine();
        text = text.replace(" ", "");
        return Integer.parseInt((text));
    }


}
