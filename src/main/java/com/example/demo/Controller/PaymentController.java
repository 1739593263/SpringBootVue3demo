package com.example.demo.Controller;

import com.example.demo.Bean.CreatePaymentResponse;
import com.example.demo.Bean.Message;
import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.checkout.Session;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://192.168.0.177:8081")
public class PaymentController {
    @Value("${stripe.api.key}")
    String apikey;
    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent() throws StripeException {

        Stripe.apiKey = apikey;

        PaymentIntentCreateParams params =
                PaymentIntentCreateParams
                        .builder()
                        .setAmount(500L)
                        .setCurrency("gbp")
                        .setPaymentMethod("pm_card_visa")
                        .build();

        PaymentIntent paymentIntent = PaymentIntent.create(params);
        CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
        return paymentResponse;
    }

    @PostMapping("/create-checkout-session")
    public Session checkoutSession() throws StripeException {
        Stripe.apiKey = apikey;
        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://192.168.0.177:8081/home")
                .setCancelUrl("http://192.168.0.177:8081/home")
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setQuantity(1L)
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency("usd")
                                                .setUnitAmount(2000L)
                                                .setProductData(
                                                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                .setName("T-shirt")
                                                                .setDescription("Men's Crew T-Shirts, Multipack, Style G1100")
                                                                .build()
                                                ).build()
                                ).build()
                ).build();
        Session session = Session.create(params);
        return session;
    }
}
