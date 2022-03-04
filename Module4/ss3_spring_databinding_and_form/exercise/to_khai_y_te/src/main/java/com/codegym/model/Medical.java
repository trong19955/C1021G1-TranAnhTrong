package com.codegym.model;

public class Medical {
    private String name;
    private String yearOfBirth;
    private String gender;
    private String nationality;
    private String identityCardNumber;
    private String travelInformation;
    private String vehicleNumber;
    private String seats;
    private String departureDay;
    private String endDate;
    private String questionAndAnswer14Day;
    private String conscious;
    private String district;
    private String commune;
    private String address;
    private String phone;
    private String email;
    private String symptom;
    private String exposureHistory;

    public Medical() {
    }

    public Medical(String name, String yearOfBirth, String gender, String nationality, String identityCardNumber, String travelInformation, String vehicleNumber, String seats, String departureDay, String endDate, String questionAndAnswer14Day, String conscious, String district, String commune, String address, String phone, String email, String symptom, String exposureHistory) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.identityCardNumber = identityCardNumber;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.seats = seats;
        this.departureDay = departureDay;
        this.endDate = endDate;
        this.questionAndAnswer14Day = questionAndAnswer14Day;
        this.conscious = conscious;
        this.district = district;
        this.commune = commune;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptom = symptom;
        this.exposureHistory = exposureHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
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

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getQuestionAndAnswer14Day() {
        return questionAndAnswer14Day;
    }

    public void setQuestionAndAnswer14Day(String questionAndAnswer14Day) {
        this.questionAndAnswer14Day = questionAndAnswer14Day;
    }

    public String getConscious() {
        return conscious;
    }

    public void setConscious(String conscious) {
        this.conscious = conscious;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getExposureHistory() {
        return exposureHistory;
    }

    public void setExposureHistory(String exposureHistory) {
        this.exposureHistory = exposureHistory;
    }
}
