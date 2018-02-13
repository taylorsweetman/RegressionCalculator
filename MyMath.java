        
package regressioncalculator;

import java.util.ArrayList;

//This class contains the math logic required for each statistic utilized in linear regression.

public class MyMath {

    private double xBar;
    private double yBar;
    private double xVar; //for each x in X: (x-xBar)^2
    private double yVar;
    private double xyCov; //for each x in X and y in Y: (x-xBar)*(y-yBar)
    private double beta1;
    private double beta0;
    private final ArrayList<Pair> myTable;
    private final int n;

    public MyMath(ArrayList<Pair> pairs) {
        myTable = pairs;
        n = myTable.size();
    }
    
    public double xBar() {
        double avg = 0;
        for (Pair pair : myTable) {
            avg += pair.getX();
        }
        avg /= n;
        xBar = avg;
        return xBar;
    }

    public double yBar() {
        double avg = 0;
        for (Pair pair : myTable) {
            avg += pair.getY();
        }
        avg /= n;
        yBar = avg;
        return yBar;
    }

    public double xVar() {
        double var = 0;
        for (Pair pair : myTable) {
            double diff = Math.pow(pair.getX() - xBar(), 2);
            var += diff;
        }
        var /= (n - 1);
        xVar = var;
        return xVar;
    }

    public double yVar() {
        double var = 0;
        for (Pair pair : myTable) {
            double diff = Math.pow(pair.getY() - yBar(), 2);
            var += diff;
        }
        var /= (n - 1);
        yVar = var;
        return yVar;
    }

    public double xyCov() {
        double cov = 0;
        for (int i = 0; i < n; i++) {
            double xDiff = myTable.get(i).getX() - xBar;
            double yDiff = myTable.get(i).getY() - yBar;
            cov += xDiff * yDiff;
        }
        cov /= (n - 1);
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
