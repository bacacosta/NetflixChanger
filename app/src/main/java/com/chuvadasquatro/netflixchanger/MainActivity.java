package com.chuvadasquatro.netflixchanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		for (String countryCode : Constants.COUNTRIES.keySet()) {
			RadioButton button = new RadioButton(this);
			button.setTag(countryCode);
			button.setText(Constants.COUNTRIES.get(countryCode));
			radioGroup.addView(button);
		}
	}
}
