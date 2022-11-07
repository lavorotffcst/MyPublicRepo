package oldSource;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class XlsTest {

    private static Object stringaTotale="";

	public static void main(String[] args) {
        try {
        	String valore = "";
            String file = "c:\\Top Secret\\test.xlsx";
            System.out.print(file);
            FileInputStream excelFile = new FileInputStream(new File(file));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator iterator = datatypeSheet.iterator();
            TestTelnet conn = new TestTelnet();
            
            while (iterator.hasNext()) {
                Row currentRow = (Row) iterator.next();
                Iterator cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = (Cell) cellIterator.next();
                    if (currentCell.getCellType() == CellType.STRING) {
                        valore = (currentCell.getStringCellValue());
                        stringaTotale = stringaTotale + valore;
                        
                    } 
                }
                
                int posi = ((String) stringaTotale).indexOf(":");
                String indirizzoIP = (stringaTotale.toString().substring(0,((String) stringaTotale).indexOf(":")));
                int porta = Integer.parseInt(stringaTotale.toString().substring(posi+1,stringaTotale.toString().length()));
                System.out.println();
                conn.eseguiTelnet(indirizzoIP, porta);
                valore = "";
                stringaTotale="";
                
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}