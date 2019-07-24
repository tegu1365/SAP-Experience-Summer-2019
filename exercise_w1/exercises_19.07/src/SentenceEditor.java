import java.util.*;

public class SentenceEditor {
	static String sentence = new String();

	public static void main(String[] args) {
		input();
		output();
	}

	static void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input sentence: ");
		sentence = scan.nextLine();
	}
	
	static void output() {
		System.out.printf("Count Of Capital A in the sentence is: %d\n\n",countOfCapitalA(sentence));
		System.out.printf("Sentence replace A With AA looks like this:\n%s\n\n",replaceAWithAA(sentence));
		System.out.printf("Reversed sentence looks like this:\n%s\n\n",reverse(sentence));
		System.out.println("All words in the sentence are: ");
		String[] wordsInTheSentence=words(sentence);
		for(int i=0; i<wordsInTheSentence.length;i++){
			System.out.println(wordsInTheSentence[i]);
		}

	}

	static int countOfCapitalA(String text) {
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == 'A') {
				count++;
			}
		}
		return count;
	}

	static String replaceAWithAA(String text) {
		return text.replaceAll("A", "AA");
	}
	
	static String replaceAWithAA_v2(String text) {
		StringBuilder newText=new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == 'A') {
				newText.append(text.charAt(i));
			}
			newText.append(text.charAt(i));
		}
		return newText.toString();
	}

	static String[] words(String text) {
		text = text.replaceAll("[0-9]", " ");
		String[] wordsFromText = Arrays.stream(text.split("\\W+")).filter(x -> !x.isEmpty()).toArray(String[]::new);
		return wordsFromText;
	}

	static String reverse(String text) {
		StringBuilder reverseText = new StringBuilder();
		for (int i = text.length() - 1; i >= 0; i--) {
			reverseText.append(text.charAt(i));
		}
		return reverseText.toString();
	}
}
