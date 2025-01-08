public class isValidID {
    public static boolean isValidID(String id) {
        if (id.length() < 5) return false;
        char[] a = id.toCharArray();
        int sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (Character.isDigit(a[i])) sum += (a[i] - '0');
        }
        sum = sum % 11;
        char lastChar = a[id.length() - 1];
        if ((sum == 10 && lastChar == 'X') || (sum == (lastChar - '0'))) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidID("THMBB7092WD114221")); 
        System.out.println(isValidID("A001-606X-17X")); 
    }
    
}
