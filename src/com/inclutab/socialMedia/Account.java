package com.inclutab.socialMedia;

import java.util.ArrayList;

public class Account {


    private final String passWord;
    private final String userName;
    private ArrayList<Message> sentMessages = new ArrayList<>();
    private ArrayList<Message> receivedMessages = new ArrayList<>();
    private ArrayList<Post> posts = new ArrayList<>();
    private boolean loginStatus;

    public Account(String passWord, String userName) {
        this.passWord = passWord;
        this.userName = userName;
        this.loginStatus = true;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void addToSentMessages(Message newMessage) {
        sentMessages.add(newMessage);
    }

    public int getNumberOfSentMessages() {
        return sentMessages.size();
    }

    public int getNumberOfReceivedMessages() {
        return receivedMessages.size();
    }

    public void addToReceivedMessages(Message message) {
        receivedMessages.add(message);
    }

    public void addToPostList(Post post) {
        posts.add(post);
    }

    public int getSizeOfPost() {
        return posts.size();
    }

    public boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus() {
        loginStatus = !loginStatus;
    }

    public void sendMessage(String message,Platform platform, String userName) {
        User recipient = platform.findUserByUsername(userName);
        Message newMessage = new Message(message,recipient);
        this.addToSentMessages(newMessage);
        receiveMessage(recipient, newMessage);
    }

    private void receiveMessage(User user, Message message){
        user.getAccount().addToReceivedMessages(message);
    }

    public void displaySentMessage(){
        for (Message message: sentMessages) {
            System.out.println(message);
        }
    }
}
