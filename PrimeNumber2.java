public class PrimeNumber2 {
    public static void main(String[] args) {
        int a = 7;
        if (IsPrimeNumber(a)) {
            System.out.println("Given Number " + a + " is a Prime Number");
        } else {
            System.out.println("Given Number " + a + " is not a Prime Number");
        }
    }

    public static Boolean IsPrimeNumber(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}