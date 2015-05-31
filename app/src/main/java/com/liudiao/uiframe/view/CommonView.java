package com.liudiao.uiframe.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liudiao.uiframe.app.R;
import com.liudiao.uiframe.utils.ViewUtils;

/**
 * @author match@wandoujia.com (Diao Liu)
 */
public class CommonView implements ICommonView {

  private TextView description;
  private ImageView image;
  private TextView time;
  private View view;

  public CommonView(Context context, int layoutId, ViewGroup parent) {
    view = ViewUtils.inflateView(context, layoutId, parent);
  }


  @Override
  public TextView getDescription() {
    if (description == null) {
      description = (TextView) view.findViewById(R.id.description);
    }
    return description;
  }

  @Override
  public ImageView getImage() {
    if (image == null) {
      image = (ImageView) view.findViewById(R.id.image);
    }
    return image;
  }

  @Override
  public TextView getTime() {
    if (time == null) {
      time = (TextView) view.findViewById(R.id.time);
    }
    return time;
  }

  @Override
  public View getView() {
    return view;
  }
}
