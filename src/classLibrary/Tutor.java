package classLibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class Tutor extends Person{
    private String nik;
    private LocalDate hireDate;
    private double salary;
    private LinkedList<Subject> competencies;

    public Tutor(String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, String jenisKelamin, String nomorKtp, Religion agama, BloodType golonganDarah, String nik, LocalDate hireDate, double salary) {
        super(namaDepan, namaBelakang, tanggalLahir, kotaLahir, jenisKelamin, nomorKtp, agama, golonganDarah);
        this.nik = nik;
        this.hireDate = hireDate;
        this.salary = salary;
        this.competencies = new LinkedList<Subject>();
    }

    public String getNik() {
        return this.nik;
    }

    public void setCompetencies(LinkedList<Subject> competencies) {
        this.competencies = competencies;
    }

    public String getFormattedHireDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return formatter.format(this.hireDate);
    }

    public long getYearDuration(){
        long years = ChronoUnit.YEARS.between(this.hireDate, LocalDate.now());
        return years;
    }

    public long getMonthDuration(){
        long months = ChronoUnit.MONTHS.between(this.hireDate, LocalDate.now());
        return months - (getYearDuration() * 12);
    }

    public long getDayDuration(){
        long days = ChronoUnit.DAYS.between(this.hireDate, LocalDate.now());
        return days % 30;
    }

    public String getHireDateDuration(){
        return String.format("%s (%d tahun, %d bulan, %d hari)", this.getFormattedHireDate(), this.getYearDuration(),
                this.getMonthDuration(), this.getDayDuration());
    }

    public void printSummary(){
        System.out.printf("NIK: %s, Name: %s\n", this.nik, this.getFullName());
    }

    public void printDetail(){
        this.printBiodata();
        System.out.println("\nCompetency Information:");
        for(Subject competency : this.competencies){
            competency.printNameFaculty();
        }
    }
}
