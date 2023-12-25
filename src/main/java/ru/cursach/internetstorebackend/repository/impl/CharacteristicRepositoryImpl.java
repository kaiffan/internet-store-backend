package ru.cursach.internetstorebackend.repository.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicDTO;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicOperationDTO;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicProductDTO;
import ru.cursach.internetstorebackend.domain.dto.referenceValue.ReferenceValueDTO;
import ru.cursach.internetstorebackend.domain.dto.referenceValue.ReferenceValueForArrayDTO;
import ru.cursach.internetstorebackend.domain.entity.Characteristic;
import ru.cursach.internetstorebackend.domain.entity.TypeFeature;
import ru.cursach.internetstorebackend.repository.BaseJDBCTemplateRepository;
import ru.cursach.internetstorebackend.repository.interfaces.CharacteristicRepository;
import ru.cursach.internetstorebackend.utils.Utils;

import java.util.List;
import java.util.StringJoiner;
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
        String sqlInsertCharacteristic = "call insert_characteristic_product(?, ?, ?)";

        jdbcTemplate.update(sqlInsertCharacteristic,
                characteristic.getValue(),
                characteristic.getId(),
                codeProduct);
    }

    @Override
    public List<TypeFeature> getAllTypeFeatureBySubcategory(
            int idSubcategory
    ) {
        String sql = "select id_type_feature as id, name_type_feature as name, " +
                "id_unit_measurement as unitMeasurement, " +
                "id_data_type as dataType " +
                "from get_all_type_feature_subcategory(" + idSubcategory + ")";

        ResultSetExtractor<List<TypeFeature>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(TypeFeature.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<CharacteristicProductDTO> getAllTypeFeatureByProductCode(
            String codeProduct
    ) {
        String sql = "select name_type_feature as name, value_characteristic as value " +
                "from get_all_type_feature_product_code(" + Utils.wrapUUID(codeProduct) + ")";
        ResultSetExtractor<List<CharacteristicProductDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(CharacteristicProductDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<CharacteristicDTO> getAllTypeFeatureWithIDByProductCode(
            String codeProduct
    ) {
        String sql = "select id_type_feature as id, value_characteristic as value " +
                "from get_all_type_feature_by_id_product_code(" + Utils.wrapUUID(codeProduct) + ")";
        ResultSetExtractor<List<CharacteristicDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(CharacteristicDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<ReferenceValueForArrayDTO> getAllReferenceValueByTypeFeature(int typeFeature) {
        String sql = "select name_value_ref_val as value, id_referemce_value as id " +
                " from get_all_reference_value_by_type_feature(" + typeFeature + ")";

        ResultSetExtractor<List<ReferenceValueForArrayDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(ReferenceValueForArrayDTO.class);

        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public ReferenceValueDTO getNameTypeFeature(int typeFeature) {
        String sql = "select id_type_feature as id , name_type_feature as name " +
                "from get_name_type_feature(" + typeFeature + ")";
        RowMapper<ReferenceValueDTO> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(ReferenceValueDTO.class);
        List<ReferenceValueDTO> referenceValues = jdbcTemplate.query(sql, mapper);
        return referenceValues.get(0);
    }

    @Override
    public void executeOperationCharacteristics(
            String codeProduct, List<CharacteristicOperationDTO> characteristicDTOS
    ) {
        List<String> insertValues = characteristicDTOS.stream()
                .filter(x -> x.getOperation().equals("add"))
                .map(element -> "(" + Utils.wrapUUID(element.getValue()) + ", " + element.getId() + ", '" + codeProduct + "')")
                .toList();

        if (!insertValues.isEmpty()) {
            String sqlInsert = "insert into characteristic_view values " + String.join(",", insertValues);
            jdbcTemplate.execute(sqlInsert);
        }

        List<String> replaceValues = characteristicDTOS.stream()
                .filter(x -> x.getOperation().equals("replace"))
                .map(element -> "UPDATE characteristic_view " +
                        "SET value = " + Utils.wrapUUID(element.getValue()) +
                        " WHERE id_type_feature = " + element.getId() + " AND id_product = '" + codeProduct + "'")
                .toList();

        if (!replaceValues.isEmpty()) {
            String sqlReplace = String.join("; ", replaceValues);
            jdbcTemplate.execute(sqlReplace);
        }

        List<String> removeValues = characteristicDTOS.stream()
                .filter(x -> x.getOperation().equals("remove"))
                .map(element -> String.valueOf(element.getId()))
                .toList();

        if (!removeValues.isEmpty()) {
            String sqlRemove = "delete from characteristic_view " +
                    "where id_product = '" + codeProduct + "'" + " and id_type_feature in ( " + String.join(", ", removeValues) + ")";
            jdbcTemplate.execute(sqlRemove);
        }
    }

    @Override
    public String getValueReferenceType(String codeReferenceType) {
        String sql = "select value_ref_name as value " +
                "from get_value_reference_type(" + codeReferenceType + ")";
        RowMapper<ReferenceValueForArrayDTO> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(ReferenceValueForArrayDTO.class);
        List<ReferenceValueForArrayDTO> referenceValues = jdbcTemplate.query(sql, mapper);
        return referenceValues.get(0).getValue();
    }
}
