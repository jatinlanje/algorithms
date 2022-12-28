public class PowerFunction {
    public static void main(String[] args) {
        System.out.println(power(10,3));
    }
    public static long power(int a, int b) {
        if (b == 0) {
            return 1;
        }

        long result = power(a,b/2);
        if (b % 2 == 0) {
            return result * result;
        }
        else {
            return a * result * result;
        }
    }
}
