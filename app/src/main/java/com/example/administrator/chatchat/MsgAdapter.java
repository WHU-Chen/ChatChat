package com.example.administrator.chatchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/8/23.
 */
public class MsgAdapter extends ArrayAdapter<Msg> {

    private int resourceId;

    public MsgAdapter(Context context, int resource, List<Msg> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Msg msg=getItem(position);
        ViewHolder viewHolder;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder=new ViewHolder();

            viewHolder.leftLayout= (LinearLayout) view.findViewById(R.id.left_layout);
            viewHolder.rightLayout= (LinearLayout) view.findViewById(R.id.right_layout);
            viewHolder.leftMsg= (TextView) view.findViewById(R.id.left_msg);
            viewHolder.rightMsg= (TextView) view.findViewById(R.id.right_msg);

            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        if(msg.getMessegeType()==msg.TYPE_SEND){
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.rightMsg.setText(msg.getContent());
        }
        else if(msg.getMessegeType()==msg.TYPE_RECEIVE){
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
        }
        return view;
    }
    class ViewHolder{
        LinearLayout leftLayout,rightLayout;
        TextView leftMsg,rightMsg;
    }
}
