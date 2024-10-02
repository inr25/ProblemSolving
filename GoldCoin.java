import java.util.Scanner;

public class GoldCoin {
    public static void main(String[] args) {
        CoinCount();
    }

    public static void CoinCount() {
        Scanner Scan = new Scanner(System.in);
        System.out.println("Enter Number of Bags");
        int lcount = Scan.nextInt();
        int[] lArray = new int[lcount];
        for (int i = 0; i < lcount; i++) {
            int lbag = Scan.nextInt();
            lArray[i] = lbag;
        }
        Scan.close();
        int lLast = 0;
        int GoldCoins = 0;
        for (int i = 0; i < lArray.length; i++) {
            int temp = lArray[i], Smallest = lArray[i];
            while (temp > 0) { // looping over boxes in a bag
                int last = temp % 10;
                if (Smallest > last && (lLast <= last || i == 0)) {
                    Smallest = last;
                }
                temp /= 10;
            }
            if (lArray[i] != Smallest) {
                GoldCoins += Smallest;
                lLast = Smallest;
            }
        }

        System.out.println("Total number of gold coins = " + GoldCoins);
    }
}
