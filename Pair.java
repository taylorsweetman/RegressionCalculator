package regressioncalculator;

import java.util.ArrayList;

public class Pair {

    private final double X;
    private final double Y;
    private int index = 0;
    private final ArrayList<Pair> table = new ArrayList<>();
    private MyMath calculator;

    public Pair(double x, double y) {
        this.X = x;
        this.Y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public void addToTable() {
        ++index;
        table.add(this);
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public int getIndex() {
        return index;
    }

    public double getN() {
        int n = 0;
        for (Pair pair : table) {
            if (pair.index > n) {
                n = pair.index;
            }
        }
        return n;
    }

    public ArrayList<Pair> getTable() {
        return table;
    }

    @Override
    public String toString() {
        String str = "";
        calculator = new MyMath(this);
        for (Pair entry : table) {
            str += "x" + getN() + "--" + entry.getX() + "\ny" + getN() + "--" + entry.getY() + "\n";
            getN();
        }
        str += "xBar: " + calculator.xBar() + " yBar: " + calculator.yBar() + " xVar: " + calculator.xVar() + " yVar: " + calculator.yVar() + " xyCov: " + calculator.xyCov() + "\n";
        str += "y = " + calculator.beta0() + " + " + calculator.beta1() + " * x\n";
        return str;
    }
}
