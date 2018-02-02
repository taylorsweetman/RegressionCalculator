package regressioncalculator;

import java.util.ArrayList;

public class Storage {

    private final ArrayList<Pair> table;
    private int n;
    private final MyMath myMath;

    public Storage() {
        table = new ArrayList<>();
        myMath = new MyMath(this);
        n = 0;
    }

    public void add(Pair input) {
        table.add(input);
    }

    public ArrayList<Pair> getTable() {
        return table;
    }

    public int getN() {
        n = table.size();
        return n;
    }
    
    @Override
    public String toString() {
        String str = "";
        for (Pair entry : table) {
            str += "x" + getN() + "--" + entry.getX() + "\ny" + getN() + "--" + entry.getY() + "\n";
            getN();
        }
        str += "xBar: " + myMath.xBar() + " yBar: " + myMath.yBar() + " xVar: " + myMath.xVar() + " yVar: " + myMath.yVar() + " xyCov: " + myMath.xyCov() + "\n";
        str += "y = " + myMath.beta0() + " + " + myMath.beta1() + " * x\n";
        return str;
    }
}
