public class SumOfProperElements{
    public static int SumOfProperElements(int[]nums){
        if (nums.length==0) return 0;
        else{
            int sum =0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]%(i+1)==0) sum+=nums[i];
            }
            return sum;
        }
    }

    
    // public static void main(String[] args) {
        
    // }
}
