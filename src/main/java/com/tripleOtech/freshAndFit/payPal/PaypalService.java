package com.tripleOtech.freshAndFit.payPal;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class PaypalService {
    private final APIContext apiContext;

    public Payment createPayment(PaypalPaymentRequest paypalPaymentRequest) throws PayPalRESTException {

        Amount amount= new Amount();
        amount.setCurrency(paypalPaymentRequest.getCurrency());
        amount.setTotal(String.format(Locale.forLanguageTag(paypalPaymentRequest.getCurrency()), "%.2f", paypalPaymentRequest.getTotal()));

        Transaction transaction = new Transaction();
        transaction.setDescription(paypalPaymentRequest.getDescription());
        transaction.setAmount(amount);

        List<Transaction> transactions= new ArrayList<>();
        transactions.add(transaction);

        Payer payer= new Payer();
        payer.setPaymentMethod(paypalPaymentRequest.getMethod());

        Payment payment = new Payment();
        payment.setIntent(paypalPaymentRequest.getIntent());
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        RedirectUrls redirectUrls =new RedirectUrls();
        redirectUrls.setCancelUrl(paypalPaymentRequest.getCancelUrl());
        redirectUrls.setReturnUrl(paypalPaymentRequest.getSuccessUrl());

        payment.setRedirectUrls(redirectUrls);
        return  payment.create(apiContext);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        Payment payment =new Payment();
        payment.setId(paymentId);

        PaymentExecution paymentExecution =new PaymentExecution();
        paymentExecution.setPayerId(payerId);
        return payment.execute(apiContext,paymentExecution);
    }
}
