package regressioncalculator;

import java.util.ArrayList;

public class Storage {

    private final ArrayList<Pair> table;

    public Storage() {
        table = new ArrayList<>();
    }

    public void add(Pair input) {
        table.add(input);
    }
    
    @Override
    public String toString(){
        String str = "";
        int n = 0;
        for (Pair entry:table){
            str += "x" + n + "--" + entry.getX() + "\ny" + n + "--" + entry.getY() + "\n";
            n++;
        }
        return str;
    }

}
