package calculator.domain;

public class Pair {

    private final double X;
    private final double Y;
    private final String description;
    private final double variable;

    //this constructor is used to create x, y input pairs when reading input from the user
    public Pair(double x, double y) {
        this.X = x;
        this.Y = y;
        this.description = "";
        this.variable = 0;
    }

    //this constructor is used to create descriptive statistics for display to the user -> consider re-factoring this function to a new class
    public Pair(String desc, double var) {
        this.description = desc;
        this.variable = var;
        this.X = 0;
        this.Y = 0;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getVariable() {
        return variable;
    }

    public String getDescription() {
        return description;
    }
}
