package com.chen.soft.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.chen.soft.R;
import com.chen.soft.activity.SendMsg;
import com.chen.soft.adapt.MsgBean;
import com.chen.soft.adapt.MsgsAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import java.util.ArrayList;

/**
 * Created by chenchi_94 on 2015/8/30.
 */
public class FragmentPersonal extends BaseFragment implements View.OnClickListener {

    private PullToRefreshListView msgList = null;
    private MsgsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_personal, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d("findMe", "Map create");
        super.onActivityCreated(savedInstanceState);
        intiView();

    }

    private void intiView(){
        Button send = (Button) getView().findViewById(R.id.sendMsg);
        send.setOnClickListener(this);
        msgList = (PullToRefreshListView) getView().findViewById(R.id.msgList);
        adapter = new MsgsAdapter(getView().getContext(),
                getMsgs(null));
        initPullToRefreshListView(msgList, adapter);
    }

    private void initPullToRefreshListView(PullToRefreshListView msgList,
                                           BaseAdapter adapter) {
        // TODO Auto-generated method stub
        Log.d("traffic", "create list");
        msgList.setMode(PullToRefreshBase.Mode.BOTH);
        msgList.setOnRefreshListener(new MyOnRefreshListener2(msgList));
        msgList.setAdapter(adapter);
        //loadData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendMsg:
                Intent intent = new Intent(this.getActivity(), SendMsg.class);
                this.startActivity(intent);
                break;
            default:
                break;
        }

    }

    class MyOnRefreshListener2 implements PullToRefreshBase.OnRefreshListener2<ListView> {

        private PullToRefreshListView mPtflv;

        public MyOnRefreshListener2(PullToRefreshListView ptflv) {
            this.mPtflv = ptflv;
        }

        @Override
        public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
            // 下拉刷新
            String label = DateUtils.formatDateTime(getView().getContext(),
                    System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
                            | DateUtils.FORMAT_SHOW_DATE
                            | DateUtils.FORMAT_ABBREV_ALL);

            refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
            //loadNewestData();

        }

        @Override
        public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
            // 上拉加载
            // new GetNewsTask(mPtflv).execute();
            //loadData();
        }

    }

    private ArrayList<MsgBean> getMsgs(Object res){
        ArrayList<MsgBean> ret = new ArrayList<MsgBean>();
        for (int i = 0; i < 10; i++) {
            MsgBean msg = new MsgBean();
            ret.add(msg);
        }
        return ret;
    }
}
