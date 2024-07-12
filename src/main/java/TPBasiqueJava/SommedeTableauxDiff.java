package TPBasiqueJava;

public class SommedeTableauxDiff {
    public static void main(String[] args) {
        int[] array1 = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};
        int[] array2 = {-1, 12, 17, 14, 5, -9, 0, 18};
        int minLength = Math.min(array1.length, array2.length);
        int[] sumArray = new int[minLength];

        for (int i = 0; i < minLength; i++) {
            sumArray[i] = array1[i] + array2[i];
        }

        for (int i : sumArray) {
            System.out.println(i);
        }
    }
}
