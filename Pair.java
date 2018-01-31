package regressioncalculator;

public class Pair {
    private final double X;
    private final double Y;

    public Pair(String x, String y) {
        this.X = Double.parseDouble(x);
        this.Y = Double.parseDouble(y);

    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

}
