package com.inclutab.socialMedia;

public class User {

    private final String firstName;
    private final String lastname;
    private final String emailAddress;
    private Account account;

    public User(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastname = lastName;
        this.emailAddress = emailAddress;
    }

    public void setAccount(Account newAccount) {
        this.account = newAccount;
    }

    public Account getAccount() {
        return account;
    }
}
