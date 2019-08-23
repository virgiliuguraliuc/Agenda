package org.fasttrackit.transfer;

public class SaveAgendaRequest {

    private String FirstName;
    private String LastName;
    private int PhoneNumber;
    private String email;



    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Agenda{" + ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", email='" + email + '\'' +
                '}';
    }

}
