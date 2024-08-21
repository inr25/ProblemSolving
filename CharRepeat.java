public class CharRepeat {
    public static void main(String[] args) {
        String OP = "";
        OP = Repeat("B0I0C1Z2E12E12");
        System.out.println(OP);
    }

    public static String Repeat(String Value) {
        String ConVal = "";
        char temp = ' ';
        int Count = 0;
        for (int i = 0; i < Value.length(); i++) {
            char ch = Value.charAt(i);
            if (ch >= 48 && ch <= 57) {
                Count = (Count * 10) + Integer.parseInt(Character.toString(ch));
            } else {
                if (temp == ' ') {
                    temp = ch;
                } else {
                    while (Count > 0) {
                        ConVal = ConVal + temp;
                        Count--;
                    }
                    temp = ch;
                    Count = 0;
                }
            }

        }
        while (Count > 0) {
            ConVal = ConVal + temp;
            Count--;
        }
        return ConVal;
    }
}
