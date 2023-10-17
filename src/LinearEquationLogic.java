import java.util.InputMismatchException;
import java.util.Scanner;

public class LinearEquationLogic {
    LinearEquation linearEquation;
    Scanner scanner;

    public LinearEquationLogic() {
        scanner = new Scanner(System.in);
    }


    public void start() {
        String again = "";
        while (!again.equals("n")) {
            getCoords();
            displayInfo();
            getYValueWithX();
            System.out.println();
            while (!again.equals("y")) {
                Main.clearLine();
                System.out.print("Would you like to enter another pair of coordinates? (y/n): ");
                again = scanner.nextLine();
                if (again.equals("n")) break;
            }
        }
    }


    private void getCoords() {
        Main.clearScreen();
        System.out.println("Enter your coordinate point in this format: (a, b)");
        String coord1 = repeatUntilCoord("Enter your first Coordinate Point: ", "", true);
        String coord2 = repeatUntilCoord("Enter your second Coordinate Point: ", "", true);

        linearEquation = new LinearEquation(coord1, coord2);
    }


    private String repeatUntilCoord(String message, String coord, boolean initial) {
        while (!coord.matches("\\(-?\\d+,([ -]| -)?\\d+\\)")) {
            if (!initial) {
                Main.clearLine();
            }
            initial = false;
            System.out.print(message);
            coord = scanner.nextLine();
        }
        return coord;
    }


    private void displayInfo() {
        System.out.println();
        System.out.println("First pair: " + linearEquation.getFirstPair());
        System.out.println("Second pair: " + linearEquation.getSecondPair());
        System.out.println("Slope of line: " + linearEquation.getSlope());
        System.out.println("Y-intercept: " + linearEquation.getYIntercept());
        System.out.println("Slope intercept form: " + linearEquation.getSlopeInterceptForm());
        System.out.println("Distance between points: " + linearEquation.getDistanceBetweenPoints());
        System.out.println();
    }


    private void getYValueWithX() {
        double x;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter a third x-value: ");
                x = scanner.nextDouble();
                System.out.println("Solved coordinate point is: " + linearEquation.getPointWithX(x));
                validInput = true;
                scanner.nextLine();
            } catch (InputMismatchException e) {
                Main.clearLine();
                scanner.nextLine();
            }
        }
    }
}
