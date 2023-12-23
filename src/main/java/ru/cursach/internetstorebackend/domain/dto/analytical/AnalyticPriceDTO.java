package ru.cursach.internetstorebackend.domain.dto.analytical;

import lombok.Data;

import java.util.Date;

@Data
public class AnalyticPriceDTO {
    private double value;
    private Date datePrice;
}
