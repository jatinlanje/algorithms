public class EuclidsAlgorithm {
    public static void main(String[] args) {
        System.out.println(gcd(10,5));
    }
    //Euclid's Algorithm can be used to find the greatest common factor
    static int gcd(int A, int B) {
        A = Math.abs(A);
        B = Math.abs(B);
        if(B==0)
            return A;
        else
            return gcd(B, A % B);
    }
}
