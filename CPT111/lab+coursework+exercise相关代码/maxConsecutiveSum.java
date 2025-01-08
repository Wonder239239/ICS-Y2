public class maxConsecutiveSum {
    public static int maxConsecutiveSum(int[] nums){
        int []dp = new int[nums.length];
        dp[0]=nums[0];
        int max = nums[0];
        for (int i=1;i<=nums.length-1;i++){
            dp[i]=Math.max(nums[i], nums[i]+dp[i-1]);
            max=Math.max(max, dp[i]);
        }
        return  max;


    }
}
