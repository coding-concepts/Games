import java.util.Random;
import java.util.Scanner;

public class Hangman {

    String secretWord = "";
    final int MAX_TRIES = 6;
    int takenChances = 0;
    final char DASH = '-';
    String alreadyGuessedCharacters = "";
    String userAnswerString = "";

    // source https://emojipedia.org/
    final String HEART = "♥";
    final String BROKEN_HEART = "♡";
    final String CRY_FACE = "😭";
    final String HAPPY_FACE = "☺️️";

    public void play()  {
        // get a secretWord.
        secretWord = getSecretWord();

        // now that we have a secret word, lets setup the Dashes
        setupBlankAnswerString();

        // display some messages to the user
        displayWelcomeMessage();


        while (gameIsNotOver()) {

            // display the board
            displayBoard();

            // take an input from User
            String  currentGuess  = askForUserInput();

            // if the user types the same letter, then we ask again
            if (alreadyGuessed(currentGuess)){
                continue;
            }

            // this means user has not guessed this letter
            addToGuessedLetters(currentGuess);

            if (correctGuess(currentGuess)){
                System.out.println("You Got that !!!");
                replaceDashes(currentGuess);
            } else {
                looseALife();
            }
        } // end of the loop

        if (lost()) {
            System.out.println("You Lost. " + CRY_FACE + " The word was :"+secretWord);
        } else {
            displayBoard();
            System.out.println("You Won !!! " + HAPPY_FACE );

        }

    }

    private boolean lost() {
        return MAX_TRIES <= takenChances;
    }

    private void looseALife() {
        takenChances++;
    }

    private void addToGuessedLetters(String currentGuess) {
        alreadyGuessedCharacters += currentGuess  + " ";
    }

    private boolean alreadyGuessed(String currentGuess) {
        return alreadyGuessedCharacters.contains(currentGuess);
    }

    private boolean gameIsNotOver() {
        //game is not iver if (user has not guessed the andwer and the max tries are not over
        return ( (MAX_TRIES > takenChances) &&  ! (userAnswerString.equalsIgnoreCase(secretWord)));
    }

    private void setupBlankAnswerString() {
        for (char c : secretWord.toCharArray()){
            userAnswerString += DASH;
        }
    }

    private String getSecretWord() {
        // lets create an array of words.
         String[] words = {"candy", "pizza", "pasta", "cake", "icecream", "rice", "banana", "apple", "sandwich", "corn", "jam", "bread"};

        return words[new Random().nextInt(words.length)].toUpperCase();
    }

    private void replaceDashes(String currentGuess) {
        // currentGuess is always a character
        char currentChar = currentGuess.charAt(0);

        //string cant change letters. do lets use a string builder
        StringBuilder sb = new StringBuilder(userAnswerString);

        for (int i = 0; i < secretWord.length(); i++){
            char x = secretWord.charAt(i);
            if (secretWord.charAt(i) == currentChar){
                sb.setCharAt(i, currentChar);
            }
        }
        userAnswerString = sb.toString().toUpperCase();
    }

    private boolean correctGuess(String currentGuess) {
        return secretWord.toUpperCase().contains(currentGuess.toUpperCase());
    }


    private void displayWelcomeMessage(){
        System.out.println("******************************************");
        System.out.println("**                                      **");
        System.out.println("**          H A N G M A N               **");
        System.out.println("**                                      **");
        System.out.println("**         Category : Food              **");
        System.out.println("**                                      **");
        System.out.println("******************************************");
    }

    private String askForUserInput() {
        String input;

        do {
            System.out.print("Enter a character: ");
            Scanner s = new Scanner(System.in);
             input = s.nextLine();
        } while (input == null || input.length() ==0);

        return input.toUpperCase().charAt(0)+"";
    }

    private void displayBoard() {
        printBlankLines(5);
        printStringWithASpace(userAnswerString, true);
        printBlankLines(1);
        System.out.print("Lives Left : ");
        //printStringWithASpace(getString(BROKEN_HEART, takenChances), false);
        printStringWithASpace(getString(BROKEN_HEART, MAX_TRIES - takenChances) , true);
        System.out.println("Guessed Letters:"+alreadyGuessedCharacters);


        System.out.println("Lost Life : "+takenChances);
    }

    private String getString(String c, int count){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++){
            sb.append(c);
        }
        return sb.toString();
    }

    private void printBlankLines(int n){
        for (int i = 0; i < n; i++){
            System.out.println();
        }
    }

    private void printStringWithASpace(String str, boolean isNextLine) {
        for (char c : str.toCharArray() ) {
            System.out.print(c+" ");
        }
        if (isNextLine) {
            System.out.println();
        }
    }

}
