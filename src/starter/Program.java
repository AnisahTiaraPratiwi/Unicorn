package starter;
import classLibrary.*;
import java.util.*;

public class Program {

    private static String[] mainMenus;
    private static String[] studentMenus;
    private static String[] tutorMenus;
    private static String[] studentInfoMenus;
    private static String[] tutorInfoMenus;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        checkAuthentication();
        initialize();
        mainMenu();
    }

    public static void checkAuthentication(){
        System.out.println("Please insert your username");
        String userNameInput = scanner.nextLine().trim();
        System.out.println("Please insert your password");
        String passwordInput = scanner.nextLine().trim();
        if(!userNameInput.equals("admin") || !passwordInput.equals("123")){
            System.out.println("Your username and password is not found, please try again.");
            checkAuthentication();
        } else {
            System.out.println("Log in successfull");
        }
    }

    public static void mainMenu(){
        printMenuGuide(mainMenus);
        String input = scanner.nextLine().trim();
        if(!validateInputMenu(input, mainMenus.length)){
            mainMenu();
        }
        switch (input){
            case "1":
                allStudentData();
            case "2":
                allTutorData();
            case "3":
                University.printAbout();
                mainMenu();
            case "4":
                System.exit(0);
            default:
                System.out.println("Error, validation input menu fail");
                mainMenu();
        }
    }

    public static void allStudentData(){
        University.printAllStudentSummary();
        printMenuGuide(studentMenus);
        String input = scanner.nextLine().trim();
        if(!validateInputMenu(input, studentMenus.length)){
            allStudentData();
        }
        switch (input){
            case "1":
                studentInformation();
            case "2":
                mainMenu();
            case "3":
                System.exit(0);
            default:
                System.out.println("Error, validation input menu fail");
                allStudentData();
        }
    }

    public static void allTutorData(){
        University.printAllTutorSummary();
        printMenuGuide(tutorMenus);
        String input = scanner.nextLine().trim();
        if(!validateInputMenu(input, tutorMenus.length)){
            allTutorData();
        }
        switch (input){
            case "1":
                tutorInformation();
            case "2":
                mainMenu();
            case "3":
                System.exit(0);
            default:
                System.out.println("Error, validation input menu fail");
                allTutorData();
        }
    }

    public static void studentInformation(){
        System.out.println("Masukan nomor NIK yang anda ingin lihat informasinya:");
        String nik = scanner.nextLine().trim();
        boolean isFound = University.findAndPrintStudentDetail(nik);
        if(!isFound){
            System.out.println("Student is not found");
            studentInformation();
        }
        printMenuGuide(studentInfoMenus);
        String input = scanner.nextLine().trim();
        if(!validateInputMenu(input, studentInfoMenus.length)){
            allStudentData();
        }
        switch (input){
            case "1":
                allStudentData();
            case "2":
                mainMenu();
            case "3":
                System.exit(0);
            default:
                System.out.println("Error, validation input menu fail");
                mainMenu();
        }
    }

    public static void tutorInformation(){
        System.out.println("Masukan nomor NIK yang anda ingin lihat informasinya:");
        String nik = scanner.nextLine().trim();
        boolean isFound = University.findAndPrintTutorDetail(nik);
        if(!isFound){
            System.out.println("Tutor is not found");
            tutorInformation();
        }
        printMenuGuide(tutorInfoMenus);
        String input = scanner.nextLine().trim();
        if(!validateInputMenu(input, tutorInfoMenus.length)){
            allTutorData();
        }
        switch (input){
            case "1":
                allTutorData();
            case "2":
                mainMenu();
            case "3":
                System.exit(0);
            default:
                System.out.println("Error, validation input menu fail");
                mainMenu();
        }
    }

    public static void initialize(){
        mainMenus = new String[] {"All Student Data", "All Tutor Data", "About this University", "Exit Application"};
        studentMenus = new String[] {"Student Information", "Back to Main Menu", "Exit Application"};
        tutorMenus = new String[]{"Tutor Information", "Back to Main Menu", "Exit Application"};
        studentInfoMenus = new String[]{"Back to All Student Data", "Back to Main Menu", "Exit Application"};
        tutorInfoMenus = new String[]{"Back to All Tutor Data", "Back to Main Menu", "Exit Application"};
        University.initialize();
    }

    public static void printMenuGuide(String[] menus){
        System.out.println("Pilih nomor menu untuk masuk ke menunya:");
        for(int index = 0; index < menus.length; index++){
            System.out.printf("%d. %s\n", (index + 1), menus[index]);
        }
    }

    public static boolean validateInputMenu(String input, int totalMenu){
        try{
            int menuNumber = Integer.parseInt(input);
            if(menuNumber <= totalMenu && menuNumber >= 1){
                return true;
            }
        }catch (Exception exception){
            System.out.println("Input bukan berupa bilangan bulat");
        }
        System.out.println("Input harus bilangan bulat antara 1 - " + totalMenu);
        return false;
    }
}
