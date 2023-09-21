public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        User user1 = new User(table, "X");
        User user2 = new User(table, "O");
        Controller controller = new Controller(table, user1, user2);
        controller.run();
    }
}
