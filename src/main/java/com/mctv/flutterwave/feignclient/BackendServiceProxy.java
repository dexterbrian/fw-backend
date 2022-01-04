package com.mctv.flutterwave.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

import static com.mctv.flutterwave.utils.URLs.BASE_URL;

/**
 * The Api service proxy. This class is used to make the calls to the API.
 */
@FeignClient(name = "update-payment-service", url = BASE_URL)
public interface BackendServiceProxy extends BackendService {

}
