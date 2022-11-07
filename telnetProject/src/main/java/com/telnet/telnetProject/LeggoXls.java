package com.telnet.telnetProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeggoXls {
	private static Object stringaTotale="";

	public static void main(String[] args) {
        try {
        	String valore = "";
            String file = "c:\\Top Secret\\test.xlsx";
            FileInputStream excelFile = new FileInputStream(new File(file));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator iterator = datatypeSheet.iterator();
            String indirizzoIp="";
            
            ApacheTelnet conn = new ApacheTelnet();
            while (iterator.hasNext()) {
                Row currentRow = (Row) iterator.next();
                
                Iterator cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = (Cell) cellIterator.next();
                    if (currentCell.getCellType() == CellType.STRING) {
                    	if (currentCell.getColumnIndex() == 0) {
                    		indirizzoIp = currentCell.getStringCellValue().replaceAll("\\s+","");
                    		}
                    	if (currentCell.getColumnIndex() != 0) {
                    		conn.eseguiTelnet(indirizzoIp, Integer.parseInt(currentCell.getStringCellValue().replaceAll("\\s+","")));
                    		}
                     } 
                    
                }
                
                           
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
	

}
