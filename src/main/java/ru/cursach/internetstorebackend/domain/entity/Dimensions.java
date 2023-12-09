package ru.cursach.internetstorebackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dimensions {
    private UUID id;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer weight;
}
