package com.mctv.flutterwave.feignclient;

import com.mctv.flutterwave.models.Content;
import com.mctv.flutterwave.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 * <p>
 * This is the interface for the ApiService.
 */
public interface ApiService {

    /**
     * @param contentRef The content reference.
     * @param is_updated For the backend to work properly
     * @return The requested content.
     * <p>
     * This method returns the content for the given content reference.
     */
    @PostMapping(path = "api/v1/content", consumes = {"application/json",
            "multipart/form-data"})
    @ResponseBody
    // inside response
    // @ResponeParam ...?email=value
    // @PatrhVariable .../{variable}
    Content getContentByRef(@RequestParam String is_updated, @RequestParam("ref") String contentRef, @RequestParam("currency") String currency);

    /**
     * @param email The user's email.
     * @return The requested user.
     */
    @PostMapping(path = "api/v1/users/customerid", consumes = {"multipart/form-data"})
    @ResponseBody
    User getUsersByEmail(@RequestPart String email);

    // todo:add endpoint to make a purchase

}