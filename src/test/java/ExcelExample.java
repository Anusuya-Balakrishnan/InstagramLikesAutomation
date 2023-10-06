import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class ExcelExample {
    public static void main(String[] args) {
//        Map<String, InstagramPerson> dataMap = new HashMap<>();
//        InstagramPerson person1=new InstagramPerson("Siva","www.instragram.com/siva",false);
//        InstagramPerson person2=new InstagramPerson("abirami","www.instragram.com/abirami",false);
//        InstagramPerson person3=new InstagramPerson("arthi","www.instragram.com/arthi",false);
//        dataMap.put("Person1", person1);
//        dataMap.put("Person2", person2);
//        dataMap.put("Person3", person3);

        try (FileInputStream fileInputStream = new FileInputStream("data.xlsx");
                Workbook workbook = new XSSFWorkbook(fileInputStream)) {

               // Specify the sheet name where your map data is located
               Sheet sheet = workbook.getSheet("Data");

               // Create a map to store the read data
               Map<String, InstagramPerson> dataMap = new HashMap<>();

               Iterator<Row> rowIterator = sheet.iterator();
               while (rowIterator.hasNext()) {
                   Row row = rowIterator.next();
                   Cell keyCell = row.getCell(0);
                   Cell valueCell1 = row.getCell(1);
                   Cell valueCell2 = row.getCell(2);
                   Cell valueCell3 = row.getCell(3);

                   if (keyCell != null && valueCell1 != null) {
                       String key = keyCell.getStringCellValue();
                       String personName = valueCell1.getStringCellValue();
                       String personUrl = valueCell2.getStringCellValue();
                       boolean response=valueCell3.getBooleanCellValue();
                       InstagramPerson instPerson=new InstagramPerson(personName, personUrl, response);
                       dataMap.put(key, instPerson);
                   }
               }

               // Print the read data
               for (Map.Entry<String, InstagramPerson> entry : dataMap.entrySet()) {
                   System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Specify the existing file you want to append data to
//        String existingFilePath = "data.xlsx";
//
//        try (FileInputStream existingFileInputStream = new FileInputStream(existingFilePath);
//             Workbook existingWorkbook = new XSSFWorkbook(existingFileInputStream)) {
//
//            Sheet sheet = existingWorkbook.getSheet("Data");
//
//            // Calculate the next available row
//            int rowNum = sheet.getLastRowNum() + 1;
//
//            // Add the new data to the existing sheet
//            for (Map.Entry<String, InstagramPerson> entry : dataMap.entrySet()) {
//                Row row = sheet.createRow(rowNum++);
//                Cell cell1 = row.createCell(0);
//                cell1.setCellValue(entry.getKey());
//
//                Cell cell2 = row.createCell(1);
//                cell2.setCellValue(entry.getValue().personName);
//                Cell cell3 = row.createCell(2);
//                cell3.setCellValue(entry.getValue().personUrl);
//                Cell cell4 = row.createCell(3);
//                cell4.setCellValue(entry.getValue().response);
//            }
//
////            try (FileOutputStream outputStream = new FileOutputStream(existingFilePath)) {
////                existingWorkbook.write(outputStream);
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
