package src;

public class Main extends GUI {
    public static void main(String[] args) {
        GUI gui = new GUI();

        Checker checker = new Checker(gui);
        while (!checker.checkSimpleGameWinner()) {
        }
    }
}



