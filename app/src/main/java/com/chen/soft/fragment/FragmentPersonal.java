package com.chen.soft.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chen.soft.R;
import com.chen.soft.activity.SendMsg;

/**
 * Created by chenchi_94 on 2015/8/30.
 */
public class FragmentPersonal extends BaseFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_personal, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d("findMe", "Map create");
        super.onActivityCreated(savedInstanceState);

        Button send = (Button) getView().findViewById(R.id.sendMsg);
        send.setOnClickListener(this);
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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
