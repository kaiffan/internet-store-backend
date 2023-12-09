package ru.cursach.internetstorebackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleflatmapper.map.annotation.Key;
import ru.cursach.internetstorebackend.annotation.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subcategory")
public class Subcategory extends Entity {
    @Key
    private Integer id;
    private String title;
    private Integer id_parent_category;
}
