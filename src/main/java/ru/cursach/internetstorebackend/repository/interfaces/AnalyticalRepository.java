package ru.cursach.internetstorebackend.repository.interfaces;

import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticPriceDTO;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticTimeDTO;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticalValueDTO;

import java.util.List;

public interface AnalyticalRepository {
    List<AnalyticalValueDTO> getCountMostFrequentlySelectedCourierCompanies(String dateStart, String dateEnd);
    List<AnalyticPriceDTO> getPricesForProduct(String dateStart, String dateEnd, String codeProduct);
    List<AnalyticalValueDTO> getSalesReportRegions(String dateStart, String dateEnd);
    List<AnalyticTimeDTO> getSupplierPerformanceAnalysis(String dateStart, String dateEnd);
    List<AnalyticalValueDTO> getCountProcessedOrders(String dateStart, String dateEnd);
    List<AnalyticalValueDTO> getTopCategories(String dateStart, String dateEnd);
    List<AnalyticalValueDTO> getTopProducts(String dateStart, String dateEnd);
    List<AnalyticalValueDTO> getRaitingManufacturers();
}
