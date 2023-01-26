package classLibrary;

public class Subject {
    private String nama;
    private String penjurusan;
    private int point;

    public Subject(String nama, String penjurusan, int point) {
        this.nama = nama;
        this.penjurusan = penjurusan;
        this.point = point;
    }

    public String getNameFaculty(){
        return String.format("%s in %s", this.nama, this.penjurusan);
    }

    public void printNameFaculty(){
        System.out.println(getNameFaculty());
    }

    public int getPoint() {
        return this.point;
    }
}
