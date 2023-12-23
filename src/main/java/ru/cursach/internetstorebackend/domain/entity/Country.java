package ru.cursach.internetstorebackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cursach.internetstorebackend.annotation.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
public class Country extends Entity {
    private Integer id;
    private String value;
}
