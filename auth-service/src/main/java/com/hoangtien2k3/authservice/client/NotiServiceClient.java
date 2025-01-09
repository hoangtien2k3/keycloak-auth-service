package com.hoangtien2k3.authservice.client;

import com.hoangtien2k3.notificationmodel.dto.request.CreateNotificationDTO;
import com.reactify.model.response.DataResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * Client interface for interacting with the Notification Service.
 */
public interface NotiServiceClient {

    /**
     * Inserts a new transmission.
     *
     * @param createNotificationDTO
     *            the DTO containing the details of the notification to create
     * @return a Mono emitting an Optional containing a DataResponse if the
     *         operation was successful, or an empty Optional if not
     */
    Mono<Optional<DataResponse>> insertTransmission(CreateNotificationDTO createNotificationDTO);
}
