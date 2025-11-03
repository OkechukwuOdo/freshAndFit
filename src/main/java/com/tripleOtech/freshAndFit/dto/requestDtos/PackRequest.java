package com.tripleOtech.freshAndFit.dto.requestDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PackRequest {
    private String name;
    private Integer quantity;
    private Integer numberOfPersonRequired;
    private Integer numberOfPersonAvailable;
    private Double totalAmount;
    private Double amountPerPerson;
}
