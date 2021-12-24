package com.mctv.flutterwave.controllers;

import com.mctv.flutterwave.feignclient.BackendService;
import com.mctv.flutterwave.feignclient.BackendServiceProxy;
import com.mctv.flutterwave.models.BackendResponse;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flutterwave")
@EnableFeignClients(basePackageClasses = BackendServiceProxy.class)
public class PaymentRecordController implements BackendService {

    private final BackendServiceProxy backendServiceProxy;

    public PaymentRecordController(BackendServiceProxy backendServiceProxy) {
        this.backendServiceProxy = backendServiceProxy;
    }

    @Override
    public BackendResponse recordPayment(String user_id, String purchase_type, String ref, String isflutterwave,
            String currency, String transactioncode) {
        // TODO Auto-generated method stub
        return backendServiceProxy.recordPayment(user_id, purchase_type, ref, isflutterwave, currency, transactioncode);
    }
    
}
