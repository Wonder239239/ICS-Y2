import java.util.Scanner;

public class Armstrongnumber {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    int a = Integer.parseInt(input);
    input = scanner.nextLine();
    int k = Integer.parseInt(input);
    int arr[]=new int[k];
    int count = 0;
    while (count < k) {
        int sum = 0;
        int temp = a;
        int n=a;
        int numDigits = 0;
        while (n > 0) {
            numDigits+=1;
            n /= 10;
        }

    
    
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, numDigits);
            temp /= 10;
        }
        
        if (sum == a) {
            arr[count] = a;
            count++;
        }
    
        a++;
    }


    
    for (int i = 0; i < k; i++) {
        System.out.println(arr[i]);
    }   
    scanner.close();


    }
}

