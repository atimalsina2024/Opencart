package com.testCases;


import java.io.IOException;

import com.utilities.LoginDataProviderCsv;


public class TestSyntax {

	public static void main(String args[]) throws IOException {
		//String path = "/Users/anantatimalsina/eclipse-workspace/Opencart/testdata/UserData.csv";		
		LoginDataProviderCsv dp = new LoginDataProviderCsv();
		String [][] data = dp.readAllData();
		for(String []row : data) {
			for(String value: row) {
				System.out.print(value);
			}
			System.out.println();
		}
		System.out.println(data.getClass().isArray());
	}
}
