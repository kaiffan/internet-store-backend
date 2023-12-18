package ru.cursach.internetstorebackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cursach.internetstorebackend.annotation.Table;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dimensions")
public class Dimensions extends Entity {
    private UUID id;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer weight;
}
