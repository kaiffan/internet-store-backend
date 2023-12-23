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
    public List<CharacteristicDTO> getAllTypeFeatureWithIDByProductCode(
            String codeProduct
    ) {
        String sql = "select type_feature.id as id," +
                "characteristic.value as value " +
                "from characteristic " +
                "join type_feature on characteristic.id_type_feature = type_feature.id " +
                "where characteristic.id_product = " + "'" + codeProduct + "'";
        ResultSetExtractor<List<CharacteristicDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(CharacteristicDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<ReferenceValueForArrayDTO> getAllReferenceValueByTypeFeature(int typeFeature) {
        String sql = "select reference_value.name_value as value, reference_value.id as id " +
                " from reference_value " +
                "where id_type_feature = " + typeFeature;

        ResultSetExtractor<List<ReferenceValueForArrayDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(ReferenceValueForArrayDTO.class);

        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public ReferenceValueDTO getNameTypeFeature(int typeFeature) {
        String sql = "select type_feature.id as id, " +
                "type_feature.name as name " +
                "from type_feature " +
                "where id = " + typeFeature;
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
            String sqlInsert = "insert into characteristic values " + String.join(",", insertValues);
            jdbcTemplate.execute(sqlInsert);
        }

        List<String> replaceValues = characteristicDTOS.stream()
                .filter(x -> x.getOperation().equals("replace"))
                .map(element -> "UPDATE characteristic " +
                        "SET value = " + Utils.wrapUUID(element.getValue())  +
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
            String sqlRemove = "DELETE FROM characteristic " +
                    "WHERE id_product = '" + codeProduct + "'" + " AND id_type_feature IN ( " + String.join(", ", removeValues) + ")";
            jdbcTemplate.execute(sqlRemove);
        }
    }
}
