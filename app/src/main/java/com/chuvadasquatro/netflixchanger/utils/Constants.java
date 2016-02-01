package com.chuvadasquatro.netflixchanger.utils;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualLinkedHashBidiMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rodrigo Costa
 */
public class Constants {
	public static final String TRICK_BYTE_URL = "";
	public static final BidiMap<String, String> COUNTRIES;
	public static final Map<String, String> TRICK_BYTE_REGEXPS;

	static {
		COUNTRIES = new DualLinkedHashBidiMap<>();
		COUNTRIES.put("us", "USA");
		COUNTRIES.put("vdous", "Youtube US");
		COUNTRIES.put("uk", "United Kingdom");
		COUNTRIES.put("au", "Australia");
		COUNTRIES.put("br", "Brazil");
		COUNTRIES.put("ca", "Canada");
		COUNTRIES.put("dk", "Denmark");
		COUNTRIES.put("fr", "France");
		COUNTRIES.put("de", "Germany");
		COUNTRIES.put("jp", "Japan");
		COUNTRIES.put("mx", "Mexico");
		COUNTRIES.put("ne", "Netherlands");
		COUNTRIES.put("nz", "New Zealand");
		COUNTRIES.put("es", "Spain");
		COUNTRIES.put("se", "Sweden");
		COUNTRIES.put("swi", "Switzerland");

		TRICK_BYTE_REGEXPS = new HashMap<>();
		TRICK_BYTE_REGEXPS.put("ip", "Your ip (.*) is updated!");
		TRICK_BYTE_REGEXPS.put("country", "Your current Netflix changer is (.*)<br>");
	}
}
