public class ArmStrongNum {
    public static void main(String[] args) {
        boolean Flag = false;
        Flag = ArmStrong(1634);
        if (Flag) {
            System.out.println("Given number is an Armstrong Number");
        } else {
            System.out.println("Given number is not an Armstrong Number");
        }
    }

    public static boolean ArmStrong(int Num) {

        int Temp = Num, Value = 0;
        while (Num > 0) {
            int LastVal = Num % 10;
            int Prod = 1, Copy = Temp;
            while (Copy > 0) {
                Prod *= LastVal;
                Copy /= 10;
            }
            Value += Prod;
            Num = Num / 10;
        }
        if (Temp == Value) {
            return true;
        }
        return false;
    }
}
