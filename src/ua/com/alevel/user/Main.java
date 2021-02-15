package ua.com.alevel.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Interface interface2 = new Interface();


        System.out.println("Choose the command(1 - create, 2 - show");
        int variant = scanner.nextInt();
        if (variant == 1) {
            User user = Interface.create();
            String path = (user.name + ".dat");
            File file = new File(path);
            interface2.serelization(user, file);
        } else if (variant == 2) {
            String answerName = interface2.askName();
            try {
                System.out.println(interface2.deserelization(interface2.show(answerName)));
            } catch (FileNotFoundException e) {
                System.out.println("User " + answerName + " is not found");
            }
        }
    }}
