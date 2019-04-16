package calculator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//defines data structure of x, y pairs
@Entity(name = "input_table")
public class Pair {

    private double X;
    private double Y;
    private int index;

    @Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIndex() {
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
    
    public void setIndex(int input) {
    	this.index = input;
    }
    
    public void setX(double x) {
    	this.X = x;
    }
    
    public void setY(double y) {
    	this.Y = y;
    }
}
