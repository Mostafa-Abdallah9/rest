package com.pioneers.rest.exampleforme.controllers.models.di;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("text")
public class TextEditorController {

    private TextEditor textEditor;
    private PremiumSpellChecker premiumSpellChecker;

    @Autowired
    public TextEditorController(TextEditor textEditor,PremiumSpellChecker premiumSpellChecker) {
        log.info("I am injecting the TextEditor bean in the TextEditorController");
        this.textEditor = textEditor;
        this.premiumSpellChecker = premiumSpellChecker;
    }

//@Autowired
//    public void setTextEditor(TextEditor textEditor) {
//        System.out.println("setter method");
//        this.textEditor = textEditor;
//    }

    @GetMapping("find")
    public String findOwnerOfTextEditor() {
        return ((PaidSpellChecker) textEditor.getSpellChecker()).getOwner();
    }

//    @GetMapping("prem")
//    public PremiumSpellChecker premiumSpellChecker() {
//        return new PremiumSpellChecker(premiumSpellChecker.)
//    }
}
