package com.justforentrepreneurs.j4eapp;


//import com.justforentrepreneurs.j4eapp.model.realms.Broadcast;
//import com.justforentrepreneurs.j4eapp.model.realms.Group;

public class Userlist {
    public String uid;
    //user photo url in server
    public String photo;
    //user status
    public String status;
    public String phone;
    //user photo path in the device
    public String userLocalPhoto;
    //userName saved using query from phonebook
    public String userName;
    public boolean isBlocked;

    //default app version
    public String appVer;
    //user's  thumb img (small image) decodes as BASE64
    public String thumbImg;
    private boolean isGroupBool;
//    private Group group;
//    private Broadcast broadcast;
    private boolean isBroadcastBool;
    private boolean isStoredInContacts;
    private long lastTimeFetchedImage = 0;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserLocalPhoto() {
        return userLocalPhoto;
    }

    public void setUserLocalPhoto(String userLocalPhoto) {
        this.userLocalPhoto = userLocalPhoto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getAppVer() {
        return appVer;
    }

    public void setAppVer(String appVer) {
        this.appVer = appVer;
    }

    public String getThumbImg() {
        return thumbImg;
    }

    public void setThumbImg(String thumbImg) {
        this.thumbImg = thumbImg;
    }

    public boolean isGroupBool() {
        return isGroupBool;
    }

    public void setGroupBool(boolean groupBool) {
        isGroupBool = groupBool;
    }

//    public Group getGroup() {
//        return group;
//    }
//
//    public void setGroup(Group group) {
//        this.group = group;
//    }
//
//    public Broadcast getBroadcast() {
//        return broadcast;
//    }
//
//    public void setBroadcast(Broadcast broadcast) {
//        this.broadcast = broadcast;
//    }

    public boolean isBroadcastBool() {
        return isBroadcastBool;
    }

    public void setBroadcastBool(boolean broadcastBool) {
        isBroadcastBool = broadcastBool;
    }

    public boolean isStoredInContacts() {
        return isStoredInContacts;
    }

    public void setStoredInContacts(boolean storedInContacts) {
        isStoredInContacts = storedInContacts;
    }

    public long getLastTimeFetchedImage() {
        return lastTimeFetchedImage;
    }

    public void setLastTimeFetchedImage(long lastTimeFetchedImage) {
        this.lastTimeFetchedImage = lastTimeFetchedImage;
    }
}
