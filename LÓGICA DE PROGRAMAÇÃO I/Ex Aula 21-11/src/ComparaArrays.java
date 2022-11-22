public class ComparaArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7};
        //int[] array2 = {2, 4, 6, 8};
        int[] array2 = {1, 3, 5, 7};
        System.out.println(comparaArrays(array1, array2));
    }
    private static boolean comparaArrays(int[] array1, int array2[]) {

        if (array1.length == array2.length) {
            for (int index = 0; index < array1.length; index++) {
                if (array1[index] != array2[index]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
