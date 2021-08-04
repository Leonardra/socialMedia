package com.inclutab.socialMedia;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void thatUserCanSendMessage(){
        //given
        User user1 = new User();
        User user2 = new User();
        //when
        String message = """
                I love you to the earth and moon.
                Even the stars knows this.
                """;
        user1.sendMessage(message, user2);
        //assert
        assertEquals(1, user1.getSizeOfSentMessage());
    }
}
