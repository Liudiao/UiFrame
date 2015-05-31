package com.liudiao.uiframe.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by match on 15-4-28.
 */
public class ViewUtils {
    public static View inflateView(Context context, int layoutId) {
        return inflateView(context, layoutId, null);
    }

    public static View inflateView(Context context, int layoutId, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(layoutId, parent, false);
    }

    public static View inflateView(int layoutId, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(layoutId, parent, false);
    }
}
