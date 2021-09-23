package _16_io_text_file.exercise.read_file_csv;

public class Country {
    private int id;
    private String code;
    private String name;

    public Country(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", code=" + code +
                ", name=" + name +
                '}';
    }
}
