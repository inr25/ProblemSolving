class BubbleSort {

    public static void main(String[] args) {
        int[] lUnSortedArray = { 25, 86, 1, 4, 0, 6 };
        int[] lSortedArray ;
        lSortedArray = bubbleSort(lUnSortedArray);
        System.out.print("Sorted Array : ");
        for (int i : lSortedArray) {
            System.out.print(i + ", ");
        }
    }

    public static int[] bubbleSort(int[] pIntArray) {

        for (int i = 0; i < pIntArray.length; i++) {
            for (int j = 1; j < pIntArray.length - i; j++) {
                int lTempContainer;
                if (pIntArray[j - 1] > pIntArray[j]) {
                    lTempContainer = pIntArray[j - 1];
                    pIntArray[j - 1] = pIntArray[j];
                    pIntArray[j] = lTempContainer;
                }
            }
        }
        return pIntArray;
    }
}