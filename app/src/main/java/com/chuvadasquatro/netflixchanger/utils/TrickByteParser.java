package com.chuvadasquatro.netflixchanger.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Rodrigo Costa
 */
public class TrickByteParser {
	public static String parseIP(String html, String fallback) {
		return parseHTML(
				html,
				fallback,
				Constants.TRICK_BYTE_REGEXPS.get("ip")
		);
	}

	public static String parseCountry(String html) {
		return parseHTML(
				html,
				"",
				Constants.TRICK_BYTE_REGEXPS.get("country")
		);
	}

	private static String parseHTML(String html, String fallback, String regexp) {
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(html);
		return matcher.find() ? matcher.group(1) : fallback;
	}
}
