public class CheckAllLowerCase {
    public static boolean checkAllLowercase(String input) {
        if (input.isEmpty()) {
            return true; 
        }
        if (input.length() == 1) {
            return Character.isLowerCase(input.charAt(0)); 
        }
        // recursive step
        if (Character.isLowerCase(input.charAt(0))) {
            return checkAllLowercase(input.substring(1)); 
        } else {
            return false; 
        }
    }

    public static void main(String[] args) {
        System.out.println(checkAllLowercase("hello")); // true
        System.out.println(checkAllLowercase("Hello")); // false
        System.out.println(checkAllLowercase(""));      // true
        System.out.println(checkAllLowercase("world")); // true
        System.out.println(checkAllLowercase("world1")); // false
    }
    
}
