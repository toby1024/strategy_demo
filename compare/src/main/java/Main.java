import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        User[] users = new User[50];
        for (int i = 0; i < 50; i++) {
            users[i] = new User(i,"test"+i,i+20);
        }
        for(User u : users){
            System.out.print(u.getUsername() + "===");
        }
        Arrays.sort(users);
        System.out.println("");
        System.out.println("======>");

        for(User u : users){
            System.out.print(u.getUsername() + "===");
        }

        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 50; i++) {
            list.add(new User(i,"test"+i,i+20));
        }

    }
}
