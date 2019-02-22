package com.generate.kafka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Generatedata {

	public static void generatedata(String filepath) throws IOException, InterruptedException
	{
		KafkaDemoProducer kd=new KafkaDemoProducer();
		Random r = new Random();
		FileReader fr=new FileReader(filepath);
		//File file = new File(Generatedata.class.getResource("/device_lookup").getFile());
		//FileReader fr=new FileReader(file);
		BufferedReader dr=new BufferedReader(fr);
		
		String line_content="";
		String[] deviceid = new String[10];
		String[] devicename =  new String[10];
		int i=0;
		while((line_content=dr.readLine())!=null)
		{
			String[] line_array=line_content.split(",");
			deviceid[i]=line_array[0];
			devicename[i]=line_array[1];
			i++;
		}
		dr.close();
		//String[] outputarr=new String[10];
		
		//Integer.MAX_VALUE
		int index=0;
		while(true)
		{
			if(index==9)
				index=0;
			index++;
			
			String deviceidadd=deviceid[index];
			String devicenameadd=devicename[index];
			long currenttime=System.currentTimeMillis();
			int devicevalue=r.nextInt(999);
			StringBuilder str=new StringBuilder();
			str.append(deviceidadd);
			str.append(",");
			str.append(devicenameadd);
			str.append(",");
			str.append(currenttime);
			str.append(",");
			str.append(devicevalue);
			str.append("\n");
			String kafka_data=str.toString();
			kd.pushtokafka(kafka_data,"nifitest");
			Thread.sleep(10000);
		}
		
		
	}
	public static void main(String args[]) throws IOException, InterruptedException
	{
		String filepath=args[0];
		generatedata(filepath);
	}
	
}
