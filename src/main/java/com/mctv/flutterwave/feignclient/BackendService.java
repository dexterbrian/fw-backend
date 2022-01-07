package com.mctv.flutterwave.feignclient;

import com.mctv.flutterwave.models.BackendResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 * <p>
 * This is the interface for the Backend Service that updates payments
 */
public interface BackendService {

    /**
     * This method is used to update the payment status
     *
     * @param user_id         The user id of the users account being updated
     * @param purchase_type   The purchase type of the content
     * @param ref             The reference of the content being purchased
     * @param isflutterwave   Wether it is a flutterwave payment or not
     * @param currency        The currency of the payment
     * @param transactioncode The transaction code of the payment
     * @return The response from the backend service
     */
    @PostMapping(path = "api/v1/users/buy", consumes = {"multipart/form-data"})
    @ResponseBody
    BackendResponse recordPayment(@RequestPart String user_id, @RequestPart String purchase_type,
                                  @RequestPart String ref, @RequestPart String isflutterwave, @RequestPart String currency,
                                  @RequestPart String transactioncode);
}
