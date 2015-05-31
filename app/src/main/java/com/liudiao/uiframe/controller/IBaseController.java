package com.liudiao.uiframe.controller;

import com.liudiao.uiframe.model.IModel;
import com.liudiao.uiframe.view.IView;


/**
 * Base for all controllers.
 * This interface is to make a standard for all controllers. Each controller should be bind with
 * BaseView and BaseModel.
 * 
 * @author Diao Liu
 */
public interface IBaseController<V extends IView, M extends IModel> {
  /**
   * Bind the view and model.
   * 
   * @param v view
   * @param m model
   */
  void bind(V v, M m);
}
