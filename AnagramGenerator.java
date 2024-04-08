/* Realizza una classe che genera n anagrammi, e viene poi usato dall'altra classe per stampare gli anagrammi*/

import java.math.BigInteger;

public class AnagramGenerator {

    public static String[] computeAllAnagrams(String word) {
        BigInteger permutations = factorial(word.length());
        int numberOfAnagrams = permutations.intValue();
        int[] counter = { numberOfAnagrams - 1 };
        String[] anagrams = new String[numberOfAnagrams];
        computeAnagramsAusiliary(word, "", counter, anagrams);
        return anagrams;
    }

    public static String[] computeAnagrams(String word, int n) {
        int numberOfAnagrams = assignNumberOfAnagrams(word, n);
        int[] counter = { numberOfAnagrams - 1 };
        String[] anagrams = new String[numberOfAnagrams];
        computeAnagramsAusiliary(word, "", counter, anagrams);
        return anagrams;
    }

    private static void computeAnagramsAusiliary(String word, String anagramToPrint, int[] counter, String[] anagrams) {
        if (counter[0] == -1) {
            return;
        }
        if (word.length() == 0) {
            char firstLetter = anagramToPrint.charAt(0);
            firstLetter = Character.toUpperCase(firstLetter);
            anagramToPrint = firstLetter + anagramToPrint.substring(1);
            anagrams[counter[0]] = anagramToPrint;
            counter[0] = counter[0] - 1;
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            String remainingLetters = word.substring(0, i) + word.substring(i + 1);
            computeAnagramsAusiliary(remainingLetters, anagramToPrint + ch, counter, anagrams);
        }
    }

    private static int assignNumberOfAnagrams(String word, int n) {
        BigInteger permutationsPossible = factorial(word.length());
        if (BigInteger.valueOf(n).compareTo(permutationsPossible) >= 0) {
            System.out.println("There aren't " + n + " anagrams of the given word. You will get the "
                    + permutationsPossible + " possible.");
            n = permutationsPossible.intValue();
        }
        return n;
    }

    private static BigInteger factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

}
