public class PalindromeSubStr {
    public static void main(String[] args) {
        String SubPali = SubPalindrome("ABCDCBIA");
        System.out.println("SubPali " + SubPali);
    }

    public static String SubPalindrome(String value) {
        int st = 0;
        int e = 0;
        for (int i = 0; i < value.length(); i++) {
            int l1 = FindIndex(value, i, i);
            int l2 = FindIndex(value, i, i + 1);
            int len = Math.max(l1, l2);

            if (len > e - st) {
                st = i - (len - 1) / 2;
                e = i + len / 2;
            }

        }
        return value.substring(st, e + 1);

    }

    public static int FindIndex(String value, int left, int right) {
        while (left >= 0 && right < value.length() && value.charAt(left) == value.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;

    }
}