package com.tripleOtech.freshAndFit.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetail {
    private EmailInfo toEmail;
    private String subject;
    private String emailContent;
}
