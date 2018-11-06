package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Test {
	public static void main(String[] args) throws IOException {
		File f = new File("D:\\data1.txt");
		String line;
		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		PrintWriter pw = new PrintWriter("d:\\data3.txt");
		while((line = bf.readLine())!=null) {
			String[] split = line.split(":");
			if(split[0].equals("Door")) {
				line = "Door:Cua cai";
				pw.write(line + "\r\n");
			}
			else {
			pw.write(line+ "\r\n");
			}
		}
		pw.close();
		bf.close();
		
		
	}
}
