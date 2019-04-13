        
package calculator.logic;

import java.util.ArrayList;
import calculator.domain.Pair;
 
public class MathLogic {

    private final ArrayList<Pair> arrayOfInputPairs; // can this be replaced with a DB???
    private int n; //number of observation pairs

    public MathLogic(ArrayList<Pair> xyPairs) {
        arrayOfInputPairs = xyPairs;
        n = arrayOfInputPairs.size();
    }

    //average x value
    public double xBar() {
        double avg = 0;
        
        for (Pair pair : arrayOfInputPairs) {
            avg += pair.getX();
        }
        
        avg /= n;
        return avg;
    }

    //average y value
    public double yBar() {
        double avg = 0;
        
        for (Pair pair : arrayOfInputPairs) {
            avg += pair.getY();
        }
        
        avg /= n;
        return avg;
    }

    //variance of X -> for each x in X: (x - xBar)^2
    public double xVar() {
        double var = 0;
        
        for (Pair pair : arrayOfInputPairs) {
            double diff = Math.pow(pair.getX() - xBar(), 2);
            var += diff;
        }
        
        var /= (n - 1);
        return var;
    }

    //variance of Y -> for each y in Y: (y - yBar)^2
    public double yVar() {
        double var = 0;
        
        for (Pair pair : arrayOfInputPairs) {
            double diff = Math.pow(pair.getY() - yBar(), 2);
            var += diff;
        }
        
        var /= (n - 1);
        return var;
    }

    //co-variance of X and Y -> for each x in X and y in Y: (x - xBar) * (y - yBar)
    public double xyCov() {
        double cov = 0;

        for (int i = 0; i < n; i++) {
            double xDiff = arrayOfInputPairs.get(i).getX() - xBar();
            double yDiff = arrayOfInputPairs.get(i).getY() - yBar();
            cov += xDiff * yDiff;
        }
        
        cov /= (n - 1);
        return cov;
    }

    //slope of regression line
    public double beta1() {
        double beta1 = xyCov() / xVar();
        return beta1;
    }

    //vertical intercept
    public double beta0() {
        double beta0 = yBar() - beta1() * xBar();
        return beta0;
    }
}
