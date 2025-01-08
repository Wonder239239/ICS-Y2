public class test {

    public static void reverseInts(int[] nums) {
        for (int n = 0; 2*n < nums.length-1; n++) {
            int a = nums[n];
            nums[n] = nums[nums.length-1-n];
            nums[nums.length-1-n] = a;
        }
        for (int n = 0; n < nums.length; n++) {
            System.out.print(nums[n] + " ");
        }
    }


    public static int getAimNum(int[] nums) {
        int a = -1000, b = -1000, c = -1000;
        for (int num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == -1000 ? a : c;
    }


    public static void main(String[] args) {
        reverseInts(new int[]{1,2,3,4});

        int a = 3;

        if (a >= 1) {
            System.out.print("Statement 1 ");
        } else if (a >= 2) {
            System.out.print("Statement 2 ");
        } else if (a >= 3) {
            System.out.print("Statement 3 ");
        }



        int[] m = {1, 1, 2, 3, 5, 8, 13, 21};
        for (int n = 0; n < 5; n++) {
            m[n] = m[n + 1];
            m[n + 1] = m[n + 2];
            m[n + 2] = m[n + 3];
            m[n + 3] = m[n] + m[n + 1] + m[n + 2];
        }
        System.out.println(m[7]);




        System.out.print(getAimNum(new int[]{3, 2, 1}));
        System.out.print(getAimNum(new int[]{2, 1}));
        System.out.print(getAimNum(new int[]{2, 3, 2, 1}));
    }



}
