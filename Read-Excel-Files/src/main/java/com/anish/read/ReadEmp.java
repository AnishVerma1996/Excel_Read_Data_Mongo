package com.anish.read;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anish.entity.Employee;
import com.anish.repository.EmpRepository;




public class ReadEmp 
{
	
    public static final String SAMPLE_XLS_FILE_PATH = "E://Excel/anish.xls";
    public static final String SAMPLE_XLSX_FILE_PATH = "E://Excel/anish.xlsx";

    public  List<Employee> getDataFromExcel() throws IOException, EncryptedDocumentException, InvalidFormatException   {

       
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
        
        
        Sheet sheet = workbook.getSheetAt(0);
       

      
       
       

        
        DataFormatter dataFormatter = new DataFormatter();
        
        List<Employee> listemp=new ArrayList<>();

        
        Iterator<Row> rowIterator = sheet.rowIterator();
        
        
        int p=0;
        
                
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
           
           

            p++;
            if(p>1)
            {
            Employee emp=new Employee();
           
           emp.setId(Integer.parseInt(dataFormatter.formatCellValue(row.getCell(0))));
           emp.setEname(dataFormatter.formatCellValue(row.getCell(1)));
           emp.setSal(Double.parseDouble(dataFormatter.formatCellValue(row.getCell(2))));

           listemp.add(emp);
            }
            
        }

        workbook.close();
        return listemp;
    }

   
    
}
