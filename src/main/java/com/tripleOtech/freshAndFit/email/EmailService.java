package com.tripleOtech.freshAndFit.email;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {
    @Value(value = "${app.sendGrid-key}")
    private String emailKey;
    @Value(value = "${app.sendGrid-email}")
    private String emailAddress;
    @Value(value = "${app.sendGrid-name}")
    private String emailName;

    public String sendMail(EmailDetail emailDetail) throws IOException {
        Email fromEmail= setEmail(emailName,emailAddress);
        Email toEmail= setEmail(emailDetail.getToEmail().getName(),emailDetail.getToEmail().getEmailAddress());

        Content content = new Content("text/plain",emailDetail.getEmailContent());
        Mail mail= new Mail(fromEmail,emailDetail.getSubject(),toEmail,content);

        SendGrid sendGrid= new SendGrid(emailKey);

        Request request= new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail.send");
        request.setBody(mail.build());

        Response response= sendGrid.api(request);
        response.getBody();
        return response.getBody();

    }

    private Email setEmail(String name, String emailAddress){
        Email email= new Email();
        email.setName(name);
        email.setEmail(emailAddress);
        return email;
    }
}
