public class Main {
    public static void main(String[] args) {
        LinearEquationLogic linearEquationLogic = new LinearEquationLogic();
        linearEquationLogic.start();
    }

    public static void clearLine() {
        System.out.print("\u001b[1A\u001b[2K");
    }

    public static void clearScreen() {
        System.out.print("\u001b[2J\u001b[1000A");
    }
}