package com.inclutab.socialMedia;

import java.time.LocalDateTime;

public class Message {

    private final String body;
    private final LocalDateTime timeAndDateOfMessage;
    private final User messageOwner;

    public Message(String message, User receiver) {
        body = message;
        messageOwner = receiver;
        timeAndDateOfMessage = LocalDateTime.now();
    }
}
