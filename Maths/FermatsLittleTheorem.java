public class FermatLittleTheorem {
    public static void main(String[] args) {
        System.out.println(inverse(3,11));
    }
    //Fermat's Little Theorem can be used to calculate the modular multiplicative inverse of a number
    public static long inverse(int A, int B) {
        return power(A, B - 2, B);
    }
    public static long power(int A, int B, int C){
        if(B==0){
            return 1;
        }
        long smallOutput=power(A,B/2,C);
        if(B%2==0){
            return (smallOutput*smallOutput)%C;
        }
        return ((smallOutput*smallOutput)%C)*A%C;
    }
}
