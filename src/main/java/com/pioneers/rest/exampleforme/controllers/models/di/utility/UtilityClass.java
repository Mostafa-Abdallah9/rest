package com.pioneers.rest.exampleforme.controllers.models.di.utility;

import lombok.*;

@Getter
@ToString
//@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class UtilityClass {
    private final String id;
    private final String fName;
    private final String lName;
    private final String country;
    private final String city;
    private final String streat;

    public UtilityClass(UtilityClassBuilder builder) {
        this.id = builder.id;
        this.fName = builder.fName;
        this.lName = builder.lName;
        this.country = builder.country;
        this.city = builder.city;
        this.streat = builder.streat;
    }

    public static UtilityClassBuilder builder(){
        return new UtilityClassBuilder();
    }

    public static class UtilityClassBuilder {
        private String id;
        private String fName;
        private String lName;
        private String country;
        private String city;
        private String streat;

        public UtilityClassBuilder id(final String id) {
            this.id = id;
            return this;
        }

        public UtilityClassBuilder fName(final String fName) {
            this.fName = fName;
            return this;
        }

        public UtilityClassBuilder lName(final String lName) {
            this.lName = lName;
            return this;
        }

        public UtilityClassBuilder country(final String country) {
            this.country = country;
            return this;
        }

        public UtilityClassBuilder city(final String city) {
            this.city = city;
            return this;
        }

        public UtilityClassBuilder streat(final String streat) {
            this.streat = streat;
            return this;
        }

        public UtilityClass build(){
            return new UtilityClass(this);
        }
    }
}