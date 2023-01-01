public class KadanesAlgorithm {
    public static void main(String[] args) {
        System.out.println("Enter the length of array:");
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //5

        int input[] = new int[t];
        System.out.println("Enter the elements of array:");
        for(int i=0; i<t; i++){
            input[i]=sc.nextInt(); //5 4 -1 7 8
        }

        System.out.println(maxSubArray(input)); //23
    }
    //Kadanes Algorithm is used to find maximum sum subarray
    public static int maxSubArray(int[] nums) {
        //Edge case: empty or null input
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int currentSum=Integer.MIN_VALUE;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(currentSum<0){
                currentSum=0;
            }
            currentSum=currentSum+nums[i];
            maxSum=Math.max(currentSum,maxSum);
        }
        return maxSum;
    }
}
