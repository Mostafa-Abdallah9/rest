package com.pioneers.rest.exampleforme.controllers.services;

import com.pioneers.rest.exampleforme.controllers.errors.exceptions.CredentialsException;
import com.pioneers.rest.exampleforme.controllers.models.dtos.requests.StudentRegister;
import com.pioneers.rest.exampleforme.controllers.models.dtos.requests.UpdateStudent;
import com.pioneers.rest.exampleforme.controllers.models.entites.Student;
import com.pioneers.rest.exampleforme.controllers.utils.validators.StudentValidation;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StudentService {

    public static Student loggedInStudent;

    public static final Map<UUID, Student> STUDENT_DB = new ConcurrentHashMap<>();

    public static String hashPassword(final String password) throws CredentialsException {
        Optional.ofNullable(password)
                .orElseThrow(() -> {
                    throw new CredentialsException("password cant be null");
                });

        byte[] hash;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            hash = messageDigest.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new CredentialsException("algorethim not found");
        }
        return Base64.getEncoder().encodeToString(hash);
    }

    public static Student save(final Student student) {
        STUDENT_DB.put(student.getId(), student);
        return student;    }

    public static String buildFullName(final StudentRegister studentRegister) {
        return studentRegister.getFirstName() + " " + studentRegister.getLastName();
    }

    public static boolean isEmailExists(final String email) {
        return STUDENT_DB.values()
                .stream()
                .anyMatch(student -> student.getEmail().equalsIgnoreCase(email));

    }

    public static boolean isPasswordCorrect(final String password, final Student student) {
        return student.getPassword().equals(hashPassword(password));
    }

    public static Optional<Student> findByEmail(final String email) {
        return STUDENT_DB.values()
                .stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst();
    }

    public static void delete(final UUID id) {
        STUDENT_DB.remove(id);
    }

    public static void deleteAll() {
        STUDENT_DB.clear();
    }

    public static Optional<Student> findById(final UUID id) {
        return Optional.ofNullable(STUDENT_DB.get(id));
    }

    public static Student update(final UUID id, final UpdateStudent updateStudent) {
    final Student student = STUDENT_DB.get(id);
         if (student == null) {
             throw new RuntimeException("Studentt not found");
         }
         student.setPassword(hashPassword(updateStudent.getPassword()));
         student.setEmail(updateStudent.getEmail());
         student.setAge(updateStudent.getAge());
         student.setFullName(updateStudent.getFirstName() + " " + updateStudent.getLastName());
         STUDENT_DB.put(id,student);
         return student;
    }



    public static Collection<Student> findAllSortByAge() {
        return STUDENT_DB.values()
                .stream()
                .sorted((student1,student2) ->Integer.compare(student1.getAge(), student2.getAge()))
                .toList();
    }

    public static Collection<Student> findAllSucceeded() {
        return STUDENT_DB.values()
                .stream()
//                .filter((student)-> (student.getScore()/student.getFinalScore()>0.5f))
                .filter(StudentValidation::isStudentPassed)
                .toList();
    }





}