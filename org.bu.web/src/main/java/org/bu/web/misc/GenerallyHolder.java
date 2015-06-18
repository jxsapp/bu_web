package org.bu.web.misc;

import java.util.Date;
import java.util.UUID;

public class GenerallyHolder {

	public static String getTimeSerial() {
		return Timer.getSDFyyMMdd().format(new Date());
	}

	public static String getGroupId() {
		return Timer.getSDFyyyyMMddHHmmss().format(new Date());
	}

	public static String nextSerialNumber() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("\\-", "");
	}

}
