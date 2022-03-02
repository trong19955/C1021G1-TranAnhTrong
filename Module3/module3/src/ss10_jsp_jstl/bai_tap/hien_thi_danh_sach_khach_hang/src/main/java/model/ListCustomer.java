package model;

public class ListCustomer {
    private String nameCustomer;
    private String dateOfbirth;
    private String address;
    private String photo;

    public ListCustomer(String nameCustomer, String dateOfbirth, String address, String photo) {
        this.nameCustomer = nameCustomer;
        this.dateOfbirth = dateOfbirth;
        this.address = address;
        this.photo = photo;
    }

    public ListCustomer() {
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(String dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
