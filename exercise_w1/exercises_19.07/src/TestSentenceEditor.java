import org.junit.Test;

import junit.framework.Assert;

public class TestSentenceEditor {
	// CountOfCapitalA
	@Test
	public void sentenceEditorCountOfCapitalATest() {
		Assert.assertEquals(3, SentenceEditor.countOfCapitalA("AAAa"));
	}

	// ReplaceAWithAA
	@Test
	public void sentenceEditorReplaceAWithAATest() {
		Assert.assertEquals("AAs an AApple", SentenceEditor.replaceAWithAA("As an Apple"));
	}
	
	@Test
	public void sentenceEditorReplaceAWithAA_v2Test() {
		Assert.assertEquals("AAs an AApple", SentenceEditor.replaceAWithAA_v2("As an Apple"));
	}
	
	// words
	@Test
	public void sentenceEditorWordsTest() {
		String[] testWords = { "As", "an", "Apple" };
		for (int i = 0; i < 2; i++) {
			Assert.assertEquals(testWords[i], SentenceEditor.words("As an Apple")[i]);
		}
	}

	@Test
	public void sentenceEditorWordsTestWithTwoSpaces() {
		String[] testWords = { "As", "Apple" };
		for (int i = 0; i < 2; i++) {
			Assert.assertEquals(testWords[i], SentenceEditor.words("As  Apple")[i]);
		}
	}
	
	@Test
	public void sentenceEditorWordsTestWithNumberBetweenTwoWordsn() {
		String[] testWords = { "As", "Apple" };
		for (int i = 0; i < 2; i++) {
			Assert.assertEquals(testWords[i], SentenceEditor.words("As5Apple")[i]);
		}
	}

	@Test
	public void sentenceEditorWordsTestAboutNonAlphabeticCharacters() {
		String[] testWords = { "As", "Apple", "ok" };
		for (int i = 0; i < testWords.length; i++) {
			Assert.assertEquals(testWords[i], SentenceEditor.words("As\\12/Apple*9,\n45'{0}56(ok]")[i]);
		}
	}

	@Test
	public void sentenceEditorWordsTestWithArrayWithEmptyElements() {
		String[] testWords = { "As", "Apple" };
		for (int i = 0; i < testWords.length; i++) {
			Assert.assertEquals(testWords[i], SentenceEditor.words("/As/\\Apple")[i]);
		}
	}

	@Test
	public void sentenceEditorWordsTestForLongSentences() {
		String[] testWords = { "Wednesday", "is", "hump", "day", "but", "has", "anyone", "asked", "the", "camel", "if",
				"he", "s", "happy", "about", "it", "He", "turned", "in", "the", "research", "paper", "on", "Friday",
				"otherwise", "he", "would", "have", "not", "passed", "the", "class", "She", "was", "too", "short", "to",
				"see", "over", "the", "fence", "Wednesday", "is", "hump", "day", "but", "has", "anyone", "asked", "the",
				"camel", "if", "he", "s", "happy", "about", "it", "He", "turned", "in", "the", "research", "paper",
				"on", "Friday", "otherwise", "he", "would", "have", "not", "passed", "the", "class", "She", "was",
				"too", "short", "to", "see", "over", "the", "fence", "Wednesday", "is", "hump", "day", "but", "has",
				"anyone", "asked", "the", "camel", "if", "he", "s", "happy", "about", "it", "He", "turned", "in", "the",
				"research", "paper", "on", "Friday", "otherwise", "he", "would", "have", "not", "passed", "the",
				"class", "She", "was", "too", "short", "to", "see", "over", "the", "fence", "Wednesday", "is", "hump",
				"day", "but", "has", "anyone", "asked", "the", "camel", "if", "he", "s", "happy", "about", "it", "He",
				"turned", "in", "the", "research", "paper", "on", "Friday", "otherwise", "he", "would", "have", "not",
				"passed", "the", "class", "She", "was", "too", "short", "to", "see", "over", "the", "fence" };
		for (int i = 0; i < testWords.length; i++) {
			Assert.assertEquals(testWords[i],
					SentenceEditor.words("Wednesday is hump day, but has anyone asked the camel if he’s happy about it?"
							+ "He turned in the research paper on Friday; otherwise, he would have not passed the class."
							+ "She was too short to see over the fence."
							+ "Wednesday is hump day, but has anyone asked the camel if he’s happy about it?"
							+ "He turned in the research paper on Friday; otherwise, he would have not passed the class."
							+ "She was too short to see over the fence."
							+ "Wednesday is hump day, but has anyone asked the camel if he’s happy about it?"
							+ "He turned in the research paper on Friday; otherwise, he would have not passed the class."
							+ "She was too short to see over the fence."
							+ "Wednesday is hump day, but has anyone asked the camel if he’s happy about it?"
							+ "He turned in the research paper on Friday; otherwise, he would have not passed the class."
							+ "She was too short to see, over ,the ,fence.")[i]);
		}
	}

	// reverse
	@Test
	public void sentenceEditorReverseTest() {
		Assert.assertEquals("65 cba", SentenceEditor.reverse("abc 56"));
	}
}
