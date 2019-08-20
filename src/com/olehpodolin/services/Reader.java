package com.olehpodolin.services;

import java.io.*;
import java.util.*;
public class Reader {
	
	public static ArrayList<String> read(String filename) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			FileReader fReader = new FileReader(filename);
			BufferedReader bReader = new BufferedReader(fReader);
			String line;
			while ((line = bReader.readLine()) != null)
				list.add(line);
			fReader.close();
			bReader.close();
		} catch (IOException e) {
			e.printStackTrace();
			//todo add exception handling
		}
		return list;
	}
}
