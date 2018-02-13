package regressioncalculator;

/* This class defines "Pair" objects. Since regression will always have an x-y pair for each index of input, 
this is a logical data structure to store the input from the user. Since this data structure is already defined, I also
utilized it to return the output statistics in the format ("Description of Statistic", value of statistic)*/

public class Pair {

    private final double X;
    private final double Y;
    private final String description;
    private final double value;

    //Overloaded Pair constructor. One takes input pairs, one takes output pairs.
    public Pair(double x, double y) {
        this.X = x;
        this.Y = y;
        this.description = "";
        this.value = 0;
    }

    public Pair(String desc, double var) {
        this.description = desc;
        this.value = var;
        this.X = 0;
        this.Y = 0;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
