package com.mctv.flutterwave.repositories;

import java.util.UUID;
import com.mctv.flutterwave.models.UpdatePayload;
import org.springframework.data.repository.CrudRepository;

public interface UpdatePayloadRepository extends CrudRepository<UpdatePayload, UUID> {
    UpdatePayload findByTx(String fromString);
}