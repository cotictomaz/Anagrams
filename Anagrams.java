import java.util.Scanner;


public class Anagrams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = Integer.parseInt(args[0]);
        //int n = 15;
        System.out.println("Insert the word of which you want to get the anagrams: ");
        String word = scanner.nextLine();
        //String[] anagrams = AnagramGenerator.computeAnagrams(word, n);
        String[] anagrams = AnagramGenerator.computeAllAnagrams(word);
        scanner.close();
        for (String anagram : anagrams) {
            System.out.println(anagram);
        }
    }
}

//Se la usi come classe unica, senza AnagramGenerator quindi
/*
public class Anagrams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(args[0]);
        System.out.println("Insert the word of which you want to get the anagrams: ");
        String word = scanner.nextLine();
        String wordLowerCase = word.toLowerCase();
        BigInteger permutationsPossible = factorial(wordLowerCase.length());//numberOfPermutations(wordLowerCase);
        if (BigInteger.valueOf(n).compareTo(permutationsPossible) >= 0) {
            System.out.println("There aren't " + n + " anagrams of the given word. You will get the "
                    + permutationsPossible + " possible.");
            n = permutationsPossible.intValue();
        }
        int[] counter = {n}; 
        printAnagrams(wordLowerCase, "", counter);
        scanner.close();
    }
    
    private static void printAnagrams(String word, String anagramToPrint, int[] contatore) {
        if (contatore[0] == 0) {
            System.exit(0);
        }
        if (word.length() == 0) {
            char firstLetter = anagramToPrint.charAt(0);
            firstLetter = Character.toUpperCase(firstLetter);
            anagramToPrint = firstLetter + anagramToPrint.substring(1);
            System.out.println(anagramToPrint);
            contatore[0] = contatore[0] - 1;
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            String remainingLetters = word.substring(0, i) + word.substring(i + 1);
            printAnagrams(remainingLetters, anagramToPrint + ch, contatore);           
        }
    }

    private static BigInteger factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}
*/


/*Serve solo se non vuoi contare le ripetizioni
    private static BigInteger numberOfPermutations(String word) {
        int length = word.length();
        int[] occurencies = new int[length];
        char[] charWord = word.toCharArray();
        String temp = "";
        for (int i = 0; i < length; i++) {
            int letterOccurencies = 0;
            if (!temp.contains(String.valueOf(charWord[i]))) {
                for (int j = i + 1; j < length; j++) {
                    if (charWord[i] == charWord[j]){
                        letterOccurencies += 1;
                    }
                }
                temp += charWord[i];
            }
            occurencies[i] = letterOccurencies + 1;
        }
        BigInteger denum = BigInteger.ONE;
        for (int i = 0; i < length; i++) {
            denum = denum.multiply(factorial(occurencies[i]));
        }
        BigInteger m = factorial(length);
        BigInteger permutations = m.divide(denum);
        return permutations;
    }
    */