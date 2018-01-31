package regressioncalculator;

public class Math {

    private double xBar;
    private double yBar;
    private double xVar; //for each x in X: (x-xBar)^2
    private double yVar;
    private double xyCov; //for each x in X and y in Y: (x-xBar)*(y-yBar)
    private double beta1; //xyCov / xVar
    private double beta0; //yBar - beta1 * xBar

    public Math() {

    }

    public double xBar() {
        return 0;
    }

    public double yBar() {
        return 0;
    }

    public double xVar() {
        return 0;
    }

    public double yVar() {
        return 0;
    }

    public double xyCov() {
        return 0;
    }

    public double beta1() {
        return 0;
    }

    public double beta0() {
        return 0;
    }

    
}
