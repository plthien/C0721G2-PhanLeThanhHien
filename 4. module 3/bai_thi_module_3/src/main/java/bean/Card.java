package bean;

public class Card {
    private String id;
    private Book book;
    private Student student;
    private boolean status;
    private String rentDate;
    private String payDate;

    public Card() {
    }

    public Card(String id, Book book, Student student, boolean status, String rentDate, String payDate) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.status = status;
        this.rentDate = rentDate;
        this.payDate = payDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }
}
