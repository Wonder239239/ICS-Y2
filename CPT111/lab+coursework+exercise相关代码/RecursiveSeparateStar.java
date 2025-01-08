public class RecursiveSeparateStar {
    public static String sepStar(String input) {
        // base case
        if(input.length()<=1) return input;
        // recursive step
        if(input.charAt(0)==input.charAt(1)){
            return input.charAt(0)+"*"+sepStar(input.substring(1));
        }
        else{
            return input.charAt(0)+sepStar(input.substring(1));
        }

    }

    public static void main(String[] args) {
        System.out.println(sepStar("aabb"));   // 输出: a*ab*b
        System.out.println(sepStar("hello"));  // 输出: hel*lo
        System.out.println(sepStar("aaa"));    // 输出: a*a*a
        System.out.println(sepStar("abc"));    // 输出: abc
        System.out.println(sepStar("a"));      // 输出: a
        System.out.println(sepStar(""));       // 输出: (空字符串)
    }

}
