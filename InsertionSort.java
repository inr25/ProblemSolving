public class InsertionSort {
    public static void main(String[] args) {
        int[] lUnSortedArray = { 25, 86, 1, 4, 0, 6 };
        int[] lSortedArray;
        lSortedArray = insertionSort(lUnSortedArray);
        System.out.print("Sorted Array : ");
        for (int i : lSortedArray) {
            System.out.print(i + ", ");
        }
    }

    public static int[] insertionSort(int[] pIntArray) {
        for (int i = 1; i < pIntArray.length; i++) {
            for (int j = i; j > 0; j--) {
                int lValContainer;
                if (pIntArray[j] < pIntArray[j-1]) {
                    lValContainer = pIntArray[j];
                    pIntArray[j] =pIntArray[j-1];
                    pIntArray[j-1] = lValContainer;
                }
            }

        }
        return pIntArray;
    }
}
