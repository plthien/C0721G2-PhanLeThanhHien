package models;

public abstract class Person {
    private String name;
    private String birthDay;
    private boolean gender;
    private String personalID;
    private String phoneNumber;
    private String email;

    public Person(String name, String birthDay, boolean gender, String personalID, String phoneNumber, String email) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.personalID = personalID;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String isGender() {
        return this.gender ? "Male" : "Female";
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfoToWrite() {
        return this.name + "," + this.birthDay + "," + this.gender + "," +
                this.personalID + "," + this.phoneNumber + "," + this.email;
    }


}


