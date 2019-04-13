package calculator.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class Pair {

    private final double X;
    private final double Y;
    private final int index;

    //this constructor is used to create x, y input pairs when reading input from the user
    public Pair(double x, double y, int index) {
        this.X = x;
        this.Y = y;
        this.index = index;
    }

    @Column(name = "id")
	@Id
    public int getIdx() {
    	return index;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }
}
