package calculator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//defines data structure of output statistics in the form of ("description", value)
@Entity(name = "output_table")
public class OutputStat {
	
	private String description;
	private double value;
	private int index;
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIndex() {
		return index;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	
	@Column(name = "value")
	public double getValue() {
		return value;
	}
	
	public void setIndex(int input) {
		this.index = input;
	}
	
	public void setDescription(String input) {
		this.description = input;
	}
	
	public void setValue(double input) {
		this.value = input;
	}
}
