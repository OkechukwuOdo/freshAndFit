package com.tripleOtech.freshAndFit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Long id;
    private String country;
    private String state;
    private String lga;
    private String landMark;
    private String streetAddress;
}
