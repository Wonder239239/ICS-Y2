public class FactorialCalculator {
    public static long calculateFactorial(int n){
        if(n<=1) return 1;
        return n*calculateFactorial(n-1);
    }


    public static void main(String[] args) {
        // 测试样例 1
        int n1 = 0;
        long result1 = FactorialCalculator.calculateFactorial(n1);
        System.out.println(n1 + "! = " + result1); // 预期输出: 0! = 1

        // 测试样例 2
        int n2 = 1;
        long result2 = FactorialCalculator.calculateFactorial(n2);
        System.out.println(n2 + "! = " + result2); // 预期输出: 1! = 1

        // 测试样例 3
        int n3 = 5;
        long result3 = FactorialCalculator.calculateFactorial(n3);
        System.out.println(n3 + "! = " + result3); // 预期输出: 5! = 120

        // 测试样例 4
        int n4 = 10;
        long result4 = FactorialCalculator.calculateFactorial(n4);
        System.out.println(n4 + "! = " + result4); // 预期输出: 10! = 3628800

        // 测试样例 5
        int n5 = 20;
        long result5 = FactorialCalculator.calculateFactorial(n5);
        System.out.println(n5 + "! = " + result5); // 预期输出: 20! = 2432902008176640000
    }
}
