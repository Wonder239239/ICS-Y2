import java.util.Scanner;

public class Set {
    private int num = 0;
    private int[] set;
    private double[] average;

    //类的初始化
    public Set(int size) {
        set = new int[size];
        average = new double[size];
    }
    //输入元素
    public void enter_element(Scanner scanner) {
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter a new integer: ");
            if (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                scanner.nextLine();
                if (isExist(a)) {
                    System.out.println("The number " + a + " is already in the set. Please enter a different number.");
                    continue;
                }
                set[num] = a;
                num++;
                validInput = true;
                if (num == 1) {
                    System.out.println("New element added: " + a + ". There is " + num + " element in the set now.");
                    System.out.print("Set={ " + set[0]);
                } else {
                    System.out.println("New element added: " + a + ". There are " + num + " elements in the set now.");
                    System.out.print("Set={ ");
                    for (int i = 0; i < num; i++) {
                        if (i == num - 1) {
                            System.out.print(set[i]);
                        } else {
                            System.out.print(set[i] + ", ");
                        }
                    }
                }
                System.out.println(" }");
                System.out.println();
            } else {
                System.out.println("The input value is NOT an integer!");
                scanner.next();
            }
        }
    }
    //检查是否存在
    private boolean isExist(int value) {
        for (int i = 0; i < num; i++) {
            if (set[i] == value) {
                return true;
            }
        }
        return false;
    }
    //计算平均数并画图
    public void Cal_average(int[] num) {
        System.out.println("Tendency of the average value");
        System.out.println("[Item:Average]");
        int sum = 0;
        double min = num[0];
        double max = num[0];
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
            average[i] = (double) sum / (i + 1);
            max = Math.max(max, average[i]);
            min = Math.min(min, average[i]);
        }

        for (int i = 0; i < num.length; i++) {
            String[] symbol = new String[42];
            int num_of = (int) (average[i] / max * 40);
            // 初始化
            symbol[41] = "|";
            for (int k = 0; k < 41; k++) symbol[k] = " ";
            for (int i2 = 0; i2 < num_of; i2++) symbol[i2] = "+";

            System.out.printf("[%4d:%7.3f] ", i + 1, average[i]);
            for (int j = 0; j < 42; j++) System.out.print(symbol[j]);
            System.out.println();
        }
        System.out.println();
        System.out.printf("max: %.3f, min: %.3f, average: %.3f%n", max, min, average[num.length - 1]);
    }
    //main主函数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in set:");
        int n = scanner.nextInt();
        scanner.nextLine();

        Set mySet = new Set(n);
        for (int i = 0; i < n; i++) {
            mySet.enter_element(scanner);
        }
        mySet.Cal_average(mySet.set);

        scanner.close();
    }
}
