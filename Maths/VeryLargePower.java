public class VeryLargePower { 

    // Main function to calculate (A^(B!)) % 1000000007
    public int solve(int A, int B) {
        long ans=A;
        // Calculate B! and raise A to the power of each factor
        for(int i=B;i>=1;i--){
            ans=check((long)ans,i); 
        }
        // Return the result as an integer
        return (int)ans;
    }

    // Recursive helper function to calculate A^B using binary exponentiation
    long check(long A, long B){
        if(B==0) return 1;

        long ans=check(A,B/2);

        // Use the result of A^(B/2) to calculate A^B
        if(B%2==0){  
            // If B is even, A^B = (A^(B/2))^2
            return (ans*ans)%1000000007;
        }
        else{
            // If B is odd, A^B = A * (A^(B/2))^2
            return ((ans*ans)%1000000007*(A%1000000007))%1000000007;
        }
    }
}
