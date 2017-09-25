package data.entity;


import java.util.List;

public class Contact {


    private String name;
    private String address;
    private int phoneNumber;
    private List<Integer> listPhoneNumbers;

    public Contact() {
    }

    public Contact(String name, String address, List<Integer> listPhoneNumbers) {
        this.name = name;
        this.address = address;
        this.listPhoneNumbers = listPhoneNumbers;
    }

    public Contact(String name, String address, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Integer> getListPhoneNumbers() {
        return listPhoneNumbers;
    }

    public void setListPhoneNumbers(List<Integer> listPhoneNumbers) {
        this.listPhoneNumbers = listPhoneNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", listPhoneNumbers=" + listPhoneNumbers +
                '}';
    }
}
