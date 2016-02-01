package com.chuvadasquatro.netflixchanger.network;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.chuvadasquatro.netflixchanger.R;
import com.chuvadasquatro.netflixchanger.utils.Constants;
import com.chuvadasquatro.netflixchanger.utils.TrickByteParser;

/**
 * @author Rodrigo Costa
 */
public class HttpClient {
	private static HttpClient instance;

	private Context mContext;

	private HttpClient(Context context) {
		mContext = context;
	}

	public static synchronized HttpClient getInstance(Context context) {
		if (instance == null) {
			instance = new HttpClient(context);
		}
		return instance;
	}

	public void callService(HttpClientCallback callback) {
		callService(null, callback);
	}

	public void callService(String countryCode, final HttpClientCallback callback) {
		StringRequest request = new StringRequest(
				Request.Method.GET,
				Constants.TRICK_BYTE_URL + (countryCode != null ? "&nc=" + countryCode : ""),
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						callback.onSuccess(
								TrickByteParser.parseIP(
										response,
										mContext.getString(R.string.textInfoError)
								),
								TrickByteParser.parseCountry(response)
						);
					}
				},
				new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Toast.makeText(
								mContext,
								String.format(
										mContext.getString(R.string.error),
										error.getMessage()
								),
								Toast.LENGTH_LONG
						).show();
					}
				}
		);
		Volley.newRequestQueue(mContext).add(request);
	}
}
