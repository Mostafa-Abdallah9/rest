//package com.pioneers.rest.services;
//
//import com.pioneers.rest.models.dtos.requests.User;
//import org.springframework.stereotype.Service;
//
//import java.util.LinkedList;
//import java.util.NoSuchElementException;
//@Service
//public class UserService {
//    private final LinkedList<User> users;
//
//    public UserService() {
//        this.users = new LinkedList<>();
//    }
//
//    private User validateUserEmail(final String email) {
//        for (final User user : users) {
//            if (user.getEmail().equals(email) || user.getEmail() != null) {
//                return user;
//            }
//        }
//        throw new NoSuchElementException("this is user is not found");
//    }
//
//    private void validateUserPassword(final User user, final String password) {
//        if (!user.getPassword().equals(password)) {
//            throw new UserException("password is incorrect");
//        }
//    }
//
//    public LinkedList<User> signup(final User user) throws NoSuchElementException {
//            validateUserEmail(user.getEmail());
//            users.add(user);
//            return users;
//    }
//
//    public User logIn(final String password, final String email) throws UserException {
//        final User user = validateUserEmail(email);
//        validateUserPassword(user, password);
//        return user;
//    }
//
//    public void logOut(final String password, final String email) throws UserException {
//        final User user = validateUserEmail(email);
//        validateUserPassword(user, password);
//    }
//}
