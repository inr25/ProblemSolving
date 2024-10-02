public class TrianglePattern {

    public static void main(String[] args) {
        TriPattern(5);
    }

    public static void TriPattern(int val) {
        for (int i = 0; i < val; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
