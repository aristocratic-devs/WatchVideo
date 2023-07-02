package com.example.watchvideo.utils.luck_spin.model;

import android.annotation.SuppressLint;

import com.example.watchvideo.R;

/**
 * Created by kiennguyen on 11/5/16.
 */

public class LuckyItem {

    public LuckyItem(int index) {

        if (index % 2 == 0) {
            color = R.color.one;
        } else {
            color = R.color.two;
        }

        topText = String.valueOf((index * 50));
    }

    public String topText;
    public String secondaryText;
    public int secondaryTextOrientation;
    public int icon = R.drawable.transparent;
    public int color;
}
