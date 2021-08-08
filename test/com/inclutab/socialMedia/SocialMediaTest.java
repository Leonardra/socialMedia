package com.inclutab.socialMedia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SocialMediaTest {

    @Test
    void thatPlatformCanRegisterAccountForUser(){
        //given
        String firstName = "Oluwatobi";
        String lastName = "Jolayemi";
        String emailAddress = "jolayemi.tobi@gmail.com";
        String passWord = "12020";
        String userName = "Harry";
        Platform socialMedia = new Platform();
        //when
        socialMedia.register(firstName,lastName, emailAddress, passWord, userName);
        //assert
        assertEquals(1, socialMedia.getListOfUsers());
    }

    @Test
    void thatPlatformCanLogInRegisteredAccount(){
        Platform socialMedia = new Platform();
        socialMedia.register("Oluwatobi", "Jolayemi", "tobi@yahoo.com", "1234", "Oluwa");
        //when
        socialMedia.isLogIn("Oluwa", "1234");
        //assert
        assertTrue(socialMedia.isLogIn("Oluwa", "1234"));
    }

    @Test
    void thatAccountCanSendMessageThroughPlatform(){
        //given
        Platform socialMedia = new Platform();
        socialMedia.register("Oluwatobi", "Jolayemi", "tobi@yahoo.com", "1234", "Oluwa");
        socialMedia.register("Oluwatobi", "Jolayemi", "tobi@yahoo.com", "1234", "Tobi");
        //when
        String message = """
                I love Jesus
                """;
        socialMedia.sendMessage(message, "Oluwa", "Tobi");
        //assert
        assertEquals(1, socialMedia.getUser("Oluwa").getAccount().getSizeOfSentMessages());
    }

    @Test
    void thatAccountCanReceiveMessageThroughPlatform(){
        //given
        Platform socialMedia = new Platform();
        socialMedia.register("Oluwatobi", "Jolayemi", "tobi@yahoo.com", "1234", "Oluwa");
        socialMedia.register("Oluwatobi", "Jolayemi", "tobi@yahoo.com", "1234", "Tobi");
        //when
        String message = """
                I love Jesus
                """;
        socialMedia.sendMessage(message, "Oluwa", "Tobi");
        //assert
        assertEquals(1, socialMedia.getUser("Tobi").getAccount().getSizeOfReceivedMessages());
    }

}
