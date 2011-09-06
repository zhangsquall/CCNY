package com.android.ccny.www.conf;


//***********************************************************************
//* [CCNY]
//* This application was developed by 
//* [Qingjie Zhao][E-mail:zhaoqingjie@gmail.com]
//* [Christopher Sansone][E-mail:chrissansone@hotmail.com]
//* [Casey Trumble][cE-mail:atrumbl@syr.edu]
//* [Jimmy Bell][E-mail:jnbelliv@syr.edu]
//* [SooHyun Jeong][E-mail:sojeon@syr.edu]
//* for New York's Creative Core
//* as part of the final project for the Mobile Application Development
//* course IST 400/600 - Fall 2010 at the school of information Studies
//* of Syracuse University
//***********************************************************************

public class Config {

	public static String get_URL() {
		final String URL = "http://149.119.211.98:8080/ccny/services/DBService?wsdl";
		// final String URL =
		// "http://mobileappcourse.syr.edu:8080/ccny/services/DBService?wsdl";
		return URL;
	}

	/**
	 * @return
	 */
	public static String get_NAMESPACE() {
		final String NAMESPACE = "http://www.ccny.android.com";
		return NAMESPACE;
	}

	/**
	 * @param METHOD_NAME
	 * @return
	 */
	public static String get_SOAP_ACTION(String METHOD_NAME) {
		final String SOAP_ACTION = "http://www.ccny.android.com" + METHOD_NAME;
		return SOAP_ACTION;
	}

	
}
