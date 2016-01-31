package com.chuvadasquatro.netflixchanger.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import com.chuvadasquatro.netflixchanger.utils.Constants;

/**
 * @author Rodrigo Costa
 */
public class CountryAdapter extends BaseAdapter {
	private Context context;
	private String[] countryCodes;

	public CountryAdapter(Context c) {
		context = c;
		countryCodes = Constants.COUNTRIES.keySet().toArray(new String[Constants.COUNTRIES.size()]);
	}

	@Override
	public int getCount() {
		return countryCodes.length;
	}

	@Override
	public Object getItem(int position) {
		return countryCodes[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView != null && convertView.getTag().equals(countryCodes[position])) {
			return convertView;
		}

		CheckedTextView country = new CheckedTextView(context);
		country.setTag(countryCodes[position]);
		country.setText(Constants.COUNTRIES.get(countryCodes[position]));
		country.setCheckMarkDrawable(getCountryDrawable());
		return country;
	}

	private Drawable getCountryDrawable() {
		StateListDrawable countryDrawable = new StateListDrawable();
		countryDrawable.addState(
				new int[] {-android.R.attr.state_checked},
				context.getDrawable(android.R.drawable.checkbox_off_background)
		);
		countryDrawable.addState(
				new int[] {android.R.attr.state_checked},
				context.getDrawable(android.R.drawable.checkbox_on_background)
		);
		return countryDrawable;
	}
}
