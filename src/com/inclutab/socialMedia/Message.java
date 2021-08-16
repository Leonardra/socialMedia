package com.inclutab.socialMedia;

import java.time.LocalDateTime;

public class Message {
    private final String messageBody;
    private final User receiver;
    private final LocalDateTime timeStamp;

    public Message(String message, User recipient) {
        this.messageBody = message;
        this.receiver = recipient;
        this.timeStamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Message{" +
                "To =" + receiver +
                "messageBody='" + messageBody + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
