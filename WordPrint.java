public class WordPrint {
    public static void main(String[] args) {
        System.out.println(printValue("3{a}2{bc}4{kde}2{AB}"));
    }

    public static String printValue(String Val) {
        int n = 0;
        String finalStr = "", tempStr = "";
        for (int i = 0; i < Val.length(); i++) {
            if (Val.charAt(i) >= 48 && Val.charAt(i) <= 57) {
                if (n == 0) {
                    n = Character.getNumericValue(Val.charAt(i));
                } else {
                    n *= 10 + Character.getNumericValue(Val.charAt(i));
                }
            } else {
                if (Val.charAt(i) != '{' && Val.charAt(i) != '}') {
                    tempStr += Val.charAt(i);
                }
                if (Val.charAt(i) == '{') {
                    continue;
                }
                if (Val.charAt(i) == '}') {
                    for (int j = 0; j < n; j++) {
                        finalStr += tempStr;
                    }
                    n = 0;
                    tempStr = "";
                }

            }
        }
        return finalStr;
    }
}
