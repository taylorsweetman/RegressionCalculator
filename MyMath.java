package regressioncalculator;

public class MyMath {

    private final Pair xyPairs;
    private double xBar;
    private double yBar;
    private double xVar; //for each x in X: (x-xBar)^2
    private double yVar;
    private double xyCov; //for each x in X and y in Y: (x-xBar)*(y-yBar)
    private double beta1;
    private double beta0;

    public MyMath(Pair xyPairs) {
        this.xyPairs = xyPairs;
    }

    public double xBar() {
        double avg = 0;
        for (Pair pair : xyPairs.getTable()) {
            avg += xyPairs.getX();
        }
        avg /= xyPairs.getN();
        xBar = avg;
        return xBar;
    }

    public double yBar() {
        double avg = 0;
        for (Pair pair : xyPairs.getTable()) {
            avg += pair.getY();
        }
        avg /= xyPairs.getN();
        yBar = avg;
        return yBar;
    }

    public double xVar() {
        double var = 0;
        for (Pair pair : xyPairs.getTable()) {
            double diff = Math.pow(pair.getX() - xBar(), 2);
            var += diff;
        }
        var /= (xyPairs.getN() - 1);
        xVar = var;
        return xVar;
    }

    public double yVar() {
        double var = 0;
        for (Pair pair : xyPairs.getTable()) {
            double diff = Math.pow(pair.getY() - yBar(), 2);
            var += diff;
        }
        var /= (xyPairs.getN() - 1);
        yVar = var;
        return yVar;
    }

    public double xyCov() {
        double cov = 0;

        for (int i = 0; i < xyPairs.getN(); i++) {
            double xDiff = xyPairs.getX() - xBar;
            double yDiff = xyPairs.getY() - yBar;
            cov += xDiff * yDiff;
        }
        cov /= xyPairs.getN() - 1;
        xyCov = cov;
        return xyCov;
    }

    public double beta1() {
        beta1 = xyCov() / xVar();
        return beta1;
    }

    public double beta0() {
        beta0 = yBar() - beta1() * xBar();
        return beta0;
    }

}
