import java.util.Hashtable;

public class LetterCount {
    public static void main(String[] args) {
        CountArr("ayyanar");
    }

    public static void Count(String Val) {
        char[] chArr = Val.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            char ch = chArr[i];
            int n = 0;
            if (ch != '0') {
                for (int j = 0; j < chArr.length; j++) {
                    if (ch == chArr[j]) {
                        n++;
                        chArr[j] = '0';
                    }
                }
                System.out.println("The word " + Val + " has " + n + " times of letter " + ch);
            }
        }
    }

    public static void CountArr(String Val) {
        int[] Arr = new int[255];

        for (int i = 0; i < Val.length(); i++) {
            Arr[Val.charAt(i)] += 1;
        }
        for (int i = 0; i < Arr.length; i++) {
            if (Arr[i] != 0) {
                char a = (char) i;
                System.out.println("The word " + Val + " has " + Arr[i] + " times of letter " + a);
            }
        }
    }

    public static void PrintCount(String Value) {
        Hashtable<Character, Integer> Map = new Hashtable<Character, Integer>();
        for (int i = 0; i < Value.length(); i++) {
            if (Map.containsKey(Value.charAt(i))) {
                int n = Map.get(Value.charAt(i));
                n += 1;
                Map.put(Value.charAt(i), n);
            } else {
                Map.put(Value.charAt(i), 1);
            }
        }
        System.out.println(Map);
    }
}
