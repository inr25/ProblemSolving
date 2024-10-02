
public class PrimeNumber {
    public static void main(String[] args) {
        boolean Flag = false;
        Flag = IsPrimeNumber(7);
        if (Flag) {
            System.out.println("Given number is an Prime Number");
        } else {
            System.out.println("Given number is not an Prime Number");
        }
    }

    public static boolean IsPrimeNumber(int Value) {

        if (Value == 0 || Value == 1) {
            return false;
        } else {
            for (int i = 2; i <= Value / 2; i++) {
                if (Value % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
