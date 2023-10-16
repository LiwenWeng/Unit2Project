import java.util.InputMismatchException;
import java.util.Scanner;

public class LinearEquationLogic {
    LinearEquation linearEquation;
    Scanner scanner;

    public LinearEquationLogic() {
        linearEquation = new LinearEquation();
        scanner = new Scanner(System.in);
    }


    public void start() {
        displayInfo();

        double x;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter a third x-value: ");
                x = scanner.nextDouble();
                System.out.println("Solved coordinate point is: " + linearEquation.getPointWithX(x));
                validInput = true;
            } catch (InputMismatchException e) {
                Main.clearLine();
                scanner.nextLine();
            }
        }
    }


    private void displayInfo() {
        System.out.println("First pair: " + linearEquation.getFirstPair());
        System.out.println("Second pair: " + linearEquation.getSecondPair());
        System.out.println("Slope of line: " + linearEquation.getSlope());
        System.out.println("Y-intercept: " + linearEquation.getYIntercept());
        System.out.println("Slope intercept form: " + linearEquation.getSlopeInterceptForm());
        System.out.println("Distance between points: " + linearEquation.getDistanceBetweenPoints());
    }
}
