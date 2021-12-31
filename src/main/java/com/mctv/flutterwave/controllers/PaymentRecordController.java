package com.mctv.flutterwave.controllers;

import com.mctv.flutterwave.feignclient.BackendService;
import com.mctv.flutterwave.feignclient.BackendServiceProxy;
import com.mctv.flutterwave.models.BackendResponse;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 * 
 *         1. This class is the controller for the backend service response on
 *         the backend payment confirmation.
 */
@RestController
@RequestMapping("/flutterwave")
@EnableFeignClients(basePackageClasses = BackendServiceProxy.class)
public class PaymentRecordController implements BackendService {

    private final BackendServiceProxy backendServiceProxy;

    /**
     * @param backendServiceProxy The backend service proxy used to fetch the
     *                            backend payment details
     */
    public PaymentRecordController(BackendServiceProxy backendServiceProxy) {
        this.backendServiceProxy = backendServiceProxy;
    }

    /**
     * @param user_id         The user's id
     * @param purchase_type   The purchase type ie EST, PVOD, RENTAL
     * @param ref             The content's reference
     * @param isflutterwave   Wether or not the payment was made using flutterwave.
     *                        Always set to true for this microservice.
     * @param currency        The currency used to make the payment
     * @param transactioncode The transaction code used to make the payment
     * 
     * @return The backend service response
     * 
     *         This method is responsible for handling the backend payment
     *         confirmation.
     */
    @Override
    public BackendResponse recordPayment(String user_id, String purchase_type, String ref, String isflutterwave,
            String currency, String transactioncode) {
        return backendServiceProxy.recordPayment(user_id, purchase_type, ref, isflutterwave, currency, transactioncode);
    }

}
