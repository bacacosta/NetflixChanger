package com.chuvadasquatro.netflixchanger.network;

/**
 * @author Rodrigo Costa
 */
public interface HttpClientCallback {
	void onSuccess(String ip, String country);
}
