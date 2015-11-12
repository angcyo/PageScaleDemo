package com.angcyo.pagescaledemo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by angcyo on 15-11-10-010.
 */
public class ScalePagerView extends ViewPager {

    public static final String TAG = "ScalePagerView";
    private static final float MIN_SCALE = 0.75f;

    public ScalePagerView(Context context) {
        this(context, null);
    }

    public ScalePagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        this.setPageTransformer(true, new PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                Log.e(TAG, "id: " + page + " position:" + position);

                if (position < -1) {//看不到的一页
                    page.setScaleX(1);
                    page.setScaleY(1);
                } else if (position <= 1) {
                    if (position < 0) {//滑出的页 0.0 ~ -1
                        float scaleFactor = (1 - MIN_SCALE) * (0 - position);
                        page.setScaleX(1 - scaleFactor);
                        page.setScaleY(1 - scaleFactor);
                    } else {//滑进的页 1 ~ 0.0
                        float scaleFactor = (1 - MIN_SCALE) * (1 - position);
                        page.setScaleX(MIN_SCALE + scaleFactor);
                        page.setScaleY(MIN_SCALE + scaleFactor);
                    }
                } else {//看不到的另一页
                    page.setScaleX(1);
                    page.setScaleY(1);
                }
            }
        });
    }
}
