package com.chuvadasquatro.netflixchanger;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualLinkedHashBidiMap;

/**
 * @author Rodrigo Costa
 */
public class Constants {
	public static final BidiMap<String, String> COUNTRIES;
	static {
		COUNTRIES = new DualLinkedHashBidiMap<>();
		COUNTRIES.put("us", "USA");
		COUNTRIES.put("vdous", "Youtube US");
		COUNTRIES.put("uk", "UK");
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
	}
}
