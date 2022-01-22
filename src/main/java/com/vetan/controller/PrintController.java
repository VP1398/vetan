package com.vetan.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@RestController   
@RequestMapping("/print")
public class PrintController {

	@Autowired
	private Environment environment;

	@RequestMapping(path = "/Export", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> download(@RequestParam String ReportName, @RequestParam String Format, @RequestParam String VURL, @RequestParam String VJRXML,
			HttpServletResponse response) throws IOException {
     String myURL = environment.getProperty("JSON.URL")+VURL;
  //   System.out.println("url"+myURL);
		 String rawJsonData = getJSON(myURL,15000);
	//	  System.out.println("VJRXML"+VJRXML);

		try {
			

		InputStream jrxmlInputStream = getClass().getResourceAsStream(VJRXML);

		//InputStream jrxmlInputStream = getClass().getResourceAsStream("/static/jrxml/_E.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInputStream);
			JRSaver.saveObject(jasperReport, "FinalReport.jasper");
			JasperReport report = (JasperReport) JRLoader.loadObject(new File("FinalReport.jasper"));
			ByteArrayInputStream jsonDataStream = new ByteArrayInputStream(rawJsonData.getBytes());
			JsonDataSource ds = new JsonDataSource(jsonDataStream);
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ReportTitle", "Jasper PDF Example");
		//	parameters.put("vetanlogo", ClassLoader.getSystemResource("http://localhost:8080/vetan/images/vetan.jpg").getPath());

			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);

			if (Format.equalsIgnoreCase("PDF")) {

				JRPdfExporter exporter = new JRPdfExporter();
				exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
				SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
				reportConfig.setSizePageToContent(true);
				reportConfig.setForceLineBreakPolicy(false);
				exporter.setConfiguration(reportConfig);
				response.setHeader("Set-Cookie", "key=value; HttpOnly; SameSite=none");
				response.setHeader("Content-Disposition", "attachment;filename=" + ReportName + ".pdf");
				response.setContentType("application/octet-stream");
				exporter.exportReport();

			} else if (Format.equalsIgnoreCase("Excel")) {

				JRXlsxExporter exporter = new JRXlsxExporter();
				SimpleXlsxReportConfiguration reportConfig = new SimpleXlsxReportConfiguration();
				reportConfig.setSheetNames(new String[] { ReportName });
				exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				exporter.setConfiguration(reportConfig);
				OutputStream outStream = null;
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
				response.setHeader("Set-Cookie", "key=value; HttpOnly; SameSite=none");

				response.setHeader("Content-Disposition", "attachment;filename=" + ReportName + ".xlsx");
				response.setContentType("application/octet-stream");
				exporter.exportReport();

			}

		} catch (JRException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return null;

	}

	public String getJSON(String url, int timeout) {
		HttpURLConnection c = null;
		try {
			URL u = new URL(url);

			c = (HttpURLConnection) u.openConnection();
			c.setRequestMethod("POST");
			c.setRequestProperty("Content-length", "0");
			c.setUseCaches(false);
			c.setAllowUserInteraction(false);
			c.setConnectTimeout(timeout);
			c.setReadTimeout(timeout);
			c.connect();


			int status = c.getResponseCode();
			switch (status) {
			case 200:
			case 201:
				BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}
				br.close();
				return sb.toString();
			}

		} catch (MalformedURLException ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (c != null) {
				try {
					c.disconnect();
				} catch (Exception ex) {
					Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		return null;
	}
}