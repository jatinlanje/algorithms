public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans=0;
        for(int i=0; i<32; i++){
            int lsb = n & 1; //1. & to check bit
            int reverseLsb = lsb << (31-i); //2. left shift lsb
            ans = ans | reverseLsb; //3. or ans
            n = n >> 1; //4. right shift input
        } 
        return ans;
    }
}
