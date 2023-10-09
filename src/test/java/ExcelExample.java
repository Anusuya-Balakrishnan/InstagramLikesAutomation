import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class ExcelExample {
	
	
	
	public ArrayList<InstagramPerson> readData() {
		ArrayList<InstagramPerson> existingPerson=new ArrayList<>();
		try (FileInputStream fileInputStream = new FileInputStream("data.xlsx");
                Workbook workbook = new XSSFWorkbook(fileInputStream)) {

               // Specify the sheet name where your map data is located
               Sheet sheet = workbook.getSheet("Data");
               
               Iterator<Row> rowIterator = sheet.iterator();
               while (rowIterator.hasNext()) {
                   Row row = rowIterator.next();
                   Cell keyCell = row.getCell(0);//postName
                   Cell valueCell1 = row.getCell(1);//personName
                   Cell valueCell2 = row.getCell(2);//personURl
                   Cell valueCell3 = row.getCell(3);//response

                   if (keyCell != null && valueCell1 != null) {
                       String postName = keyCell.getStringCellValue();//postName
                       String personName = valueCell1.getStringCellValue();//personName
                       String personUrl = valueCell2.getStringCellValue();//personName
                       boolean response=valueCell3.getBooleanCellValue();//response
                       existingPerson.add(new InstagramPerson(postName,personName, personUrl, response));
                   }
               }

               // Print the read data
      
//               for(InstagramPerson eachPerson:existingPerson) {
//            	   System.out.println(eachPerson);
//               }
           } catch (IOException e) {
               e.printStackTrace();
           }

		return existingPerson;
	}
	
	public  void writeData(ArrayList<InstagramPerson> personList) {
		// Specify the existing file you want to append data to
        String existingFilePath = "data.xlsx";
//
        try (FileInputStream existingFileInputStream = new FileInputStream(existingFilePath);
             Workbook existingWorkbook = new XSSFWorkbook(existingFileInputStream)) {

            Sheet sheet = existingWorkbook.getSheet("Data");

            // Calculate the next available row
            int rowNum = sheet.getLastRowNum() + 1;

            
            // Add the new data to the existing sheet
            for (InstagramPerson eachPerson:personList) {
                Row row = sheet.createRow(rowNum++);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(eachPerson.postName);

                Cell cell2 = row.createCell(1);
                cell2.setCellValue(eachPerson.personName);
                Cell cell3 = row.createCell(2);
                cell3.setCellValue(eachPerson.personUrl);
                Cell cell4 = row.createCell(3);
                cell4.setCellValue(eachPerson.response);
            }

            try (FileOutputStream outputStream = new FileOutputStream(existingFilePath)) {
                existingWorkbook.write(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
   
}
