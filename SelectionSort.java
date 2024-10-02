public class SelectionSort {
    public static void main(String[] args) {
        int[] lUnSortedArray = { 25, 86, 1, 4, 0, 6 };
        int[] lSortedArray;
        lSortedArray = selectionSort(lUnSortedArray);
        System.out.print("Sorted Array : ");
        for (int i : lSortedArray) {
            System.out.print(i + ", ");
        }
    }

    public static int[] selectionSort(int[] pIntArray) {

        for (int i = 0; i < pIntArray.length; i++) {
            int lTempContainer = -1, lValContainer = pIntArray[i];
            for (int j = i + 1; j < pIntArray.length; j++) {
                if (lValContainer > pIntArray[j]) {
                    lValContainer = pIntArray[j];
                    lTempContainer = j;
                }
            }

            if (lTempContainer != -1) {
                int lVal = pIntArray[i];
                pIntArray[i] = pIntArray[lTempContainer];
                pIntArray[lTempContainer] = lVal;
            }
        }
        return pIntArray;
    }
}
