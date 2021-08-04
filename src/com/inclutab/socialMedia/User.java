package com.inclutab.socialMedia;

import java.util.ArrayList;

public class User {
    private ArrayList<Message> listOfSentMessages = new ArrayList<>();
    private ArrayList<Message> listOfReceivedMessages = new ArrayList<>();

    public void sendMessage(String message, User receiver) {
        Message newMessage = new Message(message, receiver);
        listOfSentMessages.add(newMessage);
        receiver.receiveMessage(newMessage);
    }

    private void receiveMessage(Message newMessage) {
        listOfReceivedMessages.add(newMessage);
    }

    public int getSizeOfSentMessage() {
        return listOfSentMessages.size();
    }
}
