package calculator.domain;

import java.util.ArrayList;
import calculator.logic.CalculatorProcesses;

public class Main {
	
	public static void main(String[] args) {
		CalculatorProcesses processes = new CalculatorProcesses();
		ArrayList<Pair> listOfInputPairs = processes.inputProcess();
		ArrayList<OutputStat> listOfStats = processes.mathProcess(listOfInputPairs);
		processes.outputProcess(listOfInputPairs, listOfStats);
	}

}
