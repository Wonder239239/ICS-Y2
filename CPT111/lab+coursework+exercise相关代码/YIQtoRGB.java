import java.util.Scanner;

public class YIQtoRGB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double Y = Double.parseDouble(input);
        input = scanner.nextLine();
        double I = Double.parseDouble(input);
        input = scanner.nextLine();
        double Q = Double.parseDouble(input);
        
        int R = (int) Math.round((Y + 0.956 * I + 0.619 * Q) * 255);
        int G = (int) Math.round((Y - 0.272 * I - 0.647 * Q) * 255);
        int B = (int) Math.round((Y - 1.106 * I + 1.703 * Q) * 255);
       
        R = Math.max(0, Math.min(255, R));
        G = Math.max(0, Math.min(255, G));
        B = Math.max(0, Math.min(255, B));

        System.out.println("red = " + Math.round(R));
        System.out.println("green = " + Math.round(G));
        System.out.println("blue = " + Math.round(B));
    }
}