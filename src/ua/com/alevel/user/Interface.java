package ua.com.alevel.user;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Interface {
    public static User create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name:");
        String name = scanner.nextLine();
        String corectName = name.toUpperCase(Locale.ROOT).replace(" ", "_");
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("phone");
        String phone = scanner.nextLine();
        User user = new User(corectName, email, phone);
        return user;
    }

    public static String askName() {
        System.out.println("Enter name of user");
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        return info;
    }

    public void serelization(Object object, File file) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object deserelization(File file) {
        Object result = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            result = inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("User " + create().name + " not found");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static File show(String name) throws IOException {
        File file = new File( name.toUpperCase(Locale.ROOT).replace(" ", "_") + ".dat");
        return file;
    }

}
