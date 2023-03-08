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
        while ( i!= 0) {
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
                    System.out.println("Enter password: ");
                    String pass = scanner.next();
                    User user = new User(log, pass);
                    for (User us : users) {
                        if (!us.getLogin().equals(log)) {
                            users.add(user);
                            System.out.println("User add");
                            break;
                        } else {
                            System.out.println("User with this login already exist");
                            break;
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Enter user's login to delete: ");
                    String log = scanner.next();
                    for (User us : users) {
                        if (us.getLogin().equals(log)) {
                            users.remove(us);
                            break;
                        }
                        else {
                            System.out.println("User not found");
                        }
                    }
                    break;
                }
                case 3 -> {
                    System.out.println("Enter user's login to search: ");
                    String log = scanner.next();
                    for (User us : users) {
                        if (us.getLogin().equals(log)) {
                            if (users.contains(us)) {
                                System.out.println("Exist - " + us);
                                break;
                            }

                        }
                    }
                    System.out.println("User with login "+log+" not found");
                    break;
                }
                case 4 -> {
                    System.out.println("Enter user's login to search: ");
                    String log = scanner.next();
                    for (User us : users) {
                        if (us.getLogin().equals(log)) {
                            System.out.println("Enter new login: ");
                            String newLog = scanner.next();
                            users.set(users.indexOf(us), new User(newLog, us.getPassword()));
                            break;
                        }
                    }

                    break;
                }
                case 5 -> {
                    System.out.println("Enter user's login to search: ");
                    String log = scanner.next();
                    for (User us : users) {
                        if (us.getLogin().equals(log)) {
                            System.out.println("Enter new password: ");
                            String newPass = scanner.next();
                            users.set(users.indexOf(us) , new User(us.getLogin(), newPass));
                            break;
                        }
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

