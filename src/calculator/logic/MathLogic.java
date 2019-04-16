        
package calculator.logic;

import java.util.ArrayList;
import calculator.domain.Pair;
 
public class MathLogic {

    private final ArrayList<Pair> arrayOfInputPairs; 
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
            double squaredDifference = Math.pow(pair.getX() - xBar(), 2);
            var += squaredDifference;
        }
        
        var /= (n - 1);
        return var;
    }

    //variance of Y -> for each y in Y: (y - yBar)^2
    public double yVar() {
        double var = 0;
        
        for (Pair pair : arrayOfInputPairs) {
            double squaredDifference = Math.pow(pair.getY() - yBar(), 2);
            var += squaredDifference;
        }
        
        var /= (n - 1);
        return var;
    }

    //co-variance of X and Y -> for each x in X and y in Y: (x - xBar) * (y - yBar)
    public double xyCov() {
        double cov = 0;

        for(Pair pair : arrayOfInputPairs) {
        	double xDifference = pair.getX() - xBar();
        	double yDifference = pair.getY() - yBar();
        	cov += xDifference * yDifference;
        }
        
        cov /= (n - 1);
        return cov;
    }

    //slope of regression line
    public double beta1() {
        return xyCov() / xVar();
    }

    //vertical intercept
    public double beta0() {
        return yBar() - beta1() * xBar();
    }
    
    //y value predicted by regression model
    public double yHat(double xValue) {
    	return beta0() + beta1() * xValue;
    }
    
    //total sum of squares
    public double SSTO() {
    	double ssto = 0;
        
        for (Pair pair : arrayOfInputPairs) {
            double squaredDifference = Math.pow(pair.getY() - yBar(), 2);
            ssto += squaredDifference;
        }
        
        return ssto;
    }
    
    //sum of squares explained by model (regression sum of squares)
    public double SSR() {
    	double ssr = 0;
    	
    	for (Pair pair : arrayOfInputPairs) {
    		double squaredDifference = Math.pow(yHat(pair.getX()) - yBar(), 2);
    		ssr += squaredDifference;
    	}
    	
    	return ssr;
    }
    
    //co-efficient of determination (goodness of fit)
    public double rSquared() {
    	return SSR()/SSTO();
    }
}
