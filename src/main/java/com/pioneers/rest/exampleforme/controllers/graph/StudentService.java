package com.pioneers.rest.exampleforme.controllers.graph;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final List<Studentt> studentts = new ArrayList<>();

    public StudentService() {
        Studentt studentt = new Studentt(
                UUID.randomUUID(),
                "Mostafa",
                "Mohamed",
                23,
                "mostafa@gmail.com"
        );

        studentts.add(studentt);

        System.out.println("Student ID = " + studentt.getId());

    }

    public Studentt findById(final UUID id) throws MostafaException{
        return studentts.stream()
                .filter(studentt -> studentt.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new MostafaException("this is Studentt not found with this is Id" + id));
    }

//    public StudenttResponse changeFirstName(UUID id, String firstName) {
//        Studentt studentt = findById(id);
//        studentt.setFirstName(firstName);
//        return new StudenttResponse(
//                studentt.getFirstName(),
//                studentt.getSecondName(),
//                studentt.getAge()
//        );
//    }

//    public StudenttResponse changeSecondName(final UUID id, final String secondName) throws StudentException{
//        Studentt studentt = findById(id);
//        studentt.setSecondName(secondName);
//        return new StudenttResponse(
//                studentt.getFirstName(),
//                studentt.getSecondName(),
//                studentt.getAge()
//        );
//    }

}
