package com.liudiao.uiframe.fragment;

import java.util.ArrayList;
import java.util.List;

import android.view.ViewGroup;

import com.liudiao.uiframe.adapter.BaseListAdapter;
import com.liudiao.uiframe.app.R;
import com.liudiao.uiframe.controller.CommonController;
import com.liudiao.uiframe.controller.IBaseController;
import com.liudiao.uiframe.model.PictureModel;
import com.liudiao.uiframe.view.CommonView;


/**
 * Created by match on 15-4-28.
 */
public class PictureFragment extends BaseListFragment<CommonView, PictureModel> {
    @Override
    protected BaseListAdapter<CommonView, PictureModel> newAdapter() {
        return new BaseListAdapter<CommonView, PictureModel>() {
            @Override
            protected CommonView newView(int position, PictureModel model, ViewGroup parent) {
              return new CommonView(parent.getContext(), R.layout.list_item_picture, parent);
            }

            @Override
            protected IBaseController newController(int position, PictureModel model) {
                return new CommonController();
            }

        };
    }

    @Override
    protected List<PictureModel> fetchDataSync() {
        String desc = "转的，觉得很棒就赞一个吧。";
        String img = "http://img5.imgtn.bdimg.com/it/u=800992399,1753760308&fm=21&gp=0.jpg";
        String time = "04-28 20:10";
        List<PictureModel> pictureModels = new ArrayList<PictureModel>();
        for (int i = 0; i< 20; i++) {
            PictureModel jokeModel = new PictureModel(desc, img, time);
            pictureModels.add(jokeModel);
        }
        return pictureModels;
    }
}
