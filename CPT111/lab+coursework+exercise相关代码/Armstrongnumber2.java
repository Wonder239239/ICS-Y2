import java.util.Scanner;
public class Armstrongnumber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        while (k>0){
            int n = 0;
            int b = a;
            while(b > 0){
                b = b / 10;
                n++;
            }
            int sum = 0;
            int c = a;
            while(c > 0){
                int rem=c%10;
                sum =sum +(int)Math.pow(rem,n);
                c=c/10;
            }
        if(sum == a){
            System.out.println(a);
            k--;
        }
        a++;

        }
        scanner.close();
    }
}