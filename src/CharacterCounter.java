import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class CharacterCounter {
    // class Variables

    // Constructor
    public CharacterCounter () {

    }

    // methods
    public void countCharacters(String wordToCount) {
        //make it case-insensitive
        wordToCount = wordToCount.toLowerCase();
        char[] arrayOfChars = wordToCount.toCharArray();
        HashMap<Character, Integer> myCharacterCount = new HashMap<>();
        for (int i = 0; i< arrayOfChars.length; i++) {
            // add or update count of each character into the hash map

            // Exclude non characters
            if(Character.isLetter(arrayOfChars[i]) == false){
                //Exclude it
                continue;
            }

            char theCharacter = arrayOfChars[i];
            if (myCharacterCount.containsKey(theCharacter) == false) {
                // does not contain any key
                myCharacterCount.put(theCharacter, 1);
            } else {
                // does contain key
                Integer theValue = myCharacterCount.get(theCharacter);
                theValue = theValue + 1;
                myCharacterCount.put(theCharacter, theValue);

            }

        }
        ArrayList<Character> myCharacterKeys = new ArrayList<>(myCharacterCount.keySet());
        for(int i = 0; i < myCharacterKeys.size(); i++){
            Integer theValue = myCharacterCount.get(myCharacterKeys.get(i));
            System.out.println(myCharacterKeys.get(i) + ": " + theValue);
        }

    }

    public String getUserInput() {
        Scanner myScanner = new Scanner(System.in);

        String myUsersInput = myScanner.nextLine();

        myScanner.close();
        return myUsersInput;
    }

    // method to read form txt file
    public String getTextFromFile(String pathToTheFile){
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(pathToTheFile)));
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return content;
    }

}
