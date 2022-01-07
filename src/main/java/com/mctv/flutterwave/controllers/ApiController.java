package com.mctv.flutterwave.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mctv.flutterwave.feignclient.ApiService;
import com.mctv.flutterwave.feignclient.ApiServiceProxy;
import com.mctv.flutterwave.models.*;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 * <p>
 * 1. This class is the controller for the API.
 * 2. It is responsible for handling all the requests from the front
 * end.
 * 3. It is also responsible for handling all the requests from the
 * backend.
 */
@RestController
@RequestMapping("/data")
@EnableFeignClients(basePackageClasses = ApiServiceProxy.class)
public class ApiController implements ApiService {
    private final ApiServiceProxy apiServiceProxy;
    private final FlutterwaveController fwController;

    /**
     * @param apiServiceProxy The api service proxy used to fetch the user's details
     * @param fwController    The flutterwave controller used to fetch the payment
     *                        details
     */
    public ApiController(ApiServiceProxy apiServiceProxy, FlutterwaveController fwController) {
        this.apiServiceProxy = apiServiceProxy;
        this.fwController = fwController;
    }

    /**
     * @param email           The current user's email address used to fetch the
     *                        user's
     *                        details
     * @param ref             The content's reference used to fetch the content's
     *                        details
     * @param transactionType The transaction type used to fetch the payment details
     *                        i.e. EST, PVOD, or RENTAL
     * @param currency        The currency used to make the payment
     * @return The rave model payment view for the flutterwave payment
     * <p>
     * This method is responsible for handling fetching the payment and user
     * details from the backend.
     */
    @GetMapping(path = "/pay")
    public ModelAndView getPaymentDetails(@RequestParam String email, @RequestParam String ref,
                                          @RequestParam String transactionType, @RequestParam String currency) throws JsonProcessingException {
        // Get the user details and the content details from the backend
        Content content = getContentByRef("true", ref, currency);
        //get prices per country
        getPricesPerCountry(content,currency);
        User user = apiServiceProxy.getUsersByEmail(email);
        // Create the customer object
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPhone_number(user.getPhone());
        customer.setName(user.getFullname());

        UpdatePayload uPayload = new UpdatePayload();
        uPayload.setUser_id(user.getId());
        uPayload.setPurchase_type(transactionType);
        uPayload.setRef(ref);
        uPayload.setCurrency(currency);

        // pRepo.save(uPayload);
        return fwController.payment(content, customer, transactionType, uPayload);
    }

    /**
     * @param contentRef The content reference used to fetch the content details
     * @return A content object containing the content details
     * @see Content
     */
    @Override
    @GetMapping(path = "/content")
    public Content getContentByRef(@RequestParam String is_updated, @RequestParam("ref") String contentRef, @RequestParam("currency") String currency) {
        return apiServiceProxy.getContentByRef(is_updated, contentRef, currency);
    }

    /**
     * @param email The user's email address used to fetch the user's details
     * @return A user object containing the user details
     * @see User
     */
    @Override
    @GetMapping("/users")
    public User getUsersByEmail(@RequestBody String email) {
        return apiServiceProxy.getUsersByEmail(email);
    }

    public void getPricesPerCountry(Content content, String currency) throws JsonProcessingException {
        //configure objectMapper to deserialize string to json
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

        //Get prices per country as a string
        String estPrice = content.getEst_price();
        String rentalPrice = content.getRental_price();
        String pvodPrice = content.getPvod_price();
        
        //Convert string to json
        CountryPrice estPriceObj = objectMapper.readValue(estPrice, new TypeReference<CountryPrice>() {});
        CountryPrice rentalPriceObj = objectMapper.readValue(rentalPrice, new TypeReference<CountryPrice>() {});
        CountryPrice pvodPriceObj = objectMapper.readValue(pvodPrice, new TypeReference<CountryPrice>() {});
        
        //Update prices depending on currency
        switch (currency) {
            case "NGN":
                setPrice(content, estPriceObj.getNigeria(), rentalPriceObj.getNigeria(), pvodPriceObj.getNigeria());
                break;
            case "KES":
                setPrice(content, estPriceObj.getKenya(), rentalPriceObj.getKenya(), pvodPriceObj.getKenya());
                break;
            case "GHS":
                setPrice(content, estPriceObj.getGhana(), rentalPriceObj.getGhana(), pvodPriceObj.getGhana());
                break;
            case "ZAR":
                setPrice(content, estPriceObj.getSouthafrica(), rentalPriceObj.getSouthafrica(), pvodPriceObj.getSouthafrica());
                break;
            case "UGX":
                setPrice(content, estPriceObj.getUganda(), rentalPriceObj.getUganda(), pvodPriceObj.getUganda());
                break;
            case "TZS":
                setPrice(content, estPriceObj.getTanzania(), rentalPriceObj.getTanzania(), pvodPriceObj.getTanzania());
                break;
            case "RWF":
                setPrice(content, estPriceObj.getRwanda(), rentalPriceObj.getRwanda(), pvodPriceObj.getRwanda());
                break;
        }
        
        
    }

    private void setPrice(Content content, String estPriceObj, String rentalPriceObj, String pvodPriceObj) {
        content.setEst_price(estPriceObj);
        content.setRental_price(rentalPriceObj);
        content.setPvod_price(pvodPriceObj);
    }
}