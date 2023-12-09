package com.example.spakler.model;

public class AddSchedule {

    private String scheduleID;
    private String scheduleDate;
    private String scheduleTime;
    private String userName;
    private String userEmail;
    private String userContact;
    private String stylist;
    private  int isApprove;

    public AddSchedule() {
    }

    public AddSchedule(String scheduleID, String scheduleDate, String scheduleTime, String userName, String stylist, int isApprove) {
        this.scheduleID = scheduleID;
        this.scheduleDate = scheduleDate;
        this.scheduleTime = scheduleTime;
        this.userName = userName;
        this.stylist = stylist;
        this.isApprove = isApprove;
    }

    public AddSchedule(String scheduleID, String scheduleDate, String scheduleTime, String userName, String userEmail, String userContact, String stylist, int isApprove) {
        this.scheduleID = scheduleID;
        this.scheduleDate = scheduleDate;
        this.scheduleTime = scheduleTime;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userContact = userContact;
        this.stylist = stylist;
        this.isApprove = isApprove;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getStylist() {
        return stylist;
    }

    public void setStylist(String stylist) {
        this.stylist = stylist;
    }

    public int getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(int isApprove) {
        this.isApprove = isApprove;
    }
}
