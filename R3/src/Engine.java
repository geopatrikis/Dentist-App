import java.util.Scanner;

public class Engine {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        printMenu();
        printMenu();
       // printMenu();
        seeListOfDentists();
    }

    private static void seeListOfDentists() {
        for(int i=0;i<Dentist.dentists.size();i++)
            System.out.println(Dentist.dentists.get(i).dentistID+" - " +Dentist.dentists.get(i).firstName);
    }

    private static void printMenu() {
        System.out.println("1. For Dentist");
        System.out.println("2. for Clients");
        int choice;
        do {
            try {
                System.out.println("Give 1 or 2,depending on the use you want");
                choice = Integer.parseInt(in.next());
            } catch (Exception e) {
                choice = 0;
            }
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            SignInDentists();
        } else {
            menuforClients();
        }
    }

    private static void SignInDentists() {
        System.out.println("Dentist Application");

        System.out.println("1. Register Dentist");
        System.out.println("2. Log In Dentist");
        int choice;
        do {
            try {
                System.out.println("Give 1 or 2,depending on the use you want");
                choice = Integer.parseInt(in.next());
            } catch (Exception e) {
                choice = 0;
                continue;
            }
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            createAccount();
        } else {
            menuforClients();
        }
    }

    private static void createAccount() {
        Dentist newReg = new Dentist();
        String choice;
        choice = in.nextLine();
        do {
            try {
                System.out.println("Give your FirstName");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 2);
        newReg.setFirstName(choice);
        do {
            try {
                System.out.println("Give your LastName");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 2);
        newReg.setLastName(choice);
        do {
            try {
                System.out.println("Give your Telephone Number");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 10);
        newReg.setTelNo(choice);
        do {
            try {
                System.out.println("Give your Email");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setEmail(choice);
        do {
            try {
                System.out.println("Give your Exercise Licence");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setExerciseLicense(choice);
        do {
            try {
                System.out.println("Give the University that you studied");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setUniversityAttended(choice);
        do {
            try {
                System.out.println("Give the infirmary Location");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setInfirmaryLocation(choice);
        do {
            try {
                System.out.println("Give the time of experience");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setTimeOfExperience(choice);
        String temppas;
        while (true) {
            do {
                try {
                    System.out.println("Give the Password (At least 8 characters)");
                    choice = in.nextLine();
                } catch (Exception e) {
                    choice = 0 + "";
                }
            } while (choice.length() < 8);
            temppas = choice;
            do {
                if (!choice.equals(temppas)) {
                    System.out.println("Passwords must match");
                    try {
                        System.out.println("Type Back if you want to try a new password/Press anything else if you want to retype the password");
                        choice = in.nextLine();
                    } catch (Exception e) {
                        choice = 0 + "";
                    }
                    if(choice.equalsIgnoreCase("back")) {
                        break;
                    }
                }
                try {
                    System.out.println("Give the Password again(At least 8 characters)");
                    choice = in.nextLine();
                } catch (Exception e) {
                    choice = 0 + "";
                }

            } while (!choice.equals(temppas));
            if(choice.equals(temppas))break;
        }
        newReg.setPassword(temppas);



    }

    private static void menuforClients() {
        Scanner in = new Scanner(System.in);
        System.out.println("1. For Dentist");
        System.out.println("2. for Clients");
        int choice;
        do {
            try {
                System.out.println("Give 1 or 2,depending on the use you want");
                choice = Integer.parseInt(in.next());
            } catch (Exception e) {
                choice = 0;
                continue;
            }
        } while (choice != 1 && choice != 2);
    }

}
