package com.mctv.flutterwave;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 * <p>
 * 1. This class is the configuration for the feign client logger.
 * 2. It is responsible for setting the logger level.
 */
@Configuration
public class FeignLoggingConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
