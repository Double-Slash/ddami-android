package com.doubleslash.ddamiapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.doubleslash.ddamiapp.R;

import java.util.ArrayList;

public class DetailFragment extends Fragment {


    ImageButton detailBack, heart, etc;
    TextView detailCatagoly,detailTitle, detailNicname, viewCnt,heartCnt;
    ImageView detailProfile, commentProfile;//저작권 등 4이미지 추가
    LinearLayout pieceDetail //작가가 설명하는 글 들어갈 자리
            , addComment; //댓글 작성 버튼
    EditText commentWrite;

    private ArrayList<String> mGroupList = null;
    private ArrayList<ArrayList<String>> mChildList = null;
    private ArrayList<String> mChildListContent = null;
    ExpandableListView commentView;


    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성
    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);


        detailBack=(ImageButton)view.findViewById(R.id.detail_back);
        heart=(ImageButton)view.findViewById(R.id.heart);
        etc=(ImageButton)view.findViewById(R.id.etc);
        detailCatagoly=(TextView)view.findViewById(R.id.detail_catagoly);
        detailTitle=(TextView)view.findViewById(R.id.detail_title);
        detailNicname=(TextView)view.findViewById(R.id.detail_nic);
        viewCnt=(TextView)view.findViewById(R.id.detail_viewCnt);
        heartCnt=(TextView)view.findViewById(R.id.detail_heartCnt);
        detailProfile=(ImageView)view.findViewById(R.id.detail_profile);
        commentProfile=(ImageView)view.findViewById(R.id.comment_profile);
        pieceDetail=(LinearLayout)view.findViewById(R.id.piece_deatil);
        addComment=(LinearLayout)view.findViewById(R.id.add_comment);
        commentWrite=(EditText)view.findViewById(R.id.comment_write);

        detailBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //뒤록 가기
            }
        });

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //누르면 fullHeart로 -> 좋아요 목록에 추가
                //heartCnt++
            }
        });

        //댓글 작성 버튼
        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //commentWrite.getText() 서버에 추가, 서버에서 불러와서 view에 추가
            }
        });



        commentView = (ExpandableListView)view.findViewById(R.id.comments_view);

        mGroupList = new ArrayList<String>();
        mChildList = new ArrayList<ArrayList<String>>();
        mChildListContent = new ArrayList<String>();

        /*sample data / 서버에서 불러오기  */
        mGroupList.add("a");
        mGroupList.add("b");
        mGroupList.add("c");

        mChildListContent.add("1");
        mChildListContent.add("2");
        mChildListContent.add("3");

        mChildList.add(mChildListContent);
        mChildList.add(mChildListContent);
        mChildList.add(mChildListContent);

        /********************************************************/

        commentView.setAdapter(new CommentAdapter(getActivity(), mGroupList, mChildList));

        setExpandableListViewHeight(commentView, -1);

        commentView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(getActivity(), "g click = " + groupPosition, Toast.LENGTH_SHORT).show();

                setExpandableListViewHeight(parent, groupPosition);

                return false;
            }
        });


        commentView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(), "c click = " + childPosition,
                        Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        commentView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity(), "g Collapse = " + groupPosition,
                        Toast.LENGTH_SHORT).show();
            }
        });

        commentView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(), "g Expand = " + groupPosition,
                        Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    private void setExpandableListViewHeight(ExpandableListView listView,
                                             int group) {
        CommentAdapter listAdapter = (CommentAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }

}
