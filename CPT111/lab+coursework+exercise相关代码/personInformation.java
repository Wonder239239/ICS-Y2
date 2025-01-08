import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class personInformation {
    private int age;
    private String name;
    private String hobby;
    public personInformation(int age, String name, String hobby) {
        this.age = age;
        this.name = name;
        this.hobby = hobby;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getHobby() {
        return hobby;
    }




    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter your hobby: ");
        String hobby = sc.nextLine();
        personInformation person = new personInformation(age, name, hobby);
        try {
            FileWriter file = new FileWriter("src/user_Info.txt");
            BufferedWriter buffer = new BufferedWriter(file);
            buffer.write("Name: "+person.getName());
            buffer.newLine();
            buffer.write("Age: "+String.valueOf(person.getAge()));
            buffer.newLine();
            buffer.write("Hobby: "+person.getHobby());
            buffer.close();
            file.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println(" Content of user_info.txt:");
        File file = new File("src/user_Info.txt");
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }
    
    
}
