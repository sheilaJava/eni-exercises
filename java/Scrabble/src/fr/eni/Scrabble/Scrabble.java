package fr.eni.Scrabble;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Scrabble {
    static List<String> dictionaryWords = new ArrayList<String>();
    static Random random = new Random();
    static String[] dictionary;
    static char[] randomWord;
    static char[] shuffledLetters;
    static String playerWord;

    public static void main(String[] args) {
        // Create array from dictionary
        dictionary = createDictionaryArray();

        // Get a random word from dictionary
        randomWord = getRandomWord(dictionary);

        // Shuffle random word's letters
        shuffledLetters = shuffleLetters(randomWord);

        // Display shuffled letters
        System.out.println(shuffledLetters);

        do {
            // Get player's input
            Scanner stringInput = new Scanner(System.in);
            System.out.println("Entrez un mot en utilisant les lettres tirées");
            playerWord = stringInput.nextLine().toUpperCase();

            // Verify player's input and display result
            if (verifyLetters(playerWord.toCharArray(), shuffledLetters) && verifyWord(playerWord.toCharArray(), dictionary)) {
                System.out.println("Le mot le plus long possible est : " + new String(randomWord));
            } else {
                System.out.println("Ce mot n'est pas conforme, recommencez");
            }

        } while (!verifyLetters(playerWord.toCharArray(), shuffledLetters) || !verifyWord(playerWord.toCharArray(), dictionary));
    }

    static String[] createDictionaryArray() {
        try {
            FileInputStream file = new FileInputStream("./dictionnaire.txt");
            Scanner fileScan = new Scanner(file);
            while (fileScan.hasNextLine()) {
                dictionaryWords.add(fileScan.nextLine());
            }
            return dictionaryWords.toArray(new String[0]);
        } catch (IOException exception) {
            return new String[]{"bonjour", "chat", "voiture", "orange", "Soupe"};
        }
    }

    static char[] getRandomWord(String[] dictionary) {
        int randomInt = random.nextInt(dictionary.length);
        return dictionary[randomInt].toUpperCase().toCharArray();
    }

    static char[] shuffleLetters(char[] word) {
        char[] randomWordCopy = Arrays.copyOf(word, word.length);
        for (int i = 0; i < randomWordCopy.length; i++) {
            char holder = randomWordCopy[i];
            int randomInt = random.nextInt(randomWordCopy.length);
            randomWordCopy[i] = randomWordCopy[randomInt];
            randomWordCopy[randomInt] = holder;
        }
        return randomWordCopy;
    }

    static boolean verifyLetters(char[] playerWord, char[] letters) {
        char[] lettersCopy = Arrays.copyOf(letters, letters.length);
        int j = 0;
        boolean verify = true;
        while (verify && j < playerWord.length) {
            int k = 0;
            while (k < lettersCopy.length && playerWord[j] != lettersCopy[k]) {
                k++; }
            if (k == lettersCopy.length) verify = false;
            else {
                lettersCopy[k] = '0';
                j++; }
        }
        return verify;
    }

    static boolean verifyWord(char[] playerWord, String[] dictionary) {
        for (String word : dictionary) {
            if (Objects.equals(word.toUpperCase(), new String(playerWord))) {
                return true;
            }
        }
        return false;
    }
}
