import java.util.Scanner;


public class ConsoleInterface {

    private final Table table;


    public ConsoleInterface(Table table) {
        this.table = table;
        showGreetengs();
        showTable();
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
        }
    }

    public void showVictory(User user) {
        System.out.println("\nИгрок \"" + user.getSymbol() + "\" победил\n");
        System.exit(0);
    }

    public void showDraw() {
        System.out.println("\nНичья!\n");
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
