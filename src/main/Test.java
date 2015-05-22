package main;


import java.io.File;

import core.Base64UTIL;




public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Base64UTIL base64 = new Base64UTIL();
		
	//	File file = new File("c:/1.png");
		
		
	//	String s = base64.encodeImgageToBase64(file);
	//	System.out.print(s);
        String s = "Vkw5MDEwDQoNCg0KR1o5OS5JTklURA0KDQpzZHNm1tANCi92IDkwMTMsb25saW5lDQoNCtTaZ3o5OcDvw+a1xGNvbnZlcnQNCi9JRCxZDQoNCg0KDQp2aW0gDQoNCmRhdGE6aW1hZ2UvanBnO2Jhc2U2NCw=";
		base64.decodeBase64ToFile(s, "c:/","1.txt");
		
	      
	}
	

	
	
	

}
