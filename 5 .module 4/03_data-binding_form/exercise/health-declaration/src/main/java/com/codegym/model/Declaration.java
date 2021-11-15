package com.codegym.model;

public class Declaration {
    private Integer id;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private String idCard;
    private String vehicle;
    private String idVehicle;
    private String idSeat;
    private String departureDate;
    private String comingDate;
    private String destination;
    private String city;
    private String district;
    private String commune;
    private String address;
    private String phoneNumber;
    private String email;
    private boolean fever;
    private boolean cough;
    private boolean sultry;
    private boolean soreThroat;
    private boolean vomiting;
    private boolean diarrhea;
    private boolean skinHemorrhage;
    private boolean skinRash;
    private boolean slaughter;
    private boolean contact;

    public Declaration() {
    }

    public Declaration( Integer id,String name, String dateOfBirth, String gender, String nationality, String idCard, String vehicle, String idVehicle, String idSeat, String departureDate, String comingDate, String destination, String city, String district, String commune, String address, String phoneNumber, String email, boolean fever, boolean cough, boolean sultry, boolean soreThroat, boolean vomiting, boolean diarrhea, boolean skinHemorrhage, boolean skinRash, boolean slaughter, boolean contact) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.idVehicle = idVehicle;
        this.idSeat = idSeat;
        this.departureDate = departureDate;
        this.comingDate = comingDate;
        this.destination = destination;
        this.city = city;
        this.district = district;
        this.commune = commune;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fever = fever;
        this.cough = cough;
        this.sultry = sultry;
        this.soreThroat = soreThroat;
        this.vomiting = vomiting;
        this.diarrhea = diarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.skinRash = skinRash;
        this.slaughter = slaughter;
        this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(String idSeat) {
        this.idSeat = idSeat;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getComingDate() {
        return comingDate;
    }

    public void setComingDate(String comingDate) {
        this.comingDate = comingDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isSultry() {
        return sultry;
    }

    public void setSultry(boolean sultry) {
        this.sultry = sultry;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isVomiting() {
        return vomiting;
    }

    public void setVomiting(boolean vomiting) {
        this.vomiting = vomiting;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isSkinHemorrhage() {
        return skinHemorrhage;
    }

    public void setSkinHemorrhage(boolean skinHemorrhage) {
        this.skinHemorrhage = skinHemorrhage;
    }

    public boolean isSkinRash() {
        return skinRash;
    }

    public void setSkinRash(boolean skinRash) {
        this.skinRash = skinRash;
    }

    public boolean isSlaughter() {
        return slaughter;
    }

    public void setSlaughter(boolean slaughter) {
        this.slaughter = slaughter;
    }

    public boolean isContact() {
        return contact;
    }

    public void setContact(boolean contact) {
        this.contact = contact;
    }
}
