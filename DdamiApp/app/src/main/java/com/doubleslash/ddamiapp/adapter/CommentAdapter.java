package com.doubleslash.ddamiapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.model.CommentItem;

import java.util.ArrayList;

public class CommentAdapter extends BaseExpandableListAdapter {

    //private Context c = null;
    private ArrayList<String> groupList = null;
    private ArrayList<ArrayList<String>> childList = null;
    private LayoutInflater inflater = null;
    private ViewHolder viewHolder = null;

    public CommentAdapter(Context c, ArrayList<String> groupList, ArrayList<ArrayList<String>> childList){

        super();
        //this.c = c;
        this.inflater = LayoutInflater.from(c);
        this.groupList = groupList;
        this.childList = childList;
    }

    @Override
    public String getGroup(int groupPosition){
        return groupList.get(groupPosition);
    }

    @Override
    public int getGroupCount(){
        return groupList.size();
    }

    @Override
    public long getGroupId(int groupPosition){
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent){
        View v = convertView;

        if(v == null){
            viewHolder = new ViewHolder();
            v = inflater.inflate(R.layout.detail_item_comments, parent, false);

            viewHolder.commentProfile = (ImageView)v.findViewById(R.id.comment_profile);
            viewHolder.commentNic = (TextView)v.findViewById(R.id.comment_nic);
            viewHolder.cYear = (TextView)v.findViewById(R.id.comment_year);
            viewHolder.cMonth = (TextView)v.findViewById(R.id.comment_month);
            viewHolder.cDay = (TextView)v.findViewById(R.id.comment_day);
            viewHolder.commentContext = (TextView)v.findViewById(R.id.comment_contexts);
            viewHolder.recomments = (TextView)v.findViewById(R.id.recomments);

            v.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)v.getTag();
        }

        if(isExpanded){
            // viewHolder.commentProfile.setBackgroundColor(Color.GREEN);
        }else{
            // viewHolder.commentProfile.setBackgroundColor(Color.WHITE);
        }

        viewHolder.commentNic.setText(getGroup(groupPosition));
        viewHolder.commentContext.setText(getGroup(groupPosition));
        viewHolder.commentProfile.setImageResource(R.drawable.img_detailview_commenter2);

        return v;
    }

    @Override
    public String getChild(int groupPosition, int childPosition){
        return childList.get(groupPosition).get(childPosition);
    }

    @Override
    public int getChildrenCount(int groupPosition){
        return childList.get(groupPosition).size();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition){
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent){
        View v = convertView;

        if(v == null){
            viewHolder = new ViewHolder();
            v = inflater.inflate(R.layout.detail_item_comments, null);
            viewHolder.commentNic = (TextView)v.findViewById(R.id.comment_nic);
            viewHolder.commentContext = (TextView) v.findViewById(R.id.comment_contexts);
            v.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)v.getTag();
        }

        viewHolder.commentNic.setText(getChild(groupPosition, childPosition));
        viewHolder.commentContext.setText(getChild(groupPosition, childPosition));

        return v;
    }

    @Override
    public boolean hasStableIds(){return true;}

    @Override
    public boolean isChildSelectable(int groupPostion, int childPosition){return true;}



    class ViewHolder{
        public ImageView commentProfile;
        public TextView commentNic, cYear, cMonth, cDay,
                commentContext, recomments;
    }
}