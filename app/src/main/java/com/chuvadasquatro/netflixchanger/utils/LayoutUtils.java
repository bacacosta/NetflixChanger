package com.chuvadasquatro.netflixchanger.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

import com.chuvadasquatro.netflixchanger.R;

/**
 * @author Rodrigo Costa
 */
public class LayoutUtils {
	public static int getDimension(Context context, int id) {
		return (int) context.getResources().getDimension(id);
	}

	public static Drawable getFlagDrawable(Context context, String countryCode) {
		StateListDrawable drawable = new StateListDrawable();

		// normal state
		drawable.addState(
				new int[] {-android.R.attr.state_checked},
				new BitmapDrawable(context.getResources(), getFlag(context, countryCode))
		);

		// selected state
		drawable.addState(
				new int[] {android.R.attr.state_checked},
				new BitmapDrawable(context.getResources(), getCheckedFlag(context, countryCode))
		);

		return drawable;
	}

	private static Bitmap getFlag(Context context, String countryCode) {
		return getBitmap(context, countryCode);
	}

	private static Bitmap getCheckedFlag(Context context, String countryCode) {
		Bitmap checkedFlag = Bitmap.createBitmap(
				getDimension(context, R.dimen.bmpWidth),
				getDimension(context, R.dimen.bmpHeight),
				Bitmap.Config.ARGB_8888
		);
		Canvas canvas = new Canvas(checkedFlag);

		// transform flag to black and white
		Paint paint = new Paint();
		ColorMatrix colorMatrix = new ColorMatrix();
		colorMatrix.setSaturation(0);
		ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
		paint.setColorFilter(colorFilter);
		canvas.drawBitmap(getFlag(context, countryCode), 0, 0, paint);

		// add border
		canvas.drawBitmap(getBitmap(context, "checked"), 0, 0, null);

		return checkedFlag;
	}

	private static Bitmap getBitmap(Context context, String filename) {
		return Bitmap.createScaledBitmap(
				BitmapFactory.decodeResource(
						context.getResources(),
						context.getResources().getIdentifier(
								filename,
								"drawable",
								context.getPackageName()
						)
				),
				getDimension(context, R.dimen.bmpWidth),
				getDimension(context, R.dimen.bmpHeight),
				true
		);
	}
}
