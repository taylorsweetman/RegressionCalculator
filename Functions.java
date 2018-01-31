package regressioncalculator;

import java.util.Scanner;

public class Functions {
    
    private Storage myData;
    
    public void Functions(){
        
    }

    public void inputProcess() {
        Scanner reader = new Scanner(System.in);
        this.myData = new Storage();
        int n = 0;

        System.out.println("Enter x - y value pairs. When finished, enter a instead of a number.");

        while (true) {
            System.out.println("Enter x" + n);
            String input1 = reader.nextLine();
            if (input1.equals("a")) {
                break;
            }
            System.out.println("Enter y" + n);
            String input2 = reader.nextLine();
            if (input2.equals("a")) {
                break;
            }
            Pair xyPair = new Pair(input1, input2);
            myData.add(xyPair);
            n++;
        }
        myData.add(n);
    }
    
     @Override
    public String toString() {
        String str = "";
        int n = 0;
        for (Pair entry : myData.getTable()) {
            str += "x" + n + "--" + entry.getX() + "\ny" + n + "--" + entry.getY() + "\n";
            n++;
        }
        str += n;
        return str;
    }

}
