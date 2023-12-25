package ru.cursach.internetstorebackend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticPriceDTO;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticTimeDTO;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticalValueDTO;
import ru.cursach.internetstorebackend.repository.interfaces.AnalyticalRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AnalyticalService {

    AnalyticalRepository analyticalRepository;

    public List<AnalyticalValueDTO> getCountMostFrequentlySelectedCourierCompanies(String dateStart, String dateEnd) {
        return analyticalRepository.getCountMostFrequentlySelectedCourierCompanies(dateStart, dateEnd);
    }

    public List<AnalyticPriceDTO> getPricesForProduct(String dateStart, String dateEnd, String codeProduct) {
        return analyticalRepository.getPricesForProduct(dateStart, dateEnd, codeProduct);

    }

    public List<AnalyticalValueDTO> salesReportRegions(String dateStart, String dateEnd) {
        return analyticalRepository.getSalesReportRegions(dateStart, dateEnd);
    }

    public List<AnalyticTimeDTO> getSupplierPerformanceAnalysis(String dateStart, String dateEnd) {
        return analyticalRepository.getSupplierPerformanceAnalysis(dateStart, dateEnd);
    }

    public List<AnalyticalValueDTO> getCountProcessedOrders(String dateStart, String dateEnd) {
        return analyticalRepository.getCountProcessedOrders(dateStart, dateEnd);
    }

    public List<AnalyticalValueDTO> getTopCategories(String dateStart, String dateEnd) {
        return analyticalRepository.getTopCategories(dateStart, dateEnd);
    }

    public List<AnalyticalValueDTO> getTopProducts(String dateStart, String dateEnd) {
        return analyticalRepository.getTopProducts(dateStart, dateEnd);
    }
    public List<AnalyticalValueDTO> getRaitingManufacturers() {
        return analyticalRepository.getRaitingManufacturers();
    }
}
