package testing;

import com.vanomaly.jutils.WebUtils;

public class TestWeb {
	public static void main (String[] args) {
		WebUtils web = new WebUtils();
		System.out.println(web.getHTML("www.isohub.net", false, ""));
	}
}
