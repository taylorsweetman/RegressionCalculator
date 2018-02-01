package regressioncalculator;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Pair> table;
    private int n;
    private MyMath myMath;

    public Storage() {
        table = new ArrayList<>();
        myMath = new MyMath(this);
    }

    public void add(Pair input) {
        table.add(input);
    }

    public void add(int n) {
        this.n = n;
    }

    public ArrayList<Pair> getTable() {
        return table;
    }

    public int getN() {
        return n;
    }
    
    @Override
    public String toString() {
        String str = "";
        int n = 0;
        for (Pair entry : table) {
            str += "x" + n + "--" + entry.getX() + "\ny" + n + "--" + entry.getY() + "\n";
            n++;
        }
        str += "xBar: " + myMath.xBar() + " yBar: " + myMath.yBar() + " xVar: " + myMath.xVar() + " yVar: " + myMath.yVar() + " xyCov: " + myMath.xyCov() + "\n";
        str += "y = " + myMath.beta0() + " + " + myMath.beta1() + " * x\n";
        return str;
    }
}
