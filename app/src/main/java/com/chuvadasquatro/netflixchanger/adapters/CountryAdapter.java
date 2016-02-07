package com.chuvadasquatro.netflixchanger.adapters;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import com.chuvadasquatro.netflixchanger.R;
import com.chuvadasquatro.netflixchanger.utils.Constants;
import com.chuvadasquatro.netflixchanger.utils.LayoutUtils;

/**
 * @author Rodrigo Costa
 */
public class CountryAdapter extends BaseAdapter {
	private Context mContext;
	private String[] mCountryCodes;

	public CountryAdapter(Context context) {
		mContext = context;
		mCountryCodes =
				Constants.COUNTRIES.keySet().toArray(new String[Constants.COUNTRIES.size()]);
	}

	@Override
	public int getCount() {
		return mCountryCodes.length;
	}

	@Override
	public Object getItem(int position) {
		return mCountryCodes[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView != null && convertView.getTag().equals(mCountryCodes[position])) {
			return convertView;
		}

		// create checked text view
		CheckedTextView country = new CheckedTextView(mContext);
		country.setLayoutParams(new ViewGroup.LayoutParams(
				LayoutUtils.getDimension(mContext, R.dimen.itemWidth),
				LayoutUtils.getDimension(mContext, R.dimen.itemHeight)
		));
		country.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
		country.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
		country.setCompoundDrawablesWithIntrinsicBounds(
				null,
				LayoutUtils.getFlagDrawable(mContext, mCountryCodes[position]),
				null,
				null
		);
		country.setTextSize(LayoutUtils.getDimension(mContext, R.dimen.itemTextSize));

		// set values
		country.setTag(mCountryCodes[position]);
		country.setText(Constants.COUNTRIES.get(mCountryCodes[position]).toUpperCase());

		return country;
	}
}
