package model;

public class Customer {
    private int idCustomer;
    private String nameCustomer;
    private  String customerCode;
    private String birthday;
    private boolean gender;
    private int idCustomerType;
    private String nameCustomerType;

    public Customer(int idCustomer, String nameCustomer, String customerCode, String birthday, boolean gender, int idCustomerType, String nameCustomerType) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.customerCode = customerCode;
        this.birthday = birthday;
        this.gender = gender;
        this.idCustomerType = idCustomerType;
        this.nameCustomerType = nameCustomerType;
    }

    public Customer( String nameCustomer, String customerCode, String birthday, boolean gender, int idCustomerType) {
        this.nameCustomer = nameCustomer;
        this.customerCode = customerCode;
        this.birthday = birthday;
        this.gender = gender;
        this.idCustomerType = idCustomerType;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(int idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }
}
