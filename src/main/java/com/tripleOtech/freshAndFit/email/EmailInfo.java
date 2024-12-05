package com.tripleOtech.freshAndFit.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailInfo {
    private String name;
    private String emailAddress;
}
