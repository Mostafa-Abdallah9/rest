package com.pioneers.rest.exampleforme.controllers.models.di;

//@Component
/**
 * i cant be take new instance from PremiumSpellChecker because
 * attribyte ownerName to solve this problem it s necessary to use bean , configuration
 */
public class PremiumSpellChecker implements  SpellChecker{

    private final String ownerName;
    private final String version;
//    @Autowired
    public PremiumSpellChecker(String ownerName,String version) {
        this.ownerName = ownerName;
        this.version = version;
    }

    @Override
    public String getBeanName() {
        return ownerName;
    }
}
