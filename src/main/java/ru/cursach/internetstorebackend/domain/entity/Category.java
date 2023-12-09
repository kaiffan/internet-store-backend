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
@Table(name = "category")
public class Category extends Entity{
    private Integer id;
    private String title;
    private Integer id_parent_category;
}
