public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private String coord1;
    private String coord2;


    public LinearEquation(String coord1, String coord2) {
        this.coord1 = coord1;
        this.coord2 = coord2;
        setXY();
    }


    private void setXY() {
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
        return roundToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    public double getYIntercept() {
        return roundToHundredth(y1 - (getSlope() * x1));
    }

    public String getSlopeInterceptForm() {
        if (x1 == x2) {
            return "x = " + x1;
        }
        if (y1 == y2) {
            return "y = " + getYIntercept();
        }

        String slope = getSlopeString();

        String yIntercept = " + " + getYIntercept();
        if (getYIntercept() == 0) {
            yIntercept = "";
        } else if (getYIntercept() < 0) {
            yIntercept = " - " + Math.abs(getYIntercept());
        }

        return "y = " + slope + yIntercept;
    }

    private String getSlopeString() {
        int deltaX = x2 - x1;
        int deltaY = y2 - y1;
        int gcd = gcd(deltaX, deltaY);
        deltaX /= gcd;
        deltaY /= gcd;

        String slope = deltaY + "/" + deltaX + "x";
        if (deltaY < 0 && deltaX < 0) {
            slope = (Math.abs(deltaY)) + "/" + (Math.abs(deltaX)) + "x";
        } else if (deltaX < 0) {
            slope = "-" + deltaY + "/" + (Math.abs(deltaX)) + "x";
        }
        if (getSlope() % 1 == 0) {
            slope = (int) getSlope() + "x";
        }
        if (getSlope() == 1) {
            slope = "x";
        } else if (getSlope() == -1) {
            slope = "-x";
        }
        return slope;
    }


    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    public double getDistanceBetweenPoints() {
        return roundToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }


    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    private double roundToHundredth(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}