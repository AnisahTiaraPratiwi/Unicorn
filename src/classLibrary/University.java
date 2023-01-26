package classLibrary;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class University {
    private static String name;
    private static LocalDate establishDate;
    private static String country;
    private static String state;
    private static String city;
    private static HashMap<String, Subject> subjects;
    private static HashMap<String, Student> students;
    private static HashMap<String, Tutor> tutors;

    public static void initialize(){
        fillUniversity();
        fillSubjects();
        fillStudents();
        fillTutors();
    }

    public static void fillUniversity(){
        name = "Unicorn (University of Cornelius)";
        establishDate = LocalDate.of(1978, Month.DECEMBER, 12);
        country = "Amerika Serikat";
        state = "Southern State";
        city = "Texas";
    }

    public static void fillSubjects(){
        subjects = new HashMap<>();
        subjects.put("oop", new Subject("Object Oriented Programming", "Programming", 20));
        subjects.put("ds", new Subject("Data Structure", "Programming", 30));
        subjects.put("nf", new Subject("Networking Fundamental", "Networking", 20));
        subjects.put("df", new Subject("Database Fundamental", "Programming", 30));
        subjects.put("pmp", new Subject("Project Management Professional", "Management and Analysis", 40));
        subjects.put("uml", new Subject("Unified Modelling Language", "Management and Analysis", 20));
        subjects.put("jf", new Subject("Java Fundamental", "Programming", 30));
        subjects.put("id", new Subject("Infrastructure Design", "Networking", 30));
        subjects.put("ns", new Subject("Network and Security", "Networking", 20));
    }

    public static void fillStudents(){
        students = new HashMap<>();
        Student alex = new Student("Alex", "Wirianata", LocalDate.of(1990, 11, 23),
            "Jakarta", "Laki-laki", "312008923111990002", Religion.KRISTEN, BloodType.A,
            "A021", LocalDate.of(2018, 4, 12));
        alex.setListPendaftaran(new LinkedList<Enrollment>(Arrays.asList(
            new Enrollment(subjects.get("oop"), LocalDate.of(2018, 4, 12), LocalDate.of(2018, 9, 12)),
            new Enrollment(subjects.get("ds"), LocalDate.of(2018, 8, 18))
        )));

        Student desy = new Student("Desy", "Oktaviani", LocalDate.of(1995, 5, 11),
            "Bandung", "Perempuan", "312008911051995002", Religion.ISLAM, BloodType.O,
            "A022", LocalDate.of(2018, 4, 1));
        desy.setListPendaftaran(new LinkedList<Enrollment>(Arrays.asList(
            new Enrollment(subjects.get("nf"), LocalDate.of(2018, 4, 1)),
            new Enrollment(subjects.get("ds"), LocalDate.of(2018, 8, 18))
        )));

        Student joko = new Student("Joko", "Davidson", LocalDate.of(1990, 6, 7),
            "Jakarta", "Laki-laki", "3120089277889990002", Religion.ISLAM, BloodType.A,
            "A023", LocalDate.of(2018, 4, 14));
        joko.setListPendaftaran(new LinkedList<Enrollment>(Arrays.asList(
            new Enrollment(subjects.get("uml"), LocalDate.of(2018, 5, 3), LocalDate.of(2018, 11, 4))
        )));

        students.put(alex.getNik(), alex);
        students.put(desy.getNik(), desy);
        students.put(joko.getNik(), joko);
    }

    public static void fillTutors(){
        tutors = new HashMap<>();
        Tutor antik = new Tutor("Antik", "Haya", LocalDate.of(1988, 11, 12),
            "Jakarta", "Perempuan", "312008912111988002", Religion.ISLAM, BloodType.A,
            "T701", LocalDate.of(2016, 3, 8), 6500000);
        antik.setCompetencies(new LinkedList<Subject>(Arrays.asList(
            subjects.get("id"), subjects.get("ns")
        )));

        Tutor cahya = new Tutor("Cahya", "Subroto", LocalDate.of(1989, 1, 7),
                "Surabaya", "Laki-laki", "312008907011989002", Religion.ISLAM, BloodType.B,
                "T808", LocalDate.of(2016, 4, 4), 8800000);
        cahya.setCompetencies(new LinkedList<Subject>(Arrays.asList(
            subjects.get("oop"), subjects.get("jf"), subjects.get("df")
        )));

        tutors.put(antik.getNik(), antik);
        tutors.put(cahya.getNik(), cahya);
    }

    public static void printAbout(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.printf("Universitas ini bernama %s. Sudah didirikan sejak  %s di %s, %s, di kota %s.\n",
                name, formatter.format(establishDate), country, state, city);
    }

    public static void printAllStudentSummary(){
        for(Student student : students.values()){
            student.printSummary();
        }
    }

    public static void printAllTutorSummary(){
        for(Tutor tutor : tutors.values()){
            tutor.printSummary();
        }
    }

    public static boolean findAndPrintStudentDetail(String nik){
        Student selectedStudent = students.get(nik);
        if(selectedStudent != null){
            selectedStudent.printDetail();
            return true;
        }
        return false;
    }

    public static boolean findAndPrintTutorDetail(String nik){
        Tutor selectedTutor = tutors.get(nik);
        if(selectedTutor != null){
            selectedTutor.printDetail();
            return true;
        }
        return false;
    }

}
