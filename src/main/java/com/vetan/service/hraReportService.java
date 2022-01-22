package com.vetan.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vetan.data.hra;
import com.vetan.repository.ReportRepository;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service

public class hraReportService {

	@Autowired
	private ReportRepository reportRepository;

	public String generateReport() {
		try {

			List<hra> hra = reportRepository.findAll();

			String reportPath = "E:\\hra";

			// Compile the Jasper report from .jrxml to .japser
			JasperReport jasperReport = JasperCompileManager
					.compileReport(reportPath + "\\hra-rpt-database.jrxml");

			// Get your data source
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(hra);

			// Add parameters
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("createdBy", "vetan.org");

			// Fill the report
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
					jrBeanCollectionDataSource);

			// Export the report to a PDF file
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\hra-Rpt-Database.pdf");

			System.out.println("Done");

			return "Report successfully generated @path= " + reportPath;
		} catch (Exception e) {
			e.printStackTrace();
			return "Error--> check the console log";
		}
	}
}