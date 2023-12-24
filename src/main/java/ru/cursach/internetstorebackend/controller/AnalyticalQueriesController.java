package ru.cursach.internetstorebackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.cursach.internetstorebackend.constants.RequestConstant;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticPriceDTO;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticTimeDTO;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticUuidDTO;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticalDTO;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticalValueDTO;
import ru.cursach.internetstorebackend.services.AnalyticalService;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(RequestConstant.analyticalQueries)
public class AnalyticalQueriesController {

    AnalyticalService analyticalService;

    @GetMapping("/courier_company")
    public List<AnalyticalValueDTO> getCountMostFrequentlySelectedCourierCompanies(
            @RequestParam String dateStart,
            @RequestParam String dateEnd
            ) {
        return analyticalService.getCountMostFrequentlySelectedCourierCompanies(dateStart, dateEnd);
    }

    @GetMapping("/prices_product")
    public List<AnalyticPriceDTO> getPricesForProduct(
            @RequestParam String dateStart,
            @RequestParam String dateEnd,
            @RequestParam String codeProduct
    ) {
        return analyticalService.getPricesForProduct(dateStart, dateEnd, codeProduct);
    }

    @GetMapping("/sales_report_regions")
    public List<AnalyticalValueDTO> salesReportRegions(
            @RequestParam String dateStart,
            @RequestParam String dateEnd
    ) {
        return analyticalService.salesReportRegions(dateStart, dateEnd);
    }

    @GetMapping("/supplier_performance_analysis")
    public List<AnalyticTimeDTO> getSupplierPerformanceAnalysis(
    ) {
        return analyticalService.getSupplierPerformanceAnalysis();
    }

    @GetMapping("/count_processed_orders")
    public List<AnalyticUuidDTO> getCountProcessedOrders(
            @RequestParam String dateStart,
            @RequestParam String dateEnd
    ) {
        return analyticalService.getCountProcessedOrders(dateStart, dateEnd);
    }
}
