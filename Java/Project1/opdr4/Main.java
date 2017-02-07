package opdr4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("## Starting Program U-4 ##\n");
		roteerNaarLinks("oliebol", 1);
		roteerNaarLinks("oliebol", 3);
		roteerNaarRechts("oliebol", 3);
	}

	public static void roteerNaarRechts(String input, int n) {
		String[] strArray = input.split("");
		List<String> wordList = new LinkedList<String>(Arrays.asList(strArray));
		for (int i = 0; i < n  ; i++) {
			wordList.add(0, wordList.get(wordList.size() - 1));
			wordList.remove(wordList.size() - 1);
		}

		printArray(wordList);
	}

	public static void roteerNaarLinks(String input, int n) {
		String[] strArray = input.split("");
		List<String> wordList = new LinkedList<String>(Arrays.asList(strArray));
		for (int i = 0; i < n  ; i++) {
			wordList.add(wordList.get(0));
			wordList.remove(0);
		}

		printArray(wordList);
	}

	public static void printArray(List<String> input) {
		for (String e : input) {
			System.out.print(e);
		}
		System.out.println();
	}
}
