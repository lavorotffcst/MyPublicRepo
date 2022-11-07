package com.telnet.telnetProject;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.TimerTask;

import org.apache.log4j.Logger;


import oldSource.App;


class TestTelnetNew extends TimerTask
{
	static final Logger logger = Logger.getLogger(App.class);
    public static void eseguiTelnet(String indirizzo)
    {
    	String porta = null;
        try
        {
       	    //Test caaaa
        	System.out.println("Connessione con : "+ indirizzo);
        	int posi = ((String) indirizzo).indexOf(":") + 1;
        	porta = indirizzo.substring(posi,indirizzo.length()); // 
            TimerTask con  = new TestTelnetNew();
            int port = Integer.parseInt(porta);
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(con,1,1000);
            indirizzo = indirizzo.substring(0,posi-1);
            Socket s1=new Socket(indirizzo,port);
            InputStream is=s1.getInputStream();
            DataInputStream dis=new DataInputStream(is);
            if(dis!=null)
            {
                System.out.println("Connected with ip "+ indirizzo + " and port " + porta);
                logger.info("Connected with ip : "+ indirizzo +  " and port : " + porta);
            }
            else
            {
                System.out.println("Connection invalid");
                logger.error("Invalid Connection with ip :  " + indirizzo + " port : " + porta );
            }
            con.cancel(); 
            dis.close();
            s1.close();
             
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.error("Ip : " + indirizzo + " Port : " + porta + " - " + e.getMessage());
        }
        
    }
 
    @Override
    public void run() {
        // TODO Auto-generated method stub
         
    }
}