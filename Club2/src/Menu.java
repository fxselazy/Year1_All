
import java.util.Scanner;

public class Menu {

    private static Club[] clubs = new Club[50];
    private static int clubAmount = 0;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int menuNumber=0;
        do {
            System.out.println("<<Main Menu>>");
            System.out.println("1. New Club");
            System.out.println("2. Membership Subscribe");
            System.out.println("3. Edit Membership Information");
            System.out.println("4. Membership Unsubscribe");
            System.out.println("5. List Members");
            System.out.println("6. Exit");
                System.out.print("Enter Your Menu[1-6]: ");
                menuNumber = scanner.nextInt();
                System.out.println("");
                switch (menuNumber) {
                    case 1:
                        newClub();
                        break;
                    case 2:
                        memberSub();
                        break;
                    case 3:
                        edit();
                        break;
                    case 4:
                        memberUnSub();
                        break;
                    case 5:
                        listMembers();
                        break;
                    default:
                        System.out.println("Enter Number 1-6 Only\n");
                        break;
                }
        } while (menuNumber != 6);
    }

    public static void newClub() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Club's name: ");
        String fullName = scanner.next();
        System.out.print("Club's short name: ");
        String abb = scanner.next();
        System.out.print("How many members: ");
        int amount = scanner.nextInt();
        if (amount <= 0) {
            System.out.println("Member Amount Invalid\n");
        } else {
            clubs[clubAmount++] = new Club(fullName, abb, amount);
            System.out.println("Create Club Succesfully\n");
        }
    }

    public static Club searchClub(String abb) {
        for (Club c : clubs) {
            if (c.getAbb().toLowerCase().equals(abb.toLowerCase())) {
                return c;
            }
        }
        return null;
    }

    public static boolean digitCheck(long id) {
        int digit = 1;
        while (id >= 10) {
            id /= 10;
            digit++;
        }
        return digit == 11;
    }

    public static void memberSub() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter Club's Shortname: ");
        String abb = scanner.next();
        Club club = searchClub(abb);
        if (club != null) {
            if (!(club.isFull())) {
                System.out.print("Please Enter Your Student ID: ");
                long id = scanner.nextLong();
                if (digitCheck(id)) {
                    if (club.isLive(id) < 0) {
                        System.out.print("Please Enter Your Name: ");
                        String name = scanner.next();
                        System.out.print("Please Enter Your Surname: ");
                        String surname = scanner.next();
                        System.out.print("Please Enter Your Faculty: ");
                        String faculty = scanner.next();
                        club.addMember(new Student(id, name, surname, faculty));
                        System.out.println("Student added successfully\n");
                        return;
                    } else {
                        System.out.println("Student already existed\n");
                        return;
                    }
                } else {
                    System.out.println("Invalid Student ID\n");
                    return;
                }
            } else {
                System.out.println("Club is full\n");
                return;
            }
        } else {
            System.out.println("Club not Found\n");
            return;
        }
    }

    private static void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter Club's Shortname: ");
        String abb = scanner.next();
        Club club = searchClub(abb);
        if (club != null) {
            System.out.print("Please Enter Your Student ID: ");
            long id = scanner.nextLong();
            if (digitCheck(id)) {
                if (club.isLive(id) >= 0) {
                    System.out.print("Please Enter Your Name: ");
                    String name = scanner.next();
                    System.out.print("Please Enter Your Surname: ");
                    String surname = scanner.next();
                    System.out.print("Please Enter Your Faculty: ");
                    String faculty = scanner.next();
                    club.editMember(new Student(id, name, surname, faculty));
                    System.out.println("Student editted successfully\n");
                    return;
                } else {
                    System.out.println("Student does not exist\n");
                    return;
                }
            } else {
                System.out.println("Invalid Student ID\n");
                return;
            }
        } else {
            System.out.println("Club not Found\n");
            return;
        }
    }

    private static void memberUnSub() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter Club's Shortname: ");
        String abb = scanner.next();
        Club club = searchClub(abb);
        if (club != null) {
            System.out.print("Please Enter Your Student ID: ");
            long id = scanner.nextLong();
            if (digitCheck(id)) {
                if (club.isLive(id) >= 0) {
                    club.removeMember(id);
                    System.out.println("Student removed successfully\n");
                    return;
                } else {
                    System.out.println("Student does not exist\n");
                    return;
                }
            } else {
                System.out.println("Invalid Student ID\n");
                return;
            }
        } else {
            System.out.println("Club not Found\n");
            return;
        }
    }

    private static void listMembers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter Club's Shortname: ");
        String abb = scanner.next();
        Club club = searchClub(abb);
        if (club != null) {
            System.out.println("<<List of Members in " + club.getFullName() + " [" + club.getAbb() + "]>>");
            if (club.getStudentAmount() == 0) {
                System.out.println("There is no member");
            } else {
                for (int i = 0; i < club.getStudentAmount(); i++) {
                    System.out.print(i + 1 + ". ");
                    System.out.println(club.getMembers()[i].toString());
                }
            }
            System.out.println("*********************************\n");
        }
    }

}
