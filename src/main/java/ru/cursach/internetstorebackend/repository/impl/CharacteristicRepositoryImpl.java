package ru.cursach.internetstorebackend.repository.impl;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicDTO;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicProductDTO;
import ru.cursach.internetstorebackend.domain.dto.referenceValue.ReferenceValueDTO;
import ru.cursach.internetstorebackend.domain.dto.referenceValue.ReferenceValueForArrayDTO;
import ru.cursach.internetstorebackend.domain.entity.Characteristic;
import ru.cursach.internetstorebackend.domain.entity.Subcategory;
import ru.cursach.internetstorebackend.domain.entity.TypeFeature;
import ru.cursach.internetstorebackend.repository.BaseJDBCTemplateRepository;
import ru.cursach.internetstorebackend.repository.interfaces.CharacteristicRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CharacteristicRepositoryImpl extends BaseJDBCTemplateRepository<Characteristic> implements CharacteristicRepository {
    public CharacteristicRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, Characteristic.class);
    }

    @Override
    public void insertCharacteristicByProduct(
            CharacteristicDTO characteristic,
            UUID codeProduct
    ) {
        String sqlInsertCharacteristic = "insert into characteristic values (?, ?, ?)";

        jdbcTemplate.update(sqlInsertCharacteristic,
                characteristic.getValue(),
                characteristic.getId(),
                codeProduct);
    }

    @Override
    public List<TypeFeature> getAllTypeFeatureBySubcategory(
            int idSubcategory
    ) {
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

    @Override
    public List<CharacteristicProductDTO> getAllTypeFeatureByProductCode(
            String codeProduct
    ) {
        String sql = "select type_feature.name as name," +
                "characteristic.value as value " +
                "from characteristic " +
                "join type_feature on characteristic.id_type_feature = type_feature.id " +
                "where characteristic.id_product = " + "'" + codeProduct + "'";
        ResultSetExtractor<List<CharacteristicProductDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(CharacteristicProductDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<ReferenceValueForArrayDTO> getAllReferenceValueByTypeFeature(int typeFeature) {
        String sql = "select reference_value.name_value as nameValue " +
                "from reference_value " +
                "where id_type_feature = " + typeFeature;

        ResultSetExtractor<List<ReferenceValueForArrayDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(ReferenceValueForArrayDTO.class);

        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public ReferenceValueDTO getNameTypeFeature(int typeFeature) {
        String sql = "select type_feature.id as idTypeFeature, " +
                "type_feature.name as nameTypeFeature " +
                "from type_feature " +
                "where id = " + typeFeature;
        RowMapper<ReferenceValueDTO> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(ReferenceValueDTO.class);
        List<ReferenceValueDTO> referenceValues = jdbcTemplate.query(sql, mapper);
        return referenceValues.get(0);
    }
}
