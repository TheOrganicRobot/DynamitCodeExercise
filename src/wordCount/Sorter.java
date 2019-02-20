package wordCount;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Sorter {
	
	//-----------------SORT METHOD, TAKES MAP AND SORTS BY VALUES--------------------
	public Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {

		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

		Collections.sort(list, new Comparator9000());

		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}