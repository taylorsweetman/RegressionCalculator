package regressioncalculator;

import java.util.ArrayList;

public class MyMath {

    private Storage myData;
    private double xBar;
    private double yBar;
    private double xVar; //for each x in X: (x-xBar)^2
    private double yVar;
    private double xyCov; //for each x in X and y in Y: (x-xBar)*(y-yBar)
    private double beta1;
    private double beta0;

    public MyMath(Storage inputData) {
        myData = inputData;

    }

    public double xBar() {
        double avg = 0;
        for (Pair group : myData.getTable()) {
            avg += group.getX();
        }
        avg /= myData.getTable().size();
        xBar = avg;
        return xBar;
    }

    public double yBar() {
        double avg = 0;
        for (Pair group : myData.getTable()) {
            avg += group.getY();
        }
        avg /= myData.getTable().size();
        yBar = avg;
        return yBar;
    }

    public double xVar() {
        double var = 0;
        for (Pair group : myData.getTable()) {
            double diff = Math.pow(group.getX() - xBar(),2);
            var += diff;
        }

        var /= (myData.getN() - 1);
        xVar = var;
        return xVar;
    }

    public double yVar() {
        double var = 0;
        for (Pair group : myData.getTable()) {
            double diff = Math.pow(group.getY() - yBar(),2);
            var += diff;
        }

        var /= (myData.getN()-1);
        yVar = var;
        return yVar;
    }

    public double xyCov() {
        double cov = 0;
        ArrayList<Pair> myTable = myData.getTable();

        for (int i = 0; i < myData.getN(); i++) {
            Pair myPair = myTable.get(i);

            double xDiff = myPair.getX() - xBar;
            double yDiff = myPair.getY() - yBar;

            cov += xDiff * yDiff;
        }

        cov /= myData.getN() - 1;
        xyCov = cov;
        return xyCov;
    }

    public double beta1() {  //xyCov / xVar
        beta1 = xyCov() / xVar();
        return beta1;
    }

    public double beta0() {  //yBar - beta1 * xBar
        beta0 = yBar() - beta1() * xBar();
        return beta0;
    }

}
