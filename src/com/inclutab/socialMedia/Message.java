package com.inclutab.socialMedia;

import java.time.LocalDateTime;

public class Message {
    private final String messageBody;
    private final String receiver;
    private final String sender;
    private final LocalDateTime timeStamp;

    public Message(String message, String receiverUserName, String senderUserName) {
        this.messageBody = message;
        this.receiver = receiverUserName;
        this.sender = senderUserName;
        this.timeStamp = LocalDateTime.now();
    }
}
