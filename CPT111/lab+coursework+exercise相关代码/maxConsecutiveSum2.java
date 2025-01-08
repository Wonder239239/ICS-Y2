public class maxConsecutiveSum2 {
    public static int maxConsecutiveSum2(int[] nums){
       
        if(nums.length==0) return 0;
       
        else{

            int []sum = new int[nums.length];
            sum[0]=nums[0];
            for (int i=1;i<=nums.length-1;i++){
            sum[i] = sum[i-1]+nums[i];
            }
            int max = sum[1]-sum[0];
            for (int j=0;j<nums.length;j++){
                for(int i=j+1;i<nums.length;i++){
                    max = Math.max(max, sum[i]-sum[j]);

                }
            }
            return max;
        }
    }

}
