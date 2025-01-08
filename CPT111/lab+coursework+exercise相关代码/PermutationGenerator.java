import java.util.ArrayList;
import java.util.List;

public class PermutationGenerator {
    public static List<String> generatePermutations(String s) {
        List<String> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        generatePermutationsHelper(arr, 0, result);
        return result;
    }

    private static void generatePermutationsHelper(char[] arr, int index, List<String> result) {
        // 如果索引达到字符串的末尾，则说明找到一个排列
        if (index == arr.length) {
            result.add(new String(arr));  // 转换回字符串并添加到结果列表
            return;
        }

        // 遍历从当前位置到字符串末尾的每一个字符，交换并递归生成剩余部分的排列
        for (int i = index; i < arr.length; i++) {
            // 交换字符位置
            swap(arr, index, i);
            // 递归生成后续部分的排列
            generatePermutationsHelper(arr, index + 1, result);
            // 回溯，恢复交换前的状态
            swap(arr, index, i);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        // 测试样例 1
        String s1 = "ABC";
        List<String> permutations1 = PermutationGenerator.generatePermutations(s1);
        System.out.println("Permutations of \"" + s1 + "\": " + permutations1);
        // 预期输出: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]

        // 测试样例 2
        String s2 = "A";
        List<String> permutations2 = PermutationGenerator.generatePermutations(s2);
        System.out.println("Permutations of \"" + s2 + "\": " + permutations2);
        // 预期输出: ["A"]

        // 测试样例 3
        String s3 = "AB";
        List<String> permutations3 = PermutationGenerator.generatePermutations(s3);
        System.out.println("Permutations of \"" + s3 + "\": " + permutations3);
        // 预期输出: ["AB", "BA"]

        // 测试样例 4
        String s4 = "";
        List<String> permutations4 = PermutationGenerator.generatePermutations(s4);
        System.out.println("Permutations of \"" + s4 + "\": " + permutations4);
        // 预期输出: [""]

        // 测试样例 5
        String s5 = "123";
        List<String> permutations5 = PermutationGenerator.generatePermutations(s5);
        System.out.println("Permutations of \"" + s5 + "\": " + permutations5);
        // 预期输出: ["123", "132", "213", "231", "312", "321"]
    }
}
