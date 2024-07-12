package TPBasiqueJava;

public class InversionContenu {
    public static void main(String[] args) {
        int[] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};
        int[] arrayCopy = new int[array.length];

        // Copier les éléments de array dans arrayCopy mais dans l’ordre inverse
        for (int i = 0; i < array.length; i++) {
            arrayCopy[i] = array[array.length - 1 - i];
        }

        // Afficher les éléments des deux tableaux
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : arrayCopy) {
            System.out.print(i + " ");
        }
    }
}
