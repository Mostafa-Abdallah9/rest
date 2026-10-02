package com.pioneers.rest.function_programming.nn;

import org.springframework.stereotype.Service;

@Service
//@Validated
public class StudentService {

    public void apply(final StudentRegister studentRegister, final StudentSuccess studentSuccess) {
      studentSuccess.passedStudent();

    }

}
