
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class UsersApp {

    public static ArrayList<User> loadUsers() {

        ArrayList<User> users = new ArrayList<>();

        try {
            File file = new File("users.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.trim().split("\\s+");

                if (parts.length != 2) {
                    System.out.println(line + " Invalid input");
                    continue;
                }

                try {
                    User user = new User(parts[0], parts[1]);
                    users.add(user);
                } catch (IllegalArgumentException e) {
                    System.out.println(line + " " + e.getMessage());
                }
            }

            reader.close();

            Collections.sort(users,
                    (u1, u2) -> u1.getName().compareTo(u2.getName()));

        } catch (FileNotFoundException e) {
            System.out.println("Could not find users.txt");
        }

        return users;
    }

    public static void main(String[] args) {
        ArrayList<User> users = loadUsers();

        for (User user : users) {
            System.out.println(user.getName() + " " + user.getPassword());
        }
    }
}
