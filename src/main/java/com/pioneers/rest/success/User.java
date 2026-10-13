package com.pioneers.rest.success;

import java.util.List;

public class User {
    private String name;
    private List<String> phoneNumbers;

    public User(String name, List<String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}
