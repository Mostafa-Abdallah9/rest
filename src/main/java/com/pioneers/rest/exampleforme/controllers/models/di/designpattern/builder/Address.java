package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.builder;

import lombok.*;

@Getter
@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
public class Address {
    private final String id;
    private final String fName;
    private final String lName;
    private final String country;
    private final String city;
    private final  String street;

    public Address(AddressBuilder builder) {
        this.id = builder.id;
        this.fName = builder.fName;
        this.lName = builder.lName;
        this.country = builder.country;
        this.city = builder.city;
        this.street = builder.street;
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public static class AddressBuilder {
    private String id;
    private String fName;
    private String lName;
    private String country;
    private String city;
    private String street;

    public AddressBuilder id(final String id) {
        this.id = id;
        return this;
    }

        public AddressBuilder fName(final String fName) {
            this.fName = fName;
            return this;
        }

        public AddressBuilder lName(final String lName) {
            this.lName = lName;
            return this;
        }

        public AddressBuilder country(final String country) {
            this.country = country;
            return this;
        }

        public AddressBuilder city(final String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder street(final String street) {
            this.street = street;
            return this;
        }

        public Address build() {
        return new Address(this);
        }

    }

}
