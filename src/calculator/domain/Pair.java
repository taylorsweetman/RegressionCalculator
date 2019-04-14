package calculator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "input_table")
public class Pair {

    private double X;
    private double Y;
    private int index;

    @Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    public void setY(double y) {
    	this.Y = y;
    }
    
    public void setIdx(int idx) {
    	this.index = idx;
    }
}
