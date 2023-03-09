public class AnyBaseToDecimal {
    public int solve(int A, int B) {
        int ans=0;
        int i=0;
        while(A!=0){
            int lastdigit=A%10;
            ans=ans+lastdigit*(int)Math.pow(B,i);
            A=A/10;
            i++;
        }
        return ans;
    }
}
