public class StringReverser {
    public static String reverseString(String s){
        if (s == null || s.length() <= 1) {
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        // 测试样例 1
        String s1 = "hello";
        String reversed1 = StringReverser.reverseString(s1);
        System.out.println("Original: " + s1 + " | Reversed: " + reversed1); // 预期输出: "olleh"

        // 测试样例 2
        String s2 = "world";
        String reversed2 = StringReverser.reverseString(s2);
        System.out.println("Original: " + s2 + " | Reversed: " + reversed2); // 预期输出: "dlrow"

        // 测试样例 3
        String s3 = "Java";
        String reversed3 = StringReverser.reverseString(s3);
        System.out.println("Original: " + s3 + " | Reversed: " + reversed3); // 预期输出: "avaJ"

        // 测试样例 4
        String s4 = "";
        String reversed4 = StringReverser.reverseString(s4);
        System.out.println("Original: \"" + s4 + "\" | Reversed: \"" + reversed4 + "\""); // 预期输出: ""

        // 测试样例 5
        String s5 = "A";
        String reversed5 = StringReverser.reverseString(s5);
        System.out.println("Original: " + s5 + " | Reversed: " + reversed5); // 预期输出: "A"
    }

}
