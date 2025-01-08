public class TowerOfHanoi {
    public static void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
         // TODO: 在这里实现递归逻辑
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }
        solveHanoi(n-1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        solveHanoi(n-1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        int n = 3; // 假设有 3 个盘子
        // 调用 solveHanoi 方法，开始从 A 移动到 C，辅助柱子是 B
        solveHanoi(n, 'A', 'C', 'B');
    }
}
