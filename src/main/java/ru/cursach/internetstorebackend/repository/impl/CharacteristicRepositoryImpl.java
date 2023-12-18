package ru.cursach.internetstorebackend.repository.impl;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import ru.cursach.internetstorebackend.domain.dto.CharacteristicDTO;
import ru.cursach.internetstorebackend.domain.entity.Characteristic;
import ru.cursach.internetstorebackend.domain.entity.TypeFeature;
import ru.cursach.internetstorebackend.repository.BaseJDBCTemplateRepository;
import ru.cursach.internetstorebackend.repository.interfaces.CharacteristicRepository;

import java.util.List;
import java.util.UUID;

@Repository
public class CharacteristicRepositoryImpl extends BaseJDBCTemplateRepository<Characteristic> implements CharacteristicRepository {
    public CharacteristicRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, Characteristic.class);
    }

    @Override
    public void insertCharacteristicByProduct(CharacteristicDTO characteristic,  UUID codeProduct) {
        String sqlInsertCharacteristic = "insert into characteristic values (?, ?, ?)";

        jdbcTemplate.update(sqlInsertCharacteristic,
                characteristic.getValue(),
                characteristic.getId(),
                codeProduct);
    }

    @Override
    public List<TypeFeature> getAllTypeFeatureBySubcategory(int idSubcategory) {
        String sql = "select type_feature.id as id, " +
                "type_feature.name as name, " +
                "type_feature.id_unit_measurement as unitMeasurement," +
                "type_feature.id_data_type as dataType " +
                "from characteristic_subcategory" +
                "         join type_feature on characteristic_subcategory.id_type_feature = type_feature.id " +
                "where characteristic_subcategory.id_sub_category = " + idSubcategory;

        ResultSetExtractor<List<TypeFeature>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(TypeFeature.class);
        return jdbcTemplate.query(sql, mapper);
    }
}
