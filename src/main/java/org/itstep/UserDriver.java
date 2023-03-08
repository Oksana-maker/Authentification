package org.itstep;

import java.util.ArrayList;
import java.util.Scanner;

public class UserDriver {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Ka", "123"));
        users.add(new User("Le", "124"));
        users.add(new User("Miu", "125"));
        users.add(new User("Li", "126"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("[1] - choose an action");
        System.out.println("[0] - exit");
        int i = scanner.nextInt();
        chek:
        while (i != 0) {
            System.out.println("Choose operation: ");
            System.out.println("[1] - add new user");
            System.out.println("[2] - delete existing user");
            System.out.println("[3] - check if user exists");
            System.out.println("[4] - change login of an existing user");
            System.out.println("[5] - change password of an existing user");
            System.out.println("[0] - exit");
            int swh = scanner.nextInt();
            if (swh == 0) {
                break chek;
            }
            switch (swh) {
                case 1 -> {
                    System.out.println("Enter login: ");
                    String log = scanner.next();
                    boolean isExist = false;
                    for (User us : users) {
                        if (us.getLogin().equals(log)) {
                            isExist = true;
                            continue ;
                        }
                    }
                    if (isExist) {
                        System.out.println("User with this login already exist");
                        break;
                    } else {
                        System.out.println("Enter password: ");
                        String pass = scanner.next();
                        User user = new User(log, pass);
                        users.add(user);
                        System.out.println("User add");
                        break;
                    }
                }
                case 2 -> {
                    System.out.println("Enter user's login to delete: ");
                    String log = scanner.next();
                    boolean no = false;
                    for (User us : users) {
                        if (us.getLogin().equals(log)) {
                            users.remove(us);
                            no = true;
                            System.out.println("User deleted");
                            break;
                        }
                    }
                    if (!no) {
                        System.out.println("User with login [" + log + "] not found");
                    }
                    break;
                }

                case 3 -> {
                    System.out.println("Enter user's login to search: ");
                    String log = scanner.next();
                    boolean no = false;
                    for (User us : users) {
                        if (us.getLogin().equals(log)) {
                            if (users.contains(us)) {
                                System.out.println("Exist - " + us);
                                no = true;
                                break;
                            }

                        }
                    }
                    if (!no){
                        System.out.println("User with login [" + log + "] not found");
                    }
                    break;
                }
                case 4 -> {
                    System.out.println("Enter user's login to search: ");
                    String log = scanner.next();
                    boolean no = false;
                    for (User us : users) {
                        if (us.getLogin().equals(log)) {
                            System.out.println("Enter new login: ");
                            String newLog = scanner.next();
                            users.set(users.indexOf(us), new User(newLog, us.getPassword()));
                            System.out.println("Login changed");
                            no = true;
                            break;
                        }
                    }
                    if (!no){
                        System.out.println("User with login [" + log + "] not found");
                    }

                    break;
                }
                case 5 -> {
                    System.out.println("Enter user's login to search: ");
                    String log = scanner.next();
                    boolean no = false;
                    for (User us : users) {
                        if (us.getLogin().equals(log)) {
                            System.out.println("Enter new password: ");
                            String newPass = scanner.next();
                            users.set(users.indexOf(us), new User(us.getLogin(), newPass));
                            System.out.println("Password changed");
                            no = true;
                            break;
                        }
                    }
                    if (!no){
                        System.out.println("User with login [" + log + "] not found");
                    }
                    break;

                }
                default -> {
                    System.out.println("Select action");
                    break;
                }
            }
        }
        System.out.println(users);
    }

}

