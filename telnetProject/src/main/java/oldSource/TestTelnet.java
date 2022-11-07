package oldSource;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


class TestTelnet extends TimerTask
{
	static final Logger logger = Logger.getLogger(App.class);
    public static void eseguiTelnet(String indirizzo,int porta)
    {
    	
        try
        {
       	
        	System.out.println("Connessione con "+indirizzo+" e porta "+porta);
            TimerTask con  = new TestTelnet();
            //Scanner sc1=new Scanner(System.in);
            int port=porta;
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(con,1,1000);
            Socket s1=new Socket(indirizzo,port);
            InputStream is=s1.getInputStream();
            DataInputStream dis=new DataInputStream(is);
            if(dis!=null)
            {
                System.out.println("Connected with ip "+ indirizzo + " and port " + porta);
                logger.info("Connected with ip"+ indirizzo +  " and port:" + porta);
            }
            else
            {
                System.out.println("Connection invalid");
                logger.error("Invalid Connection with ip:  " + indirizzo + " port : " + porta );
            }
            con.cancel(); 
            dis.close();
            s1.close();
             
        }
        catch(Exception e)
        {
            System.out.println("Not Connected,Please enter proper input");
            logger.error("Not Connected with ip : " + indirizzo + " Port : " + porta + " ,Please enter proper input");
        }
         
    }
 
    @Override
    public void run() {
        // TODO Auto-generated method stub
         
    }
}