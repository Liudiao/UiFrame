package com.liudiao.uiframe.fragment;

import java.util.ArrayList;
import java.util.List;

import android.view.ViewGroup;

import com.liudiao.uiframe.adapter.BaseListAdapter;
import com.liudiao.uiframe.app.R;
import com.liudiao.uiframe.controller.CommonController;
import com.liudiao.uiframe.controller.IBaseController;
import com.liudiao.uiframe.model.JokeModel;
import com.liudiao.uiframe.view.CommonView;


/**
 * Created by match on 15-4-28.
 */
public class JokeFragment extends BaseListFragment<CommonView, JokeModel> {
    @Override
    protected BaseListAdapter<CommonView, JokeModel> newAdapter() {
        return new BaseListAdapter<CommonView, JokeModel>() {
            @Override
            protected CommonView newView(int position, JokeModel model, ViewGroup parent) {
                return new CommonView(parent.getContext(), R.layout.list_item_joke, parent);
            }

            @Override
            protected IBaseController newController(int position, JokeModel model) {
                return new CommonController();
            }

        };
    }

    @Override
    protected List<JokeModel> fetchDataSync() {
        String desc = "下了一天的雨，下午快递师傅打电话叫我下楼取快递，lz我随便套件衣服拿起钥匙就冲出去了，没想到快递嗷嗷沉，好不容易弄上楼开门的时候钥匙竟然折了！lz没带手机！lz没带钱！！lz没男朋友！！！";
        String time = "04-28 20:10";
        List<JokeModel> jokeModels = new ArrayList<JokeModel>();
        for (int i = 0; i< 20; i++) {
            JokeModel jokeModel = new JokeModel(desc, time);
            jokeModels.add(jokeModel);
        }
        return jokeModels;
    }
}
