package ru.cursach.internetstorebackend.domain.dto.analytical;

import lombok.Data;

import java.util.UUID;

@Data
public class AnalyticUuidDTO {
    private UUID idWarehouse;
    private Long countProcessedOrders;
}
