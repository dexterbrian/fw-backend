package com.mctv.flutterwave.feignclient;

import com.mctv.flutterwave.models.BackendResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 *
 * This is the interface for the Backend Service that updates payments
 */
public interface BackendService {

    @PostMapping(path="api/v1/users/buy",
    consumes = {"multipart/form-data"})
    @ResponseBody
    BackendResponse recordPayment(@RequestPart String user_id,@RequestPart String purchase_type, @RequestPart String ref, @RequestPart String isflutterwave, @RequestPart String currency, @RequestPart String transactioncode);
}
