package com.tripleOtech.freshAndFit.payPal;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
@RequiredArgsConstructor
@Slf4j
public class PaypalController {
    private final PaypalService paypalService;
@PostMapping("/create")
    public void createPayment(@RequestBody PaypalPaymentRequest paypalPaymentRequest) throws PayPalRESTException {
   Payment payment= paypalService.createPayment(paypalPaymentRequest);
   for (Links links: payment.getLinks()){
       if(links.getRel().equals("approval_url")){
           log.info(links.getHref());
       }
   }
    }
@GetMapping("/success")
    public String paymentSuccess(
            @RequestParam("payment_Id") String payment_Id,
            @RequestParam("payment_Id") String payer_Id){
    try {
        Payment payment=paypalService.executePayment(payment_Id,payer_Id);
        if (payment.getState().equals("approved")){
            log.info("approve");
        }
    }catch (PayPalRESTException e){
        log.info("d");
    }
    return "";
    }

    @GetMapping("/cancel")
    public String paymentCancel(){
        return " Payment Cancelled";
    }
}
