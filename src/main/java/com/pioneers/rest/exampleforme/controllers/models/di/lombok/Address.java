package com.pioneers.rest.exampleforme.controllers.models.di.lombok;

import lombok.*;

import java.util.Objects;

//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@Data

//@ToString(of = {"id","fName","lName","country"})
//@ToString(includeFieldNames = false)
//@ToString(exclude = {"id","fName","lName","country"})
//@ToString(onlyExplicitlyIncluded = false)
public record Address(    String id,
                          String fName,
                          String lName,
                          String country,
                          String city,
                          String street) {
//    @ToString.Exclude


}
