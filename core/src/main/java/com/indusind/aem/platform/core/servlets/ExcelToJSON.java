package com.indusind.aem.platform.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Component(
        service = {Servlet.class},
        property = {
                "sling.servlet.paths=/bin/exportexcelfortext",
                "sling.servlet.extensions=json",
                "sling.servlet.methods=GET"
        }
)
public class ExcelToJSON extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(ExcelToJSON.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        String excelFilePath = "/content/dam/Indusind/example.xlsx/jcr:content/renditions/original/jcr:content";
        Resource fileResource = request.getResourceResolver().getResource(excelFilePath);

        if (fileResource != null) {
            try {
                ValueMap properties = fileResource.adaptTo(ValueMap.class);
                InputStream inputStream = properties.get("jcr:data", InputStream.class);
                if (inputStream != null) {
                    Workbook workbook = new XSSFWorkbook(inputStream);
                    Map<String, List<Map<String, String>>> workbookData = new LinkedHashMap<>();

                    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                        Sheet sheet = workbook.getSheetAt(i);
                        List<Map<String, String>> sheetData = new ArrayList<>();
                        Row headerRow = sheet.getRow(0);
                        if (headerRow == null) {
                            continue;
                        }
                        for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                            Row row = sheet.getRow(j);
                            Map<String, String> rowData = new LinkedHashMap<>();
                            for (Cell cell : row) {
                                int columnIndex = cell.getColumnIndex();
                                Cell headerCell = headerRow.getCell(columnIndex);
                                if (headerCell == null) {
                                    continue;
                                }
                                String header = headerCell.getStringCellValue();
                                String cellValue = getCellValue(cell);
                                rowData.put(header, cellValue);
                            }
                            sheetData.add(rowData);
                        }
                        workbookData.put(sheet.getSheetName(), sheetData);
                    }

                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(workbookData);

                    response.setContentType("application/json");
                    response.getWriter().write(json);
                } else {
                    response.getWriter().println("jcr:data property is not present or is null.");
                }
            } catch (Exception e) {
                log.error("Error reading file.", e);
                response.getWriter().println("Error reading file: " + e.getMessage());
            }
        }
    }

    private String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return Double.toString(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}
