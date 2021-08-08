package com.inclutab.socialMedia;

import java.util.ArrayList;

public class Platform {

    private ArrayList <User> users = new ArrayList<>();

    public void register(String firstName, String lastName, String emailAddress, String passWord, String userName) {
            User newUser = new User(firstName, lastName, emailAddress);
            this.addToUserList(newUser);
            Account newAccount = new Account(passWord, userName);
            newUser.setAccount(newAccount);
    }

    private void addToUserList(User newUser) {
        users.add(newUser);
    }

    public int getListOfUsers() {
       return users.size();
    }

    public boolean isLogIn(String userName, String passWord) {
        for (User user: users) {
            if(user.getAccount().getUserName().equals(userName)){
                if(user.getAccount().getPassWord().equals(passWord)){
                     return true;
                }
            }
        }return false;
    }

    public User getUser(String userName) {
        for (User user: users) {
            if(user.getAccount().getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    public void sendMessage(String message, String senderUserName, String receiverUserName) {
        for (User user: users) {
            if(user.getAccount().getUserName().equals(senderUserName)){
                Message newMessage = new Message(message, receiverUserName, senderUserName);
                user.getAccount().addToListOfSentMessage(newMessage);
                receiveMessage(newMessage, receiverUserName);
            }
        }
    }

    private void receiveMessage(Message message, String receiver){
        for (User user: users) {
            if(user.getAccount().getUserName().equals(receiver)){
                user.getAccount().addToListOfReceivedMessage(message);
            }
        }
    }
}
