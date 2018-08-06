package com.citi.hz41382.java.model.factory.factorymethod;

import java.io.IOException;

import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {

	public static void main(String args[]) throws IOException{
		URL yahoo = new URL("http://www.yahoo.com/");
		URLConnection yc = yahoo.openConnection();
	}

}
