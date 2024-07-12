package TPBasiqueJava;

public class ExcerciseDeclarationTableImproved {
    public static void main(String[] args) {
        // Declare an array of integers containing the values
        int[] declarationTable = {8, -7, 12, 1, -2, 14, 17, 9};

        // Display the element at index 0
        System.out.println("Element at index 0: " + declarationTable[0]);

        // Display all elements of the array using a loop
        for (int element : declarationTable) {
            System.out.println(element);
        }

        // Display the length of the array (number of elements)
        System.out.println("Length of the array: " + declarationTable.length);
    }
}

