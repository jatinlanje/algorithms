public class ModArray {
    public int solve(int[] A, int B) {
    long result = 0; 
    for (int i = 0; i < A.length; i++) {
        result = (result * 10 + A[i]) % B; // Update the result by multiplying by 10 and adding the current digit, then taking the modulus with B
    }
    return (int)result; 
    }
}
