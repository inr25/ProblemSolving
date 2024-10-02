public class ContinuosSum {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 5, 4, 9 };
        largeSum(a);
    }

    static void largeSum(int[] a) {
        int largest = 0, idx1 = 0, idx2 = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] + a[i + 1] > largest) {
                largest = a[i] + a[i + 1];
                idx1 = i;
                idx2 = i + 1;
            }
        }
        System.out.println("Largest Number is " + largest + " it is obtained from index " + idx1 + "," + idx2);
    }
}
