package com.liudiao.uiframe.adapter;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.liudiao.uiframe.app.R;
import com.liudiao.uiframe.controller.IBaseController;
import com.liudiao.uiframe.model.IModel;
import com.liudiao.uiframe.view.IView;


/**
 * @param <M> model type.
 * @author match@wandoujia.com (Diao Liu)
 */
public abstract class BaseListAdapter<V extends IView, M extends IModel> extends BaseAdapter {

  public static final String TAG = BaseListAdapter.class.getSimpleName();

  private static final int TAG_KEY_CONTROLLER = R.id.item_controller;
  private static final int TAG_KEY_VIEW_HOLDER = R.id.item_view_holder;

  private List<M> modelList;

  public void setData(List<M> modelList) {
    this.modelList = modelList;
    notifyDataSetChanged();
  }

  @Override
  public int getCount() {
    if (modelList == null) {
      return 0;
    }
    return modelList.size();
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public M getItem(int position) {
    return modelList.get(position);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    IBaseController cardController;
    IView viewHolder = null;
    if (convertView != null) {
      cardController = (IBaseController) convertView.getTag(TAG_KEY_CONTROLLER);
      viewHolder = (IView) convertView.getTag(TAG_KEY_VIEW_HOLDER);
    } else {
      viewHolder = newView(position, getItem(position), parent);
      convertView = viewHolder.getView();
      cardController = newController(position, getItem(position));
      convertView.setTag(TAG_KEY_CONTROLLER, cardController);
      convertView.setTag(TAG_KEY_VIEW_HOLDER, viewHolder);
    }
    cardController.bind(viewHolder, getItem(position));
    return convertView;
  }

  protected abstract IView newView(int position, M model, ViewGroup parent);

  protected abstract IBaseController newController(int position, M model);
}
