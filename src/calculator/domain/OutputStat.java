package calculator.domain;

public class OutputStat {
	
	private final String description;
	private final double value;
	
	public OutputStat(String desc, double val) {
		this.description = desc;
		this.value = val;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getValue() {
		return value;
	}

}
