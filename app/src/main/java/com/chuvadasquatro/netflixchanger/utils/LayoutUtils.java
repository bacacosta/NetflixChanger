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
				new BitmapDrawable(context.getResources(), getResizedFlag(context, countryCode))
		);

		// selected state
		drawable.addState(
				new int[] {android.R.attr.state_checked},
				new BitmapDrawable(context.getResources(), getSelectedFlag(context, countryCode))
		);

		return drawable;
	}

	private static Bitmap getResizedFlag(Context context, String countryCode) {
		return Bitmap.createScaledBitmap(
				getFlag(context, countryCode),
				getDimension(context, R.dimen.bmpWidth),
				getDimension(context, R.dimen.bmpHeight),
				true
		);
	}

	private static Bitmap getSelectedFlag(Context context, String countryCode) {
		Bitmap resizedFlag = getResizedFlag(context, countryCode);
		Bitmap selectedFlag = Bitmap.createBitmap(
				resizedFlag.getWidth(),
				resizedFlag.getHeight(),
				Bitmap.Config.ARGB_8888
		);

		// transform flag to black and white
		Canvas canvas = new Canvas(selectedFlag);
		Paint paint = new Paint();
		ColorMatrix colorMatrix = new ColorMatrix();
		colorMatrix.setSaturation(0);
		ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
		paint.setColorFilter(colorFilter);
		canvas.drawBitmap(resizedFlag, 0, 0, paint);

		return selectedFlag;
	}

	private static Bitmap getFlag(Context context, String countryCode) {
		return BitmapFactory.decodeResource(
				context.getResources(),
				context.getResources().getIdentifier(
						countryCode,
						"drawable",
						context.getPackageName()
				)
		);
	}
}
