package regressioncalculator;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Pair> table;
    private int n;

    public Storage() {
        table = new ArrayList<>();
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
}
