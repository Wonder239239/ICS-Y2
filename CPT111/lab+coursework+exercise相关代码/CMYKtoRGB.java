import java.util.Scanner;

public class CMYKtoRGB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double C = Double.parseDouble(input);
        input = scanner.nextLine();
        double M = Double.parseDouble(input);
        input = scanner.nextLine();
        double Y = Double.parseDouble(input);
        input = scanner.nextLine();
        double K = Double.parseDouble(input);

        double w=1-K;
        double r= 255*w*(1-C);
        double g=255*w*(1-M);
        double b=255*w*(1-Y);

        System.out.println("red = " + Math.round(r));
        System.out.println("green = " + Math.round(g));
        System.out.println("blue = " + Math.round(b));
    }

}