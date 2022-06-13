package com.example.japp.models.response;

public class UserData {
    private int uid;

    private String firstName;

    private String lastName;

    private String tCount;

    private String AgeCount;

    public UserData(int muid, String mfirstName, String mlastName, String mtCount, String mageCount) {
        uid=muid;
        firstName=mfirstName;
        lastName=mlastName;
        tCount=mtCount;
        AgeCount=mageCount;
    }

    public void setAgeCount(String ageCount) {
        AgeCount = ageCount;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void settCount(String tCount) {
        this.tCount = tCount;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public String getAgeCount() {
        return AgeCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String gettCount() {
        return tCount;
    }
}