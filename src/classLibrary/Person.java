package classLibrary;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Person {
    private String namaDepan;
    private String namaBelakang;
    private LocalDate tanggalLahir;
    private String kotaLahir;
    private String jenisKelamin;
    private String nomorKtp;
    private Religion agama;
    private BloodType golonganDarah;

    public Person(String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, String jenisKelamin, String nomorKtp, Religion agama, BloodType golonganDarah) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.tanggalLahir = tanggalLahir;
        this.kotaLahir = kotaLahir;
        this.jenisKelamin = jenisKelamin;
        this.nomorKtp = nomorKtp;
        this.agama = agama;
        this.golonganDarah = golonganDarah;
    }

    public String getFullName(){
        return String.format("%s %s", this.namaDepan, this.namaBelakang);
    }

    public String getFormattedBirthDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return formatter.format(this.tanggalLahir);
    }

    public long getUmur(){
        return ChronoUnit.YEARS.between(this.tanggalLahir, LocalDate.now());
    }

    public String getBirthInformation(){
        return String.format("%s, %s (%d tahun)", this.kotaLahir, this.getFormattedBirthDate(), this.getUmur());
    }

    public void printBiodata(){
        System.out.printf("First Name: %s\nLast Name: %s\nGender: %s\nBirth Information: %s\nReligion: %s\nBlood Type: %s\nID Card: %s\n",
                this.namaDepan, this.namaBelakang, this.jenisKelamin, this.getBirthInformation(),
                this.agama, this.golonganDarah, this.nomorKtp);
    }
}
