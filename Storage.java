package regressioncalculator;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Pair> table;
    private int n;
    private Math myMath;

    public Storage() {
        table = new ArrayList<>();
        myMath = new Math(this);
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

    @Override
    public String toString() {
        String str = "";
        int n = 0;
        for (Pair entry : table) {
            str += "x" + n + "--" + entry.getX() + "\ny" + n + "--" + entry.getY() + "\n";
            n++;
        }
        str += myMath.xBar();
        return str;
    }
}
