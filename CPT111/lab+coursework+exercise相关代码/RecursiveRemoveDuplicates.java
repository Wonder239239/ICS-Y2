public class RecursiveRemoveDuplicates {
    // Exercise #12.2
    public static String remDup(String input) {
        if(input.length()<2) return input;

        if (input.charAt(0) == input.charAt(1)) {
            return remDup(input.substring(1));
        } 
        else {
            return input.charAt(0) + remDup(input.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(remDup("aabbcc"));    // 输出: abc
        System.out.println(remDup("aaabccddd")); // 输出: abcd
        System.out.println(remDup("abc"));      // 输出: abc
        System.out.println(remDup("a"));        // 输出: a
        System.out.println(remDup(""));         // 输出: (空字符串)
    }

}
