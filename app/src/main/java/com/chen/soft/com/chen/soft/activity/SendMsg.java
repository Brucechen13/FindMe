package com.chen.soft.com.chen.soft.activity;

import android.os.Bundle;
import android.view.View;

import com.chen.soft.R;

/**
 * Created by chenchi_94 on 2015/8/31.
 */
public class SendMsg extends TitleActivity implements View.OnClickListener {

    @Override
    protected void onBackward(View backwardView) {
        // TODO Auto-generated method stub
        super.onBackward(backwardView);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView(){

        setContentView(R.layout.activity_sendmsg);
        setTitle(R.string.send_msg);
        showBackwardView(R.string.button_backward, true);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        super.onClick(v);
        switch (v.getId()) {
            default:
                break;
        }
    }

}
