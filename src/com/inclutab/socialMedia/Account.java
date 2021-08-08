package com.inclutab.socialMedia;

import java.util.ArrayList;

public class Account {


    private final String passWord;
    private final String userName;
    private ArrayList<Message> sentMessageList = new ArrayList<>();
    private ArrayList<Message> receivedMessageList = new ArrayList<>();

    public Account(String passWord, String userName) {
        this.passWord = passWord;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void addToListOfSentMessage(Message newMessage) {
        sentMessageList.add(newMessage);
    }

    public int getSizeOfSentMessages() {
        return sentMessageList.size();
    }

    public int getSizeOfReceivedMessages() {
        return receivedMessageList.size();
    }

    public void addToListOfReceivedMessage(Message message) {
        receivedMessageList.add(message);
    }
}
