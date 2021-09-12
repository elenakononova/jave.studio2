public class main {

    public static void main (String[] args){
        CharacterCounter myCharacterCounter = new CharacterCounter();
        //String myUsersInput = myCharacterCounter.getUserInput();
        // myCharacterCounter.countCharacters("My practice string");
        String myUsersInput = myCharacterCounter.getTextFromFile("example.txt");

        myCharacterCounter.countCharacters(myUsersInput);
    }
}
