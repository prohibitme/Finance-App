package com.invalid.finance;

import android.content.Context;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by arloa on 30.01.2016.
 */
public class AmountSimpleAdapter extends SimpleAdapter {

    public AmountSimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }
}
