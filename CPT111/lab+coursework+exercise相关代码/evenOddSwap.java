public class evenOddSwap {
    public static int[] evenOddSwap(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int odd = 0;
        int even = 0;
        int []arr=new int[nums.length];

        while (odd < nums.length && even < nums.length) {
           
            while (odd < nums.length && nums[odd] % 2 == 0) {
                odd++;
            }
            
            while (even < nums.length && nums[even] % 2 == 1) {
                even++;
            }

            arr[odd] = nums[even];
            arr[even] = nums[odd];
            odd++;
            even++; 
            
        }

        return arr;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums1 = {1, 2, 3, 4};
        printArray(evenOddSwap(nums1)); // [2, 1, 4, 3]

        int[] nums2 = {100, 25};
        printArray(evenOddSwap(nums2)); // [25, 100]

        int[] nums3 = {};
        printArray(evenOddSwap(nums3)); // []

        int[] nums4 = {11, 55, 100, 200, 300, 7};
        printArray(evenOddSwap(nums4)); // [100, 200, 11, 55, 7, 300]
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
