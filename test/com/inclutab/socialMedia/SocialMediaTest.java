package com.inclutab.socialMedia;

import com.inclutab.socialMedia.socialMediaExceptions.InvalidPasswordException;
import com.inclutab.socialMedia.socialMediaExceptions.UsernameExistsException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SocialMediaTest {

    private static Platform platform;
    @BeforeEach
    void startAllTestWithThis(){
        platform = Platform.createInstanceOf();
    }

    @AfterEach
    void doThisAfterEachTest(){
        platform.clearDataBase();
        platform = null;
    }


    @Test
    void thatPlatformCanBeCreated(){
        assertNotNull(platform);
        Platform platform1 = Platform.createInstanceOf();
        Platform platform2 = Platform.createInstanceOf();
        assertEquals(platform, platform1);
        assertEquals(platform1, platform2);
    }

    @Test
    void thatPlatformCanRegisterAccountForUser(){
        //given
        String firstName = "Oluwatobi";
        String lastName = "Jolayemi";
        String emailAddress = "jolayemi.tobi@gmail.com";
        String passWord = "12020";
        String userName = "Harry";

        User user = new User(firstName, lastName, emailAddress);
        //when
        platform.register(user, passWord, userName);
        //assert
        assertEquals(1, platform.getNumberOfUsers());
        assertNotNull(platform.findUserByEmail(emailAddress).getAccount());
    }

    @Test
    void thatSystemCannotRegisterTwoAccountWithSameEmail(){
        User user1 = new User("Tobi", "Bit", "tobi@gmail.com");
        platform.register(user1,"1230","tobi");
        User user2 = new User("Letter", "man", "tobi@gmail.com");
        assertEquals(1, platform.getNumberOfUsers());
        assertThrows(UsernameExistsException.class, () -> platform.register(user2, "1234", "tobi"));
    }

    @Test
    void thatUserCanLogOff(){
        //given
        User user1 = new User("Tobi", "Bit", "tobi@gmail.com");
        platform.register(user1, "1234", "Oluwa");
        assertTrue(platform.findUserByUsername("Oluwa").getAccount().getLoginStatus());
        //when
        platform.logOff(user1);
        //assert
        assertFalse(user1.getAccount().getLoginStatus());
    }

    @Test
    void thatPlatformCanLogInRegisteredAccount(){
        User user1 = new User("Tobi", "Bit", "tobi@gmail.com");
        platform.register(user1, "130120", "harry");
        platform.logOff(user1);
        assertFalse(user1.getAccount().getLoginStatus());
        //when
        platform.logInUser("harry", "130120");
        //assert
        assertTrue(user1.getAccount().getLoginStatus());
    }

    @Test
    void thatUserCannotLoginWithIncorrectPassword(){
        User user1 = new User("Tobi", "Bit", "tobi@gmail.com");
        platform.register(user1, "130120", "harry");
        platform.logOff(user1);
        assertFalse(user1.getAccount().getLoginStatus());
        //assert
        assertFalse(user1.getAccount().getLoginStatus());
        assertThrows(InvalidPasswordException.class, ()->platform.logInUser("harry", "130121"));
    }

    @Test
    void thatPlatformCanDeleteUser(){
        //given
        User user1 = new User("Tobi", "Bit", "tobi@gmail.com");
        platform.register(user1, "1234", "Oluwa");
        assertEquals(1, platform.getNumberOfUsers());
        //when
        platform.deleteUser("Oluwa");
        //assert
        assertEquals(0, platform.getNumberOfUsers());
    }
    @Test
    void thatAccountCanSendMessageThroughPlatform(){
        //given
        User user1 = new User("Oluwatobi", "Jolayemi", "tobi@yahoo.com");
        platform.register(  user1, "Oluwa", "1234");
        User user2 = new User("Oluwatosin", "Jolayemi", "tobi2@yahoo.com");
        platform.register(user2,"1234", "Tobi");
        //when
        String message = """
                I love Jesus
                """;
        user1.getAccount().sendMessage(message,platform, "Tobi");
        //assert
        assertEquals(1, user1.getAccount().getNumberOfSentMessages());
    }

    @Test
    void thatAccountCanReceiveMessageThroughPlatform(){
        //given
        User user1 = new User("Oluwatobi", "Jolayemi", "tobi@yahoo.com");
        platform.register(  user1, "Oluwa", "1234");
        User user2 = new User("Oluwatosin", "Jolayemi", "tobi2@yahoo.com");
        platform.register(user2,"1234", "Tobi");
        //when
        String message = """
                I love Jesus
                """;
        user1.getAccount().sendMessage(message,platform, "Tobi");
        //assert
        assertEquals(1, user2.getAccount().getNumberOfReceivedMessages());
    }
//
//    @Test
//    void thatAccountCanHavePostThroughPlatform(){
//        //given
//        Platform socialMedia = new Platform();
//        socialMedia.register("Oluwatobi", "Jolayemi", "tobi@yahoo.com", "1234", "Oluwa");
//        //when
//        String newPost = """
//                I love cooking;
//                Cooking is my hobby.
//                """;
//        socialMedia.createPost(newPost, "Oluwa");
//        assertEquals(1, socialMedia.getUser("Oluwa").getAccount().getSizeOfPost());
//    }

}
