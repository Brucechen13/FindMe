package com.chen.soft.adapt;

/**
 * Created by chenchi_94 on 2015/9/13.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chen.soft.R;

import java.util.List;

public class MsgsAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<MsgBean> data;
    private Context mContext;
    private View view[] = null;

    public MsgsAdapter(Context context, List<MsgBean> list) {
        this.data = list;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mContext = context;
    }

    public class ViewHolder {
        public ImageView userimg_iv;
        public TextView username;
        public TextView contenttime;
        public TextView time;
        public TextView content;
        public TextView area;
        public LinearLayout content_ll;
        public TextView good_num;
        public TextView comment_num;
        public ImageView comgood_iv;
        public ImageView good_img;
        public ImageView comment_img;
        public RelativeLayout comgoodhandle;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(mContext).inflate(
                            R.layout.item_msg, parent, false);
            holder.username = (TextView) convertView
                    .findViewById(R.id.username);
            holder.contenttime = (TextView) convertView
                    .findViewById(R.id.date);
            holder.time = (TextView) convertView
                    .findViewById(R.id.time);
            holder.content = (TextView) convertView
                    .findViewById(R.id.content);
            holder.area = (TextView) convertView
                    .findViewById(R.id.area_tv);
            holder.good_num = (TextView) convertView
                    .findViewById(R.id.good_num);
            holder.comment_num = (TextView) convertView
                    .findViewById(R.id.comment_num);

            holder.userimg_iv = (ImageView) convertView
                    .findViewById(R.id.user_img);
            holder.comgood_iv = (ImageView) convertView
                    .findViewById(R.id.comgood_iv);
            holder.good_img = (ImageView) convertView
                    .findViewById(R.id.good_img);
            holder.comment_img = (ImageView) convertView
                    .findViewById(R.id.comment_img);
            holder.comgoodhandle = (RelativeLayout) convertView
                    .findViewById(R.id.comgoodhandle);
            holder.content_ll = (LinearLayout) convertView
                    .findViewById(R.id.content_ll);
            convertView.setTag(holder);
            convertView.setId(position);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        OnClickListener userInfoListener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//                Intent intent = new Intent(mContext, UserInfoView.class);
//                intent.putExtra("userid", data.get(position).getUserId());
//                mContext.startActivity(intent);
            }
        };
        OnClickListener infoDetailListener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//                Intent intent = new Intent(mContext, TraffficMsgDetail.class);
//                Bundle bundle = new Bundle();
//                bundle.putParcelable("msg", data.get(position));
//                Log.d("traffic", "push msg:" + data.get(position).getUserName());
//                intent.putExtras(bundle);
//                mContext.startActivity(intent);
            }
        };
        MsgBean msg = data.get(position);
        holder.username.setText(msg.getUserName());
        holder.contenttime.setText(msg.getContentTime());
        holder.time.setText(msg.getTime());
        holder.content.setText("在" + msg.getContent());
        holder.area.setText(msg.getPlace());
        holder.good_num.setText(msg.getGoodNum());
        holder.comment_num.setText(msg.getCommentNum());


        holder.username.setOnClickListener(userInfoListener);

//        Ion.with(this.mContext)
//                .load(data.get(position).getTouPic())
//                .withBitmap()
//                        //.placeholder(R.drawable.placeholder_image)
//                .error(R.drawable.tou)
//                .intoImageView(holder.userimg_iv).setCallback(new FutureCallback<ImageView>() {
//            @Override
//            public void onCompleted(Exception arg0, ImageView arg1) {
//                // TODO Auto-generated method stub
//                if (arg0 != null) {
//                    Log.d("traffic", arg0.toString());
//                }
//            }
//
//        });
        holder.userimg_iv.setOnClickListener(userInfoListener);

        holder.content_ll.setOnClickListener(infoDetailListener);
        holder.comment_img.setOnClickListener(infoDetailListener);

        holder.good_img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("traffic", "good num");
//                String num = data.get(position).getGoodNum();
//                data.get(position).setGoodNum(String.valueOf(Integer.parseInt(num) + 1));
//                holder.good_num.setText(data.get(position).getGoodNum());
//                holder.good_img.setVisibility(View.GONE);
//                Ion.with(MsgsAdapter.this.mContext)
//                        .load(String.format("%s?msg=%s", ServerUtil.addUpMsgUrl,
//                                data.get(position).getId())).asJsonObject()
//                        .setCallback(new FutureCallback<JsonObject>() {
//
//                            @Override
//                            public void onCompleted(Exception arg0, JsonObject arg1) {
//                                // TODO Auto-generated method stub
//                                if (arg0 != null || !"true".equals(arg1.get("suc").getAsString())) {
//                                    Log.i("traffic", "failed");
//
//                                }
//                            }
//
//                        });
            }
        });

        holder.comgood_iv.setOnClickListener(new OnClickListener() {
            Boolean flag = false;

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (!flag) {

                    holder.comgoodhandle.setVisibility(View.VISIBLE);
                    flag = true;
                } else {
                    holder.comgoodhandle.setVisibility(View.GONE);
                    flag = false;
                }

            }
        });
        return convertView;
    }

    public void addNews(List<MsgBean> addNews) {
        data.addAll(addNews);
    }

    public void addFirstNews(List<MsgBean> addNews) {
        data.addAll(0, addNews);
    }

}
