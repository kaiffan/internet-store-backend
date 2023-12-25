package ru.cursach.internetstorebackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.cursach.internetstorebackend.constants.RequestConstant;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticPriceDTO;
import ru.cursach.internetstorebackend.domain.dto.analytical.AnalyticTimeDTO;
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
            @RequestParam String dateStart,
            @RequestParam String dateEnd
    ) {
        return analyticalService.getSupplierPerformanceAnalysis(dateStart, dateEnd);
    }

    @GetMapping("/count_processed_orders")
    public List<AnalyticalValueDTO> getCountProcessedOrders(
            @RequestParam String dateStart,
            @RequestParam String dateEnd
    ) {
        return analyticalService.getCountProcessedOrders(dateStart, dateEnd);
    }

    @GetMapping("/top_categories")
    public List<AnalyticalValueDTO> getTopCategories(
            @RequestParam String dateStart,
            @RequestParam String dateEnd
    ) {
        return analyticalService.getTopCategories(dateStart, dateEnd);
    }

    @GetMapping("/top_products")
    public List<AnalyticalValueDTO> getTopProducts(
            @RequestParam String dateStart,
            @RequestParam String dateEnd
    ) {
        return analyticalService.getTopProducts(dateStart, dateEnd);
    }

    @GetMapping("/raiting_manufacturers")
    public List<AnalyticalValueDTO> getRaitingManufacturers(
    ) {
        return analyticalService.getRaitingManufacturers();
    }

    @GetMapping("/turnover_coef_products")
    public List<AnalyticalValueDTO> getTurnoverCoefficientOfProducts(
            @RequestParam String dateStart,
            @RequestParam String dateEnd
    ) {
        return analyticalService.getTurnoverCoefficientOfProducts(dateStart, dateEnd);
    }

    @GetMapping("/warehouse_performance_analysis")
    public List<AnalyticalValueDTO> warehousePerformanceAnalysis(
            @RequestParam String dateStart,
            @RequestParam String dateEnd
    ) {
        return analyticalService.warehousePerformanceAnalysis(dateStart, dateEnd);
    }
}
