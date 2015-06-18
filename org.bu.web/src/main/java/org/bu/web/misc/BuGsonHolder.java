package org.bu.web.misc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class BuGsonHolder {

	public static <T> JSONObject getJson(T t, boolean all) {
		JSONObject json = new JSONObject();
		Gson gson = new Gson();
		if (!all) {
			gson = getWithoutExpose();
		}
		try {
			String rst = gson.toJson(t);
			if (!StringUtils.isEmpty(rst)) {
				json = new JSONObject(rst);
			}
		} catch (Exception e) {
			json = new JSONObject();
		}

		return json;
	}

	public static String getJson(List<?> list) {
		Gson gson = new Gson();
		return gson.toJson(list);
	}

	public static <T> T getObj(String json) {
		T list = null;
		java.lang.reflect.Type type = new TypeToken<T>() {
		}.getType();
		Gson gson = new Gson();
		list = gson.fromJson(json, type);
		return list;

	}

	public static Gson getWithoutExpose() {
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	}

	public static <T> T getObj(String json, Class<T> t) {
		T rst = null;
		try {
			Gson gson = new Gson();
			rst = gson.fromJson(json, t);
		} catch (Exception e) {
			rst = null;
		}
		return rst;
	}
}
