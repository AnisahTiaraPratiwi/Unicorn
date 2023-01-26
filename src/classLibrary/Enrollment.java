package classLibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Enrollment {
    private Subject mataPelajaran;
    private LocalDate startDate;
    private LocalDate endDate;

    public Enrollment(Subject mataPelajaran, LocalDate startDate) {
        this.mataPelajaran = mataPelajaran;
        this.startDate = startDate;
    }

    public Enrollment(Subject mataPelajaran, LocalDate startDate, LocalDate endDate) {
        this.mataPelajaran = mataPelajaran;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getYearDuration(){
        long years = ChronoUnit.YEARS.between(this.startDate, LocalDate.now());
        if(this.endDate != null){
            years = ChronoUnit.YEARS.between(this.startDate, this.endDate);
        }
        return years;
    }

    public long getMonthDuration(){
        long months = ChronoUnit.MONTHS.between(this.startDate, LocalDate.now());
        if(this.endDate != null){
            months = ChronoUnit.MONTHS.between(this.startDate, this.endDate);
        }
        return months - (getYearDuration() * 12);
    }

    public long getDayDuration(){
        long days = ChronoUnit.DAYS.between(this.startDate, LocalDate.now());
        if(this.endDate != null){
            days = ChronoUnit.DAYS.between(this.startDate, this.endDate);
        }
        return days % 30;
    }

    public String formatDate(LocalDate date){
        if(date == null){
            return "N/A";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(date);
    }

    public void printInformation(){
        System.out.printf("%s, (%s – %s), (%d tahun, %d bulan, %d hari), +%d poin\n",
                this.mataPelajaran.getNameFaculty(), this.formatDate(this.startDate),
                this.formatDate(this.endDate), this.getYearDuration(), this.getMonthDuration(),
                this.getDayDuration(), this.mataPelajaran.getPoint());
    }
}
