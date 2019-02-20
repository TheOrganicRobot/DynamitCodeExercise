package wordCount;

import java.util.Comparator;
import java.util.Map.Entry;

public class Comparator9000 implements Comparator<Entry<String, Integer>> {
	
	//-----------------COMPARE METHOD, USED BY SORTER TO DETERMINE WHICH VALUE IS LARGER--------------------
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		return o1.getValue().compareTo(o2.getValue());
	}
}
