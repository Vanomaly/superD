package com.vanomaly.jutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebUtils {
	public String getHTML(String website, boolean ssl, String useragent) {
		String html = "";
		String temp;
		String prefix;
		if (ssl) {
			prefix = "https://";
		} else {
			prefix = "http://";
		}
		try {
			URL url = new URL(prefix + website);
			URLConnection con = url.openConnection();
		if (!(useragent.equalsIgnoreCase(""))) {
			con.setRequestProperty("User-Agent", useragent);
		}
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		while((temp = in.readLine()) != null) {
			html += temp + "\n";
		}
		in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return html;
	}
}