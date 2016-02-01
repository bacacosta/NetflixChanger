package com.chuvadasquatro.netflixchanger.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.chuvadasquatro.netflixchanger.R;
import com.chuvadasquatro.netflixchanger.adapters.CountryAdapter;
import com.chuvadasquatro.netflixchanger.network.HttpClient;
import com.chuvadasquatro.netflixchanger.network.HttpClientCallback;
import com.chuvadasquatro.netflixchanger.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		HttpClient.getInstance(this.getApplicationContext()).callService(new HttpClientCallback() {
			@Override
			public void onSuccess(String ip, String country) {
				callService(ip, country, false);
			}
		});

		GridView gridView = (GridView) findViewById(R.id.gridView);
		gridView.setAdapter(new CountryAdapter(this));
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				HttpClient.getInstance(view.getContext().getApplicationContext()).callService(
						view.getTag().toString(),
						new HttpClientCallback() {
							@Override
							public void onSuccess(String ip, String country) {
								callService(ip, country, true);
							}
						}
				);
			}
		});
	}

	private void callService(String ip, String country, Boolean showToast) {
		// update IP info
		TextView textInfo = (TextView) findViewById(R.id.textInfo);
		textInfo.setText(String.format(getString(R.string.textInfo), ip));

		// update selected country
		List<String> countries = new ArrayList<>();
		countries.addAll(Constants.COUNTRIES.values());

		GridView gridView = (GridView) findViewById(R.id.gridView);
		gridView.setItemChecked(countries.indexOf(country), true);

		if (showToast) {
			Toast.makeText(
					this,
					String.format(
							getString(R.string.success),
							country
					),
					Toast.LENGTH_SHORT
			).show();
		}
	}
}
