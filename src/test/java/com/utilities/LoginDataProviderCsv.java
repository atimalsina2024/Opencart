package com.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class LoginDataProviderCsv {

	@DataProvider(name="LoginTestAllDataArray")
	public String [][] readAllData(){
		String path = System.getProperty("user.dir") + "/testdata/UserData.csv";
		List<String []> rows = new ArrayList<>();
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				rows.add(values);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String [][] dataArray = new String[rows.size()-1][];
		for(int i=0; i<rows.size()-1; i++) {
			dataArray[i] = rows.get(i+1);
		}
		return dataArray;
	}
	

}
