package ru.cursach.internetstorebackend.repository.impl;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductDTO;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductShortDTO;
import ru.cursach.internetstorebackend.domain.dto.request.ProductCreateDTO;
import ru.cursach.internetstorebackend.domain.dto.request.ProductUpdateRequest;
import ru.cursach.internetstorebackend.domain.entity.Product;
import ru.cursach.internetstorebackend.repository.BaseJDBCTemplateRepository;
import ru.cursach.internetstorebackend.repository.interfaces.ProductRepository;

import java.util.List;

@Repository
public class ProductRepositoryImpl extends BaseJDBCTemplateRepository<Product> implements ProductRepository {
    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, Product.class);
    }

    @Override
    public List<ProductShortDTO> getAllProductShortDTOBySubcategory(int idSubcategory, int limit, int offset) {
        String sql = "select code_product, name, description, image, raiting, " +
                "(product_price(code_product, CURRENT_DATE)).price as price" +
                " from product " +
                " where product.id_subcategory = " + idSubcategory +
                " and not product.deleted " +
                " limit " + limit +
                " offset " + offset;


        ResultSetExtractor<List<ProductShortDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(ProductShortDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<ProductDTO> getProductByCodeProduct(String codeProduct) {
        String sql = " select product.code_product, " +
                "       product.name, " +
                "       product.description, " +
                "       product.image, " +
                "       product.model, " +
                "       product.code_manufacturer, " +
                "       product.warranty, " +
                "       product.raiting, " +
                "       country.name as country," +
                "       manufacturer.name as manufacturer," +
                "       dimensions.length as dimensions_length, " +
                "       dimensions.width as dimensions_width, " +
                "       dimensions.height as dimensions_height, " +
                "       dimensions.weight as dimensions_weight " +
                "from product " +
                "         join country on product.id_country = country.id " +
                "         join manufacturer on product.id_manufacturer = manufacturer.id " +
                "        join dimensions on product.id_dimensions = dimensions.id " +
                "where product.code_product = " + "'" + codeProduct + "'";


        ResultSetExtractor<List<ProductDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(ProductDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<ProductCreateDTO> getCreateProductByCodeProduct(String codeProduct) {
        String sql = " select product.code_product, " +
                "       product.id_subcategory, " +
                "       product.name, " +
                "       product.description, " +
                "       product.image, " +
                "       product.model, " +
                "       product.code_manufacturer, " +
                "       product.warranty, " +
                "       product.raiting, " +
                "       product.id_country as idCountry," +
                "       product.id_manufacturer as idManufacturer," +
                "       dimensions.length as dimensions_length, " +
                "       dimensions.width as dimensions_width, " +
                "       dimensions.height as dimensions_height, " +
                "       dimensions.weight as dimensions_weight " +
                "from product " +
                "        join dimensions on product.id_dimensions = dimensions.id " +
                "where product.code_product = " + "'" + codeProduct + "'";


        ResultSetExtractor<List<ProductCreateDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(ProductCreateDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public int deleteProductByCodeProduct(String codeProduct) {
        String sql = "update product " +
                " set deleted = true " +
                " where code_product = " + "'" + codeProduct + "'";
        return jdbcTemplate.update(sql);
    }

    @Override
    public int updateProductByCodeProduct(String codeProduct, ProductUpdateRequest product) {
        String updateProductSql = "update product " +
                " set name              = ?, " +
                "    description       = ?, " +
                "    model             = ?, " +
                "    image             = ?, " +
                "    code_manufacturer = ?, " +
                "    warranty          = ?, " +
                "    raiting           = ?, " +
                "    id_country        = ?, " +
                "    id_manufacturer   = ? " +
                " where code_product = " + "'" + codeProduct + "'";

        String updateDimensionsSql = "update dimensions " +
                "set width = ?, " +
                " height = ?, " +
                " length = ?, " +
                " weight = ? " +
                " where id = (select id_dimensions " +
                "             from product" +
                "             where code_product = ?)";

        jdbcTemplate.update(updateProductSql,
                product.getName(),
                product.getDescription(),
                product.getModel(),
                product.getImage(),
                product.getCode_manufacturer(),
                product.getWarranty(),
                product.getRaiting(),
                product.getIdCountry(),
                product.getIdManufacturer());

        jdbcTemplate.update(updateDimensionsSql,
                product.getDimensions().getWidth(),
                product.getDimensions().getHeight(),
                product.getDimensions().getLength(),
                product.getDimensions().getWeight(),
                product.getCode_product());

        return 1;
    }
}