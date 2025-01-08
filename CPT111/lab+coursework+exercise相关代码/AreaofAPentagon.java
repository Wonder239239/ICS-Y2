import java.util.Scanner;

public class AreaofAPentagon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double r = scanner.nextDouble();
        double s = 2 * r * Math.sin(Math.PI / 5);
        double area = 5.0 * s * s / (4 * Math.tan(Math.PI / 5));
        System.out.println("Area = " + area);

        scanner.close();
    }
}
