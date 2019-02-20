package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wordCount.Comparator9000;
import wordCount.ConsolePrinter;
import wordCount.FileHandler;
import wordCount.Sorter;

class WordCountTest {
	private ConsolePrinter print;
	private Comparator9000 comp;
	private Sorter sort;
	private Map<String, Integer> testMap1;
	private Map<String, Integer> testMap2;
	
	@BeforeEach
	public void setup() {
		print = new ConsolePrinter();
		comp = new Comparator9000();
		testMap1 = new HashMap<String, Integer>();
		testMap2 = new HashMap<String, Integer>();
		sort = new Sorter();
		
		testMap1.put("A", 65);
		testMap1.put("B", 12);
		testMap1.put("C", 144);
		testMap1.put("D", 37);
		testMap1.put("E", 2);	
		
	}
	@Test
	public void testSorterMethod() {	
		
		testMap2 = sort.sortByComparator(testMap1);
		assertEquals(testMap1.values().toArray()[4], testMap2.values().toArray()[0]);
		assertEquals(testMap1.values().toArray()[1], testMap2.values().toArray()[1]);
		assertEquals(testMap1.values().toArray()[3], testMap2.values().toArray()[2]);
		assertEquals(testMap1.values().toArray()[0], testMap2.values().toArray()[3]);
		assertEquals(testMap1.values().toArray()[2], testMap2.values().toArray()[4]);
	}
	@Test
	public void testComparatorMethod() {
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(testMap1.entrySet());
		int result1 = comp.compare(list.get(0), list.get(1));
		int result2 = comp.compare(list.get(1), list.get(2));
		int result3 = comp.compare(list.get(2), list.get(3));
		int result4 = comp.compare(list.get(3), list.get(4));
		int result5 = comp.compare(list.get(4), list.get(0));
		
		assertEquals(1, result1);
		assertEquals(-1, result2);
		assertEquals(1, result3);
		assertEquals(1, result4);
		assertEquals(-1, result5);
		
	}
	@Test
	public void testConsolePrinter() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		print.printMapInReverseOrder(testMap1);
		
		assertEquals("The word \"E\" appears 2 times." + System.getProperty("line.separator") +
				     "The word \"D\" appears 37 times." + System.getProperty("line.separator") +
				     "The word \"C\" appears 144 times." + System.getProperty("line.separator") +
				     "The word \"B\" appears 12 times." + System.getProperty("line.separator") +
				     "The word \"A\" appears 65 times." + System.getProperty("line.separator"), os.toString());
	}

}
