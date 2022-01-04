package com.mctv.flutterwave.repositories;

import com.mctv.flutterwave.models.UpdatePayload;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 * <p>
 * 1. This class is the repository for the update payload.
 */
public interface UpdatePayloadRepository extends CrudRepository<UpdatePayload, UUID> {
    UpdatePayload findByTx(String fromString);
}