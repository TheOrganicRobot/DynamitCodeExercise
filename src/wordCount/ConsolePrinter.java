package wordCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConsolePrinter {
	
	//-----------------PRINT METHOD, TAKES MAP GIVEN AND PRINTS IN REVERSE ORDER. USED ON SORTED METHOD FOR DESCENDING VALUES--
	public void printMapInReverseOrder(Map<String, Integer> mapToPrint) {
		List<String> keyList = new ArrayList<String>(mapToPrint.keySet());
		for (int i = keyList.size() - 1; i >= 0; i--) {
			
			String key = keyList.get(i);
			Integer value = mapToPrint.get(key);
			if (value == 1) {
				System.out.println("The word \"" + key + "\" appears " + value + " time.");
			} else {
				System.out.println("The word \"" + key + "\" appears " + value + " times.");
			}
		}
	}
}
