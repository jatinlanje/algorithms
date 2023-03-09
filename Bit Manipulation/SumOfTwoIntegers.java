class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int sum=a^b;
        int carry=a&b;
        while(carry!=0){
            carry=carry<<1;
            int tempSum=sum^carry;
            int tempCarry=sum&carry;
            sum=tempSum;
            carry=tempCarry;
        }
        return sum;
    }
}
