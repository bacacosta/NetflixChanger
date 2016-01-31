package com.chuvadasquatro.netflixchanger.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.chuvadasquatro.netflixchanger.R;
import com.chuvadasquatro.netflixchanger.adapters.CountryAdapter;

public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		GridView gridView = (GridView) findViewById(R.id.gridView);
		gridView.setAdapter(new CountryAdapter(this));
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(
						MainActivity.this,
						view.getTag().toString(),
						Toast.LENGTH_SHORT
				).show();
			}
		});
	}
}
