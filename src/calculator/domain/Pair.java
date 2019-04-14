package calculator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "input_table")
public class Pair {

    private final double X;
    private final double Y;
    private final int index;

    //this constructor is used to create x, y input pairs when reading input from the user
   

    @Column(name = "id")
	@Id
    public int getIdx() {
    	return index;
    }

    @Column(name = "x_value")
    public double getX() {
        return X;
    }

    @Column(name = "y_value")
    public double getY() {
        return Y;
    }
    
    public void setX(double x) {
    	this.X = x;
    }
}
