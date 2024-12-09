package com.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class XXLoginDataProvider {
	
	@DataProvider(name="allLoginTestData")
	public String[][] getAllData()throws IOException{
		ExcelUtility util = new ExcelUtility(System.getProperty("user.dir")+"/testdata/userdata.xlsx");

			int rowCount = util.getRowCount("Sheet 1");
			int cellCount = util.getCellCount("Sheet 1", 1);

		String [][] allLoginData = new String[rowCount-1][cellCount];
		for (int i=0;i<rowCount; i++) {
			for(int j=0; j<cellCount; j++) {
				try {
					allLoginData[i][j] = util.getCellData("Sheet 1", i+1, j);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return allLoginData;
		
		
	}

}
