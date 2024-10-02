public class Palindrome {
    public static void main(String[] args) {
        boolean Flag = false;
        Flag = IsPanlindrome("MOOMOOM");
        if (Flag) {
            System.out.println("Given Value is a Palindrome");
        } else {
            System.out.println("Given Value is not a Palindrome");
        }
    }

    public static Boolean CheckPanlindrome(String Value) {
        String Temp = Value, NewValue = "";
        for (int i = Value.length() - 1; i >= 0; i--) {
            char ch = Value.charAt(i);
            NewValue = NewValue + String.valueOf(ch);
        }
        if (Temp.equals(NewValue)) {
            return true;
        }
        return false;
    }

    public static Boolean CheckPanlindrome(int Value) {

        int Temp = Value, NewValue = 0;
        while (Value > 0) {
            int LastVal = Value % 10;
            NewValue = (NewValue * 10) + LastVal;
            Value /= 10;
        }

        if (Temp == NewValue) {
            return true;
        }
        return false;
    }

    public static Boolean IsPanlindrome(String Value) {

        for (int i = 0; i < Value.length() / 2; i++) {
            char lTemp = Value.charAt(i);
            char lLast = Value.charAt(Value.length() - 1 - i);
            if (lTemp != lLast) {
                return false;
            }
        }
        return true;
    }

    public static Boolean IsPanlindromeWhile(String Value) {
        int n = Value.length(), i = 0;
        while (i < n / 2) {
            char lTemp = Value.charAt(i);
            char lLast = Value.charAt(Value.length() - 1 - i);
            if (lTemp != lLast) {
                return false;
            }
            i++;
        }
        return true;
    }

}
