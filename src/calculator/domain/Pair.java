package calculator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "input_table")
public class Pair {

    private double X;
    private double Y;
    private int index;
    private int runId;

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
    
    @Column(name = "run_id")
    public int getRunId() {
    	return runId;
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
    
    public void setRunId(int id) {
    	this.runId = id;
    }
}
