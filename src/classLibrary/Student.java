package classLibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class Student extends Person{
    private String nik;
    private LocalDate entryDate;
    private LinkedList<Enrollment> listPendaftaran;

    public Student(String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, String jenisKelamin, String nomorKtp, Religion agama, BloodType golonganDarah, String nik, LocalDate entryDate) {
        super(namaDepan, namaBelakang, tanggalLahir, kotaLahir, jenisKelamin, nomorKtp, agama, golonganDarah);
        this.nik = nik;
        this.entryDate = entryDate;
        this.listPendaftaran = new LinkedList<Enrollment>();
    }

    public String getNik() {
        return this.nik;
    }

    public void setListPendaftaran(LinkedList<Enrollment> listPendaftaran) {
        this.listPendaftaran = listPendaftaran;
    }

    public String getFormattedEntryDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return formatter.format(this.entryDate);
    }

    public long getYearDuration(){
        long years = ChronoUnit.YEARS.between(this.entryDate, LocalDate.now());
        return years;
    }

    public long getMonthDuration(){
        long months = ChronoUnit.MONTHS.between(this.entryDate, LocalDate.now());
        return months - (getYearDuration() * 12);
    }

    public long getDayDuration(){
        long days = ChronoUnit.DAYS.between(this.entryDate, LocalDate.now());
        return days % 30;
    }

    public String getEntryDateDuration(){
        return String.format("%s (%d tahun, %d bulan, %d hari)", this.getFormattedEntryDate(), this.getYearDuration(),
                this.getMonthDuration(), this.getDayDuration());
    }

    public void printSummary(){
        System.out.printf("NIK: %s, Name: %s\n", this.nik, this.getFullName());
    }

    public void printDetail(){
        this.printBiodata();
        System.out.println("\nEnrollment Information:");
        for(Enrollment enrollment: this.listPendaftaran){
            enrollment.printInformation();
        }
    }
}
