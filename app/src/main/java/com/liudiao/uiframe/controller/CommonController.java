package com.liudiao.uiframe.controller;

import android.widget.ImageView;
import android.widget.TextView;

import com.liudiao.uiframe.model.ICommonModel;
import com.liudiao.uiframe.view.ICommonView;

/**
 * Created by match on 15-4-28.
 */
public class CommonController implements IBaseController<ICommonView,ICommonModel> {
    @Override
    public void bind(ICommonView view, ICommonModel commonModel) {
        TextView descriptionView = view.getDescription();
        if (descriptionView != null) {
            descriptionView.setText(commonModel.getDescription());
        }

        ImageView imageView = view.getImage();
        if (imageView != null) {
            // TODO: 实现AsyncImageView或者使用fresco等
            // imageView.setImageUrl(commonModel.getImageUrl());
        }

        TextView timeTextView = view.getTime();
        if (timeTextView != null) {
            timeTextView.setText(commonModel.getTime());
        }
    }
}
