import java.util.Scanner;

public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private String coord1;
    private String coord2;
    private Scanner scanner;


    public LinearEquation() {
        scanner = new Scanner(System.in);
        setValues();
    }


    private void setValues() {
        Main.clearScreen();
        System.out.println("Enter your coordinate point in this format: (a, b)");
        String coord1 = repeatUntilCoord("Enter your first Coordinate Point: ", "", true);
        String coord2 = repeatUntilCoord("Enter your second Coordinate Point: ", "", true);
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

    private String repeatUntilCoord(String message, String coord, boolean initial) {
        while (!coord.matches("\\(\\d+,[ ]]?\\d+\\)")) {
            if (!initial) {
                Main.clearLine();
            }
            initial = false;
            System.out.print(message);
            coord = scanner.nextLine();
        }
        return coord;
    }

    public String getFirstPair() {
        return coord1.replaceAll("\\s", "");
    }

    public String getSecondPair() {
        return coord2.replaceAll("\\s", "");
    }

    public String getPointWithX(double x) {
        double y = (getSlope() * x) + getYIntercept();
        return String.format("(%1$.2f, %2$.2f)", x, y);
    }

    public double getSlope() {
        return Math.round((double) (y2 - y1) / (x2 - x1) * 100.0) / 100.0;
    }

    public double getYIntercept() {
        return Math.round((y1 - (getSlope() * x1)) * 100.0) / 100.0;
    }

    public String getSlopeInterceptForm() {
        String slope = ((getSlope() % 1) == 0) ? Integer.toString((int) getSlope()) : String.format("%1$d/%2$d", y2-y1, x2-x1);
        return String.format("y = %sx + %.2f", slope, getYIntercept());
    }

    public double getDistanceBetweenPoints() {
        return Math.round(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) * 100.0) / 100.0;
    }
}