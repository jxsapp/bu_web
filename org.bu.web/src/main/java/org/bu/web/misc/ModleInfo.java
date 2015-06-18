package org.bu.web.misc;

import java.io.Serializable;

import org.json.JSONObject;

public abstract class ModleInfo implements Serializable {
	private static final long serialVersionUID = 408294155661043861L;

	public JSONObject getJson(boolean all) {
		return BuGsonHolder.getJson(this, all);
	}

	public JSONObject getJson() {
		return getJson(true);
	}

	@Override
	public String toString() {
		return getJson().toString();
	}

}
