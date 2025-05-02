package org.example.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ExcelUtils {

    public static  List<LinkedHashMap<String,String>> readDataAsMapfromExcel(String filename) throws IOException {
        List<LinkedHashMap<String,String>> dataFromExcel = new ArrayList<>();
      Workbook workBook = WorkbookFactory.create(new File(filename));
      Sheet sheet =workBook.getSheet("Sheet1");


      int numberOfRows = sheet.getPhysicalNumberOfRows();
      int numberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
        List<String> keys = new ArrayList<>();
        LinkedHashMap<String, String> mapData;
        DataFormatter formatter = new DataFormatter();
        for (int i = 0; i < numberOfRows; i++) {
            mapData=new LinkedHashMap<>();
            if (i == 0) {
                for (int j = 0; j < numberOfColumns; j++) {
                    String data = formatter.formatCellValue(sheet.getRow(0).getCell(j));
                    keys.add(data);
                }
            }
            else{
                for (int j = 0; j < numberOfColumns; j++) {
                    String data = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                    mapData.put(keys.get(j),data);
                }
                dataFromExcel.add(mapData);
            }
        }


        return dataFromExcel;
    }
}
