package TPBasiqueJava;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseList {

    public static void main(String[] args) {
        // Create a list of characters
        List<Character> characters = new ArrayList<>();
        characters.add('A');
        characters.add('B');
        characters.add('C');
        characters.add('D');
        characters.add('E');

        // Print the original list
        System.out.println("Original List: " + characters);

        // Reverse the list
        Collections.reverse(characters);

        // Print the reversed list
        System.out.println("Reversed List: " + characters);
    }
}
