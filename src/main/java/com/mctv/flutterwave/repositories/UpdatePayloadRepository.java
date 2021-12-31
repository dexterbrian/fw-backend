package com.mctv.flutterwave.repositories;

import java.util.UUID;
import com.mctv.flutterwave.models.UpdatePayload;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 * 
 *         1. This class is the repository for the update payload.
 */
public interface UpdatePayloadRepository extends CrudRepository<UpdatePayload, UUID> {
    UpdatePayload findByTx(String fromString);
}