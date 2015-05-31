package com.liudiao.uiframe.view;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author match@wandoujia.com (Diao Liu)
 */
public interface ICommonView extends IView{
  TextView getDescription();
  ImageView getImage();
  TextView getTime();
}
