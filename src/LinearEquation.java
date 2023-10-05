import java.util.InputMismatchException;
import java.util.Scanner;

public class LinearEquation {
    // Variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private String coord1;
    private String coord2;
    private Scanner scanner;

    // ----------------------------------------

    // Constructor
    public LinearEquation(Scanner scanner) {
        this.scanner = scanner;
    }

    // ----------------------------------------

    // Calculate any values
    public double getSlope(int x1, int y1, int x2, int y2) {
        return Math.round((double) (y2 - y1) / (x2 - x1) * 100.0) / 100.0;
    }

    public double getYIntercept(int x, int y, double slope) {
        return Math.round((x - (slope * y)) * 100.0) / 100.0;
    }

    public String getSlopeInterceptForm(int x1, int y1, int x2, int y2) {
        return String.format("y = %1$d/%2$dx + %3$.2f", y2 - y1, x2 - x1, getYIntercept(x1, y1, getSlope(x1, y1, x2, y2)));
    }

    public double getDistanceBetweenPoints(int x1, int y1, int x2, int y2) {
        return Math.round(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) * 100.0) / 100.0;
    }

    // ----------------------------------------
    /* Inputted coordinates program */

    // These methods are used for inputted values
    private void setValues(String coord1, String coord2) {
        this.coord1 = coord1;
        this.coord2 = coord2;

        // Remove whitespaces
        coord1 = coord1.replaceAll("\\s", "");
        coord2 = coord2.replaceAll("\\s", "");
        // Then split them into an array of [x, y]
        String[] extracted1 = coord1.substring(1, coord1.length() - 1).split(",");
        String[] extracted2 = coord2.substring(1, coord2.length() - 1).split(",");
        // Set xs and ys
        x1 = Integer.parseInt(extracted1[0]);
        y1 = Integer.parseInt(extracted1[1]);
        x2 = Integer.parseInt(extracted2[0]);
        y2 = Integer.parseInt(extracted2[1]);
    }

    private String getFirstPair() {
        return coord1.replaceAll("\\s", "");
    }

    private String getSecondPair() {
        return coord2.replaceAll("\\s", "");
    }

    private String getPointWithX(double x) {
        double y = (getSlope() * x) + getYIntercept();
        return String.format("(%1$.2f, %2$.2f)", x, y);
    }

    private double getSlope() {
        return Math.round((double) (y2 - y1) / (x2 - x1) * 100.0) / 100.0;
    }

    private double getYIntercept() {
        return Math.round((x1 - (getSlope() * y1)) * 100.0) / 100.0;
    }

    private String getSlopeInterceptForm() {
        String slope = ((getSlope() % 1) == 0) ? Integer.toString((int) getSlope()) : String.format("%1$d/%2$d", y2-y1, x2-x1);
        return String.format("y = %sx + %.2f", slope, getYIntercept());
    }

    private double getDistanceBetweenPoints() {
        return Math.round(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) * 100.0) / 100.0;
    }

    // Display
    private void displayInfo() {
        System.out.println("First pair: " + getFirstPair());
        System.out.println("Second pair: " + getSecondPair());
        System.out.println("Slope of line: " + getSlope());
        System.out.println("Y-intercept: " + getYIntercept());
        System.out.println("Slope intercept form: " + getSlopeInterceptForm());
        System.out.println("Distance between points: " + getDistanceBetweenPoints());
    }

    // This keeps asking user until they put in the correct format
    // and if they do returns it
    private String repeatUntilCoord(String message, String coord, boolean initial) {
        while (!coord.matches("\\(\\d+, ?\\d+\\)")) {
            if (!initial) {
                Main.clearLine();
            }
            initial = false;
            System.out.print(message);
            coord = scanner.nextLine();
        }
        return coord;
    }

    // Initialize program
    public void Init() {
        Main.clearScreen();
        System.out.println("Enter your coordinate point in this format: (a, b)");
        String coord1 = repeatUntilCoord("Enter your first Coordinate Point: ", "", true);
        String coord2 = repeatUntilCoord("Enter your second Coordinate Point: ", "", true);
        setValues(coord1, coord2);

        displayInfo();

        double x;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter a third x-value: ");
                x = scanner.nextDouble();
                System.out.println("Solved coordinate point is: " + getPointWithX(x));
                validInput = true;
            } catch (InputMismatchException e) {
                Main.clearLine();
                scanner.nextLine();
            }
        }
    }
}