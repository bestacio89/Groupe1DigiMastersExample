package TPBasiqueJava;

public class Rotation {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3};
        int lastElement = array[array.length - 1];

        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = lastElement;

        for (int i : array) {
            System.out.println(i);
        }
    }
}
