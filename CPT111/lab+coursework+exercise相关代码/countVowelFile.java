import java.io.*;

public class countVowelFile {
    public static int countVowelFile(String fileName) {
        int vowelCount = 0;
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                        vowelCount++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return vowelCount;
    }


    public static void main(String[] args) {
        System.out.println(countVowelFile("src/TestFile1.txt"));
    }


}
