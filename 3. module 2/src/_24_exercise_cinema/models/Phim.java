package _24_exercise_cinema.models;

public class Phim {
    private String tenPhim;

    public Phim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getPhim(){
        return this.tenPhim;
    }

}
