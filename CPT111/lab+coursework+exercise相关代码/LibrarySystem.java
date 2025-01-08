import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LibrarySystem {
     public static void addBook(Map<String, Set<String>> library, String author, String book){
        if(!library.containsKey(author)){
            library.put(author,new HashSet<>());
            library.get(author).add(book); 
        }
        library.get(author).add(book); 
     }

     public static void removeBook(Map<String, Set<String>> library, String author, String book){
        if(library.containsKey(author)){
            library.get(author).remove(book);
            if (library.get(author).isEmpty()) {
                library.remove(author);
            }
        }
     }

     public static Set<String> getBooksByAuthor(Map<String, Set<String>> library,String author){
        return library.get(author);
     }



     public static String findAuthorByBook(Map<String, Set<String>> library, String book){
        for(String writer:library.keySet()){
            if(library.get(writer).contains(book)){
                return writer;
            }
        }
        return null;
     }

     public static void main(String[] args) {
        Map<String, Set<String>> library = new HashMap<>();
        addBook(library, "J.K. Rowling", "Harry Potter and the Sorcerer's Stone"); 
        addBook(library, "J.K. Rowling", "Harry Potter and the Chamber of Secrets"); 
        addBook(library, "George Orwell", "1984");
        addBook(library,"George Orwell", "Animal Farm");
        // 添加书籍
        addBook(library, "J.K. Rowling", "Harry Potter and the Sorcerer's Stone");
        addBook(library, "J.K. Rowling", "Harry Potter and the Chamber of Secrets");
        addBook(library, "George Orwell", "1984");
        addBook(library, "George Orwell", "Animal Farm");

        // 输出书籍
        System.out.println("J.K. Rowling 的书籍: " + getBooksByAuthor(library, "J.K. Rowling"));
        System.out.println("George Orwell 的书籍: " + getBooksByAuthor(library, "George Orwell"));

        // 删除书籍
        removeBook(library, "J.K. Rowling", "Harry Potter and the Chamber of Secrets");
        System.out.println("删除部分书籍后，J.K. Rowling 的书籍: " + getBooksByAuthor(library, "J.K. Rowling"));

        // 查找书籍对应的作者
        String author = findAuthorByBook(library, "1984");
        System.out.println("书籍 '1984' 的作者是: " + author);
       
    }
}
