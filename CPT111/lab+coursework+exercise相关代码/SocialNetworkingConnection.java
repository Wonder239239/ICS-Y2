import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class SocialNetworkingConnection {

    public static void addFriend(Map<String, Set<String>> network, String user1, String user2) {
        if (!network.containsKey(user1)) {
            network.put(user1, new HashSet<String>()); 
        }
        if (!network.containsKey(user2)) {
            network.put(user2, new HashSet<String>()); 
        }
        network.get(user1).add(user2);
        network.get(user2).add(user1);
    }

    public static void removeFriend(Map<String, Set<String>> network, String user1, String user2) {
        network.get(user1).remove(user2);
        network.get(user2).remove(user1);
    }

    public static Set<String> getFriends(Map<String, Set<String>> network, String user) {
        if (!network.containsKey(user)) {
            return null; 
        }
        return network.get(user);
    }

    public static boolean hasMutualFriends(Map<String, Set<String>> network, String user1, String user2){
        if (!network.containsKey(user1) || !network.containsKey(user2)) {
            return false;
        }
       
        Set<String> user_1 = new HashSet<>(network.get(user1)); 
        user_1.retainAll(network.get(user2));
        if(user_1.isEmpty()) return false;
        
        return true;
    }

    public static int totalUniqueConnections(Map<String,Set<String>> network){
        int numedge=0;
        for (String user:network.keySet()){
            numedge+=network.get(user).size();
        }
        numedge/=2;
        return numedge;
    }
    
    public static void main(String[] args) {
        Map<String, Set<String>> network = new HashMap<>();

       
        addFriend(network, "Alice", "Bob");
        addFriend(network, "Alice", "Charlie");
        addFriend(network, "Bob", "Charlie");

        
        System.out.println("Alice's friends: " + getFriends(network, "Alice"));
        System.out.println("Bob's friends: " + getFriends(network, "Bob"));
        System.out.print("Do Alice and Bob have mutual friends? ");
        if(hasMutualFriends(network, "Alice", "Bob")){
            System.out.println("Yes");
        }
        else{
            System.out.println("False");
        }
        System.out.println("Total unique connections:"+totalUniqueConnections(network));
    }
}

