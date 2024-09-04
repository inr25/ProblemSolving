public class Pyramid {

    public static void main(String[] args) {
        PyrPattern(5);
    }

    public static void PyrPattern(int val) {
        for (int i = 0; i <=val; i++) {
            for (int j = val; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = i; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
