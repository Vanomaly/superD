package com.vanomaly.devel;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.vanomaly.jutils.SendEmail;

public class EmailBlaster {
	public static void main (String[] args) {
		Timer timer = new Timer("Emailer");
		MyTask t = new MyTask();
		timer.schedule(t, 0, (1800 * 1000));
	}
}
class MyTask extends TimerTask {
	private int times = 0;
	SendEmail sm = new SendEmail();
	public void run() {
		times++;
		if (times <= 500) {
			try {
				System.out.println("");
				System.out.println(new Date());
				sm.sendGmail("TEST: ALERT WEBSITE DOWN",
						"\n\t +--------------------------------------+" +
						"\n\t      " + new Date() + "       " +
						"\n\t +--------------------------------------+" +
						"\n\t      WEBSITE DOWN: No Ping Response     " +
						"\n\t +--------------------------------------+" +
						"\n\t      TEST: www.vanomaly.com             " +
						"\n\t +--------------------------------------+"
						, "alupis1@gmail.com");
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		} else {
			// timer stop
			this.cancel();
		}
	}
}
