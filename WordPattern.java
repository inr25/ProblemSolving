public class WordPattern {
    public static void main(String[] args) {
        Pattern("HELLO");
    }

    public static void Pattern(String Val) {
        for (int i = 0; i < Val.length(); i++) {
            for (int j = 0; j < Val.length(); j++) {
                if (i == j) {
                    System.out.print(Val.charAt(i));
                } else if (j == Val.length() - 1-i) {
                    System.out.print(Val.charAt(j));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
