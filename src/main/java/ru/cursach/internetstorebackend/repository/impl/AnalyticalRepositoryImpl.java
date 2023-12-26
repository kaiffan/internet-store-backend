package ru.cursach.internetstorebackend.repository.impl;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticPriceDTO;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticTimeDTO;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticalValueDTO;
import ru.cursach.internetstorebackend.domain.entity.Product;
import ru.cursach.internetstorebackend.repository.BaseJDBCTemplateRepository;
import ru.cursach.internetstorebackend.repository.interfaces.AnalyticalRepository;
import ru.cursach.internetstorebackend.utils.Utils;

import java.util.List;

@Repository
public class AnalyticalRepositoryImpl extends BaseJDBCTemplateRepository<Product> implements AnalyticalRepository {
    public AnalyticalRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, Product.class);
    }

    @Override
    public List<AnalyticalValueDTO> getCountMostFrequentlySelectedCourierCompanies(String dateStart, String dateEnd) {
        String sql = "select courier_company_name as name, count_courier_company as value" +
                " from get_count_most_frequently_selected_courier_companies('"
                + dateStart + "', '" + dateEnd + "'" + ")";

        ResultSetExtractor<List<AnalyticalValueDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(AnalyticalValueDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<AnalyticPriceDTO> getPricesForProduct(String dateStart, String dateEnd, String codeProduct) {
        String sql = "select round(price_value) as value, date_price as datePrice" +
                " from get_price_for_product_analit('"
                + dateStart + "', '" + dateEnd + "', " + Utils.wrapUUID(codeProduct) + ");";

        ResultSetExtractor<List<AnalyticPriceDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(AnalyticPriceDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<AnalyticalValueDTO> getSalesReportRegions(String dateStart, String dateEnd) {
        String sql = "select region_name as name, count_sale as value" +
                " from sales_report_regions('"
                + dateStart + "', '" + dateEnd + "')";

        ResultSetExtractor<List<AnalyticalValueDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(AnalyticalValueDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    public List<AnalyticalValueDTO> getSupplierPerformanceAnalysis(String dateStart, String dateEnd) {
        String sql = "select supplier_name as name, round(time_shipment) as value " +
                "from supplier_performance_analysis('" + dateStart + "', '" + dateEnd + "')";

        ResultSetExtractor<List<AnalyticalValueDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(AnalyticalValueDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<AnalyticalValueDTO> getCountProcessedOrders(String dateStart, String dateEnd) {
        String sql = "select address_warehouse as name, count_processed_orders as value " +
                "from get_count_processed_orders('" + dateStart + "', '" + dateEnd + "')";

        ResultSetExtractor<List<AnalyticalValueDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(AnalyticalValueDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<AnalyticalValueDTO> getTopCategories(String dateStart, String dateEnd) {
        String sql = "select subcategory_title as name, count_in_orders as value from get_top_category_by_period('" + dateStart + "', '" + dateEnd + "')";

        ResultSetExtractor<List<AnalyticalValueDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(AnalyticalValueDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<AnalyticalValueDTO> getTopProducts(String dateStart, String dateEnd) {
        String sql = "select product_title as name, quantity_in_orders as value from get_top_products_by_period('" + dateStart + "', '" + dateEnd + "')";

        ResultSetExtractor<List<AnalyticalValueDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(AnalyticalValueDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<AnalyticalValueDTO> getRaitingManufacturers() {
        String sql = "select manufacturer_name as name, avg_rating as value from get_rating_manufacturers()";

        ResultSetExtractor<List<AnalyticalValueDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(AnalyticalValueDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<AnalyticalValueDTO> getTurnoverCoefficientOfProducts(String dateStart, String dateEnd) {
        String sql = "select product_name as name, turnover_coefficient as value " +
                "from get_turnover_coefficient_of_products('" + dateStart + "', '" + dateEnd + "')";

        ResultSetExtractor<List<AnalyticalValueDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(AnalyticalValueDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<AnalyticalValueDTO> warehousePerformanceAnalysis(String dateStart, String dateEnd) {
        String sql = "select warehouse_address as name, time_processing as value " +
                "from warehouse_performance_analysis('" + dateStart + "', '" + dateEnd + "')";

        ResultSetExtractor<List<AnalyticalValueDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(AnalyticalValueDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }
}
