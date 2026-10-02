package com.pioneers.rest.exampleforme.controllers.models.di;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class TextEditor {
private Student student;
    private SpellChecker spellChecker;

    // Tightly coupled
    public TextEditor() {
        log.info("I am in the empty constructor of TextEditor");
//        this.spellChecker = new FreeSpellChecker();
    }

    // Loosely coupled
    @Autowired
    public TextEditor(@Qualifier(value = "bb") SpellChecker spellChecker,Student student) {
        log.info("spellChecker.getBeanName() = " + spellChecker.getBeanName());
        System.out.println("I am in the parameterized constructor of TextEditor");
        this.spellChecker = spellChecker;
        this.student = student;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

//    @Autowired
//    public void setSpellChecker(SpellChecker spellChecker) {
//        System.out.println("I am in the setSpellChecker");
//        this.spellChecker = spellChecker;
//    }

    }

//    private Studentt student;
//
//    public TextEditor(Studentt student) {
//        System.out.println("TextEditor");
//        this.student = student;
//    }
//
//    public TextEditor() {
//        System.out.println("TextEditor");
//
//    }
//
//    public Studentt getStudent() {
//        return student;
//    }
//
//    public void setStudent(Studentt student) {
//        this.student = student;
//    }


