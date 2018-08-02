package tsxy.bsjz.platform.utils;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import tsxy.bsjz.platform.model.Medicine;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 姜哲 on 2018/4/12--20:41
 */
public class PoiUtils {

    public static ResponseEntity<byte[]> exportMedicine2Excel(List<Medicine> medicineList) {
        HttpHeaders headers = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建Excel文档
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.创建文档摘要
            workbook.createInformationProperties();
            //3.获取文档信息，并配置
            DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
            //3.1文档类别
            dsi.setCategory("药品信息");
            //3.2设置文档管理员
            dsi.setManager("姜哲");
            //3.3设置组织机构
            dsi.setCompany("姜哲");
            //4.获取摘要信息并配置
            SummaryInformation si = workbook.getSummaryInformation();
            //4.1设置文档主题
            si.setSubject("药品信息表");
            //4.2.设置文档标题
            si.setTitle("药品信息");
            //4.3 设置文档作者
            si.setAuthor("姜哲");
            //4.4设置文档备注
            si.setComments("备注信息暂无");
            //创建Excel表单
            HSSFSheet sheet = workbook.createSheet("药品信息表");
            //创建日期显示格式
            HSSFCellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
            //创建标题的显示样式
            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //定义列的宽度
            sheet.setColumnWidth(0, 5 * 256);//id
            sheet.setColumnWidth(1, 20 * 256);//name
            sheet.setColumnWidth(2, 10 * 256);//salePrice
            sheet.setColumnWidth(3, 10 * 256);//inventory
            sheet.setColumnWidth(4, 10 * 256);//inventoryWarn
            sheet.setColumnWidth(5, 20 * 256);//remark
            sheet.setColumnWidth(6, 20 * 256);//description
            sheet.setColumnWidth(7, 15 * 256);//classifyId---medicineClassify 以下三为一对一 取name
            sheet.setColumnWidth(8, 15 * 256);//unitId----medicineUnit
            sheet.setColumnWidth(9, 15 * 256);//factoryId----medicineFactory
            //5.设置表头
            HSSFRow headerRow = sheet.createRow(0);
            HSSFCell cell0 = headerRow.createCell(0);
            cell0.setCellValue("编号");
            cell0.setCellStyle(headerStyle);
            HSSFCell cell1 = headerRow.createCell(1);
            cell1.setCellValue("药品名称");
            cell1.setCellStyle(headerStyle);
            HSSFCell cell2 = headerRow.createCell(2);
            cell2.setCellValue("药品单价");
            cell2.setCellStyle(headerStyle);
            HSSFCell cell3 = headerRow.createCell(3);
            cell3.setCellValue("库存");
            cell3.setCellStyle(headerStyle);
            HSSFCell cell4 = headerRow.createCell(4);
            cell4.setCellValue("预警库存");
            cell4.setCellStyle(headerStyle);
            HSSFCell cell5 = headerRow.createCell(5);
            cell5.setCellValue("药品摘要");
            cell5.setCellStyle(headerStyle);
            HSSFCell cell6 = headerRow.createCell(6);
            cell6.setCellValue("药品描述");
            cell6.setCellStyle(headerStyle);
            HSSFCell cell7 = headerRow.createCell(7);
            cell7.setCellValue("分类名称");
            cell7.setCellStyle(headerStyle);
            HSSFCell cell8 = headerRow.createCell(8);
            cell8.setCellValue("单位名称");
            cell8.setCellStyle(headerStyle);
            HSSFCell cell9 = headerRow.createCell(9);
            cell9.setCellValue("厂家名称");
            cell9.setCellStyle(headerStyle);
            //6.装数据
            for (int i = 0; i < medicineList.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                Medicine medicine = medicineList.get(i);
                row.createCell(0).setCellValue(medicine.getId());//编号
                row.createCell(1).setCellValue(medicine.getName());//药品名称
                row.createCell(2).setCellValue(String.valueOf(medicine.getSalePrice()));//药品单价
                row.createCell(3).setCellValue(medicine.getInventory());//库存
                row.createCell(4).setCellValue(medicine.getInventoryWarn());//预警库存
                row.createCell(5).setCellValue(medicine.getRemark());//药品摘要
                row.createCell(6).setCellValue(medicine.getDescription());//药品描述
                row.createCell(7).setCellValue(medicine.getMedicineClassify().getName());//分类名称
                row.createCell(8).setCellValue(medicine.getMedicineUnit().getName());//单位名称
                row.createCell(9).setCellValue(medicine.getMedicineFactory().getName());//厂家名称
            }
            headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", new String("药品表.xls".getBytes("UTF-8"), "iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            baos = new ByteArrayOutputStream();
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    public static List<Medicine> importMedicine2List(MultipartFile file) {
        List<Medicine> medicineList = new ArrayList<>();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                Medicine medicine;
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue;//标题行
                    }
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//没数据
                    }
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    medicine = new Medicine();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellTypeEnum()) {
                            case STRING: {
                                String cellValue = cell.getStringCellValue();
                                if (cellValue == null) {
                                    cellValue = "";
                                }
                                switch (k) {
                                    case 0:
                                        medicine.setName(cellValue);
                                        break;
                                    case 4:
                                        medicine.setRemark(cellValue);
                                        break;
                                    case 5:
                                        medicine.setDescription(cellValue);
                                        break;
                                }
                            }
                            break;
                            case NUMERIC: {
                                switch (k) {
                                    case 1:
                                        medicine.setSalePrice(new BigDecimal(cell.getNumericCellValue()));
                                        break;
                                    case 2:
                                        medicine.setInventory((int) cell.getNumericCellValue());
                                        break;
                                    case 3:
                                        medicine.setInventoryWarn((int) cell.getNumericCellValue());
                                        break;
                                    case 6:
                                        medicine.setClassifyId((int) cell.getNumericCellValue());
                                        break;
                                    case 7:
                                        medicine.setUnitId((int) cell.getNumericCellValue());
                                        break;
                                    case 8:
                                        medicine.setFactoryId((int) cell.getNumericCellValue());
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    medicineList.add(medicine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return medicineList;
    }
}
