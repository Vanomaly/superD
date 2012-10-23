/*******************************************************************************
 *  Copyright 2012 Vanomaly.com and Jason Sipula                               *
 *                                                                             *
 *  Licensed under the Apache License, Version 2.0 (the "License");            *
 *  you may not use this file except in compliance with the License.           *
 *  You may obtain a copy of the License at                                    *
 *                                                                             *
 *      http://www.apache.org/licenses/LICENSE-2.0                             *
 *                                                                             *
 *  Unless required by applicable law or agreed to in writing, software        *
 *  distributed under the License is distributed on an "AS IS" BASIS,          *
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 *  See the License for the specific language governing permissions and        *
 *  limitations under the License.                                             *
 *******************************************************************************/

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