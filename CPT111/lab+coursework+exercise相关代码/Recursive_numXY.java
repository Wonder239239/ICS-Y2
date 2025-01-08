public class Recursive_numXY {
// Exercise #12.1
    public static int numXY(String input) {
        // base case
        if(input.length()<=1) return 0;
        if(input.equals("XY")) return 1;
        // recursive step
        if(input.substring(0, 2).equals("XY")){ 
            return 1+numXY(input.substring(1));
    }
        else {
            return 0+numXY(input.substring(1));
        }

    }

    public static void main(String[] args) {
        System.out.println(numXY("XYXYXY")); // 输出 3
        System.out.println(numXY("XYYX"));   // 输出 1
        System.out.println(numXY("XYZXY"));  // 输出 2
        System.out.println(numXY(""));       // 输出 0
        System.out.println(numXY("ABCD"));   // 输出 0
    }


}
