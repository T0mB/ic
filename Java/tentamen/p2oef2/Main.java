package p2oef2;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args) throws IOException{
		
		FileReader fr = new FileReader("C:/Users/Tom/workspace/Java/tentamen/p2oef2/rekeningen.txt");
		BufferedReader br = new BufferedReader(fr);
		Rekening r = new Rekening(0);
		ArrayList <Rekening> lijst = new ArrayList <Rekening>();
		int rek = 0;
		double saldo = 0.0;
		
		while(true){
			String regel = br.readLine();
			
			
			if(regel == null){
				break;
			}
			
			if(!regel.contains(".")){
				
				r = new Rekening(Integer.parseInt(regel));
				lijst.add(r);
				System.out.println(regel);
				
			}
			else{
				r.setSaldo(Double.parseDouble(regel));
				System.out.println(regel);
			}
			
			
					
			
		}
		br.close();
	}
}
