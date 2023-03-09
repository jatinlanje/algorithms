public class DecimalToAnyBase {
    public int DecimalToAnyBase(int A, int B) {
        int ans=0;
        int i=0;

        while(A!=0){
            ans=ans+A%B*(int)Math.pow(10,i); 
            A=A/B;
            i++;
        }
        return ans;
    }
}
