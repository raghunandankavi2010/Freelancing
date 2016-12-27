package com.talkativeparents.models;

/**
 * Created by Raghunandan on 23-02-2016.
 */
public class MobileRegistrationSendDetails {


   /* {
        "UserName":"91345",
            "SpouseInvite":"string",
            "Password":"1234",
            "Salutation":"string",
            "FirstName":"string",
            "LastName":"string",
            "Gender":0,
            "Emai
    }
*/
    private String UserName,SpouseInvite,Password,Salutation,FirstName,LastName,EmailAdress,Gender;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getSpouseInvite() {
        return SpouseInvite;
    }

    public void setSpouseInvite(String spouseInvite) {
        SpouseInvite = spouseInvite;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSalutation() {
        return Salutation;
    }

    public void setSalutation(String salutation) {
        Salutation = salutation;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmailAdress() {
        return EmailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        EmailAdress = emailAdress;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
