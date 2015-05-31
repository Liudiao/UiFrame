package com.liudiao.uiframe.fragment;

import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.liudiao.uiframe.adapter.BaseListAdapter;
import com.liudiao.uiframe.app.R;
import com.liudiao.uiframe.model.IModel;
import com.liudiao.uiframe.view.IView;

/**
 * Created by match on 15-4-28.
 */
public abstract class BaseListFragment<V extends IView, M extends IModel> extends Fragment {

    private ListView listView;
    private BaseListAdapter listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.list_view);
        listAdapter = newAdapter();
        listView.setAdapter(listAdapter);
        loadData();
        return view;
    }

    protected abstract BaseListAdapter<V ,M> newAdapter();

    protected abstract List<M> fetchDataSync();

    private void loadData() {
        AsyncTask<Void, Void, List<M>> asyncTask = new AsyncTask<Void, Void, List<M>>() {
            @Override
            protected List<M> doInBackground(Void... params) {
                return fetchDataSync();
            }

            @Override
            protected void onPostExecute(List<M> result) {
                if (listAdapter != null) {
                    listAdapter.setData(result);
                }
            }
        };
        asyncTask.execute();
    }

}
