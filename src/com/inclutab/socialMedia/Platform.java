package com.inclutab.socialMedia;

import com.inclutab.socialMedia.socialMediaExceptions.InvalidPasswordException;
import com.inclutab.socialMedia.socialMediaExceptions.UsernameExistsException;

import java.util.ArrayList;

public class Platform {

    private ArrayList <User> registeredUsers = new ArrayList<>();
    private static Platform platform;

    private Platform(){

    }

    public void clearDataBase(){
        registeredUsers.clear();
    }

    public static Platform createInstanceOf() {
        if(platform==null){
            platform = new Platform();
        }
        return platform;
    }


    public void register(User user, String passWord, String userName) {
            if(registeredUsers.size() == 0){
                Account newAccount = new Account(passWord, userName);
                user.setAccount(newAccount);
                registeredUsers.add(user);
            }else {
                for (User existing: registeredUsers) {
                    if (!existing.getEmail().equals(user.getEmail())) {
                        Account newAccount = new Account(passWord, userName);
                        user.setAccount(newAccount);
                        registeredUsers.add(user);
                        break;
                    }else{
                        throw new UsernameExistsException("Username already exist");
                    }
                }
            }

    }

    public User findUserByUsername(String userName) {
        for (User user: registeredUsers) {
            if(user.getAccount().getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    public int getNumberOfUsers() {
       return registeredUsers.size();
    }

    public void logInUser(String userName, String passWord) {
        for (User user: registeredUsers) {
            if(user.getAccount().getUserName().equals(userName)){
                if(user.getAccount().getPassWord().equals(passWord)){
                    this.findUserByUsername(userName).getAccount().setLoginStatus();
                }else{
                    throw new InvalidPasswordException("Enter correct password");
                }
            }
        }
    }


    public User findUserByEmail(String emailAddress) {
        for (User user: registeredUsers) {
            if(user.getEmail().equals(emailAddress)){
                return user;
            }
        }
        return null;
    }

    public void createPost(String newPost, String userName) {
        for (User user: registeredUsers){
            if(user.getAccount().getUserName().equals(userName)){
                Post post = new Post(newPost, userName);
                user.getAccount().addToPostList(post);
            }
        }
    }

    public void logOff(User user) {
        user.getAccount().setLoginStatus();
    }

    public void deleteUser(String userName) {
        User user = this.findUserByUsername(userName);
        registeredUsers.remove(user);
    }
}
