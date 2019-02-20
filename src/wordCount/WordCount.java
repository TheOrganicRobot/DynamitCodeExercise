package wordCount;

import java.util.Map;

public class WordCount {
	
	//-----------------MAIN METHOD, RUNS THE PROGRAM--------------------
	public static void main(String[] args) {
		runProgram();
	}
	
	//-----------------PRIVATE METHOD, CALLS ALL CLASSES--------------------
	private static void runProgram() {
		FileHandler file = new FileHandler();
		Sorter sort = new Sorter();
		ConsolePrinter print = new ConsolePrinter();

		Map<String, Integer> unsortMap = file.getAndParseFile();
		Map<String, Integer> sortedMapAsc = sort.sortByComparator(unsortMap);
		print.printMapInReverseOrder(sortedMapAsc);
	}
}
