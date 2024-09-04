import java.util.Hashtable;

public class TwoSum {
    public static void main(String[] args) {
        int[] lTwoSumVal;
        int[] Array = { 2, 7, 11, 15 };
        int Target = 18;
        lTwoSumVal = TwoSumFind(Array, Target);
        for (int i = 0; i < lTwoSumVal.length; i++) {
            System.out.print(lTwoSumVal[i] + ", ");
        }
    }

    public static int[] TwoSumFind(int[] Array, int Target) {
        int[] Sol = {};
        Hashtable<Integer, Integer> Map = new Hashtable<Integer, Integer>();
        for (int i = 0; i < Array.length; i++) {
            int complement = Target - Array[i];
            if (Map.containsKey(complement)) {
                Sol = new int[] { Map.get(complement), i };
                return Sol;
            }

            Map.put(Array[i], i);
        }

        return Sol;
    }
}
