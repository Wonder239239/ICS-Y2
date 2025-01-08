public class FibonacciCalculator {
    public static int calculateFibonacci(int n) {
        if(n==1) return 1;
        if(n==0) return 0;
        return calculateFibonacci(n-1)+calculateFibonacci(n-2);
    }

    public static void main(String[] args) {
        // 测试样例 1
        int n1 = 0;
        long result1 = FibonacciCalculator.calculateFibonacci(n1);
        System.out.println("Fibonacci(" + n1 + ") = " + result1); // 预期输出: 0

        // 测试样例 2
        int n2 = 1;
        long result2 = FibonacciCalculator.calculateFibonacci(n2);
        System.out.println("Fibonacci(" + n2 + ") = " + result2); // 预期输出: 1

        // 测试样例 3
        int n3 = 5;
        long result3 = FibonacciCalculator.calculateFibonacci(n3);
        System.out.println("Fibonacci(" + n3 + ") = " + result3); // 预期输出: 5

        // 测试样例 4
        int n4 = 10;
        long result4 = FibonacciCalculator.calculateFibonacci(n4);
        System.out.println("Fibonacci(" + n4 + ") = " + result4); // 预期输出: 55

        // 测试样例 5
        int n5 = 20;
        long result5 = FibonacciCalculator.calculateFibonacci(n5);
        System.out.println("Fibonacci(" + n5 + ") = " + result5); // 预期输出: 6765
    }

}
