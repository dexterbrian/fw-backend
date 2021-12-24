package com.mctv.flutterwave.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import static com.mctv.flutterwave.utils.URLs.BASE_URL;

@FeignClient(name="update-payment-service",url = BASE_URL)
public interface BackendServiceProxy extends BackendService {
    
}
