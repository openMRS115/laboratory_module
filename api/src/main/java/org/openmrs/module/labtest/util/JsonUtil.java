package org.openmrs.module.labtest.util;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtil {
	
	public int getAge(String json) {
		JsonParser jsonParser = new JsonParser();
		JsonObject object = (JsonObject) jsonParser.parse(json);
		JsonArray array = object.get("results").getAsJsonArray();
		JsonObject resultsObject = array.get(0).getAsJsonObject();
		int age = resultsObject.get("age").getAsInt();
		return age;
	}
	
	public String getGender(String json) {
		JsonParser jsonParser = new JsonParser();
		JsonObject object = (JsonObject) jsonParser.parse(json);
		JsonArray array = object.get("results").getAsJsonArray();
		JsonObject resultsObject = array.get(0).getAsJsonObject();
		String gender = resultsObject.get("gender").getAsString();
		if ("M".equals(gender)) {
			gender = "Male";
			
		} else if ("F".equals(gender)) {
			gender = "Female";
		} else {
			gender = "Unknown";
		}
		return gender;
	}
	
	public String getIdentifier(String json) {
		JsonParser jsonParser = new JsonParser();
		JsonObject object = (JsonObject) jsonParser.parse(json);
		JsonArray array = object.get("results").getAsJsonArray();
		JsonObject resultsObject = array.get(0).getAsJsonObject();
		JsonArray identifiersArray = resultsObject.get("identifiers").getAsJsonArray();
		JsonObject identifiersObject = identifiersArray.get(0).getAsJsonObject();
		String identifier = identifiersObject.get("identifier").getAsString();
		return identifier;
	}
	
	public String getProvince(String json) {
		JsonParser jsonParser = new JsonParser();
		JsonObject object = (JsonObject) jsonParser.parse(json);
		JsonArray array = object.get("results").getAsJsonArray();
		JsonObject resultsObject = array.get(0).getAsJsonObject();
		JsonArray addressesArray = resultsObject.get("addresses").getAsJsonArray();
		JsonObject addressesObject = addressesArray.get(0).getAsJsonObject();
		String province = "";
		if (addressesObject.get("stateProvince").isJsonNull()) {
			province = "Unknown";
		} else {
			province = addressesObject.get("stateProvince").getAsString();
		}
		
		return province;
	}
	
	public String getCity(String json) {
		JsonParser jsonParser = new JsonParser();
		JsonObject object = (JsonObject) jsonParser.parse(json);
		JsonArray array = object.get("results").getAsJsonArray();
		JsonObject resultsObject = array.get(0).getAsJsonObject();
		JsonArray addressesArray = resultsObject.get("addresses").getAsJsonArray();
		JsonObject addressesObject = addressesArray.get(0).getAsJsonObject();
		String city = "";
		if (addressesObject.get("cityVillage").isJsonNull()) {
			city = "Unknown";
		} else {
			city = addressesObject.get("cityVillage").getAsString();
		}
		return city;
	}
	
	public String getlatitude(String json) {
		JsonParser jsonParser = new JsonParser();
		JsonObject object = (JsonObject) jsonParser.parse(json);
		JsonArray array = object.get("results").getAsJsonArray();
		JsonObject resultsObject = array.get(0).getAsJsonObject();
		JsonArray addressesArray = resultsObject.get("addresses").getAsJsonArray();
		JsonObject addressesObject = addressesArray.get(0).getAsJsonObject();
		String latitude = "";
		if (addressesObject.get("latitude").isJsonNull()) {
			latitude = "Unknown";
		} else {
			latitude = addressesObject.get("latitude").getAsString();
		}
		return latitude;
	}
	
	public String getlongitude(String json) {
		JsonParser jsonParser = new JsonParser();
		JsonObject object = (JsonObject) jsonParser.parse(json);
		JsonArray array = object.get("results").getAsJsonArray();
		JsonObject resultsObject = array.get(0).getAsJsonObject();
		JsonArray addressesArray = resultsObject.get("addresses").getAsJsonArray();
		JsonObject addressesObject = addressesArray.get(0).getAsJsonObject();
		String longitude = "";
		if (addressesObject.get("longitude").isJsonNull()) {
			longitude = "Unknown";
		} else {
			longitude = addressesObject.get("longitude").getAsString();
		}
		return longitude;
	}
	
	public boolean getDead(String json) {
		JsonParser jsonParser = new JsonParser();
		JsonObject object = (JsonObject) jsonParser.parse(json);
		JsonArray array = object.get("results").getAsJsonArray();
		JsonObject resultsObject = array.get(0).getAsJsonObject();
		boolean dead = resultsObject.get("dead").getAsBoolean();
		return dead;
	}
	
	public String getDeathDate(String json) {
		JsonParser jsonParser = new JsonParser();
		JsonObject object = (JsonObject) jsonParser.parse(json);
		JsonArray array = object.get("results").getAsJsonArray();
		JsonObject resultsObject = array.get(0).getAsJsonObject();
		String deathDate = "";
		if (resultsObject.get("deathDate").isJsonNull()) {
			deathDate = "";
		} else {
			deathDate = resultsObject.get("deathDate").getAsString();
		}
		return deathDate;
	}
}
