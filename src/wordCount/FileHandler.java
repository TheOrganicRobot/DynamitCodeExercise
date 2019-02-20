package wordCount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileHandler {
	
	//-----------------FILE AND PARSE FILE METHOD, TAKES FILE AND DELIMITS, PARSES, AND SPLITS INTO A MAP
	//-----------------OF INDIVIDUAL WORDS AND COUNTS OF THOSE WORDS AS KEY/VALUE PAIR
	public Map<String, Integer> getAndParseFile() {

		Map<String, Integer> unsortMap = new HashMap<String, Integer>();
		String fileLocation = "src/wordCount/Paragraph.txt";
		File Paragraph = new File(fileLocation);
		Scanner scanner = null;
		int count = 1;

		try {
			scanner = new Scanner(Paragraph);
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, file doesn't exist.");
		}
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] array = line.split("[\\.,\\s!;?:\"-]+"); // ("\\W+") can be used as a non-word literal, but parses out conjunctions
			for (String word : array) {

				if (unsortMap.containsKey(word)) {
					unsortMap.put(word.toLowerCase(), unsortMap.get(word) + 1);
				} else if (!unsortMap.containsKey(word)) {
					unsortMap.put(word.toLowerCase(), count);
				}
			}
		}
		return unsortMap;
	}
}
