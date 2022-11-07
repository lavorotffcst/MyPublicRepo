package com.telnet.telnetProject;

import java.io.IOException;

import org.apache.commons.net.telnet.TelnetClient;

public class ApacheTelnet {

	public static void eseguiTelnet(String ip,int port) {
		TelnetClient client = null;
		  try{
			client = new TelnetClient();
		    client.setConnectTimeout(10000);
		    client.connect(ip,port);
		    if (client.isConnected()==true){
		    	System.out.println("Connected to  Ip : " + ip + " " + port);
		    }
		  } catch (Exception e){
		    System.out.println(e.getMessage() + " - Not connected to Ip :" + ip +" and Port : " + port);
		  } finally {
		    try {
		      
		    	client.disconnect();
		      
		    } catch (Exception ignore){
		    }
		  }
}
}
