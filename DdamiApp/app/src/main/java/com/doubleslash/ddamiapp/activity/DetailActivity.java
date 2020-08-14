package com.doubleslash.ddamiapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.adapter.CommentAdapter;
import com.doubleslash.ddamiapp.adapter.DetailImgAdapter;
import com.doubleslash.ddamiapp.model.CommentItem;
import com.doubleslash.ddamiapp.model.DetailImgItem;
import com.doubleslash.ddamiapp.model.DetailPieceCommentDAO;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DetailActivity extends AppCompatActivity {


    ImageButton detailBack, heart, etc, addComment;
    TextView detailCatagoly,detailTitle, detailNicname, viewCnt,heartCnt;
    ImageView detailProfile, commentProfile;//저작권 등 4이미지 추가
    LinearLayout pieceDetail; //작가가 설명하는 글 들어갈 자리
    EditText commentWrite;

    TextView detailText;
    RecyclerView detail_img_recyclerview;

    ExpandableListView commentView;
    RecyclerView recyclerView;


    @SuppressLint("CheckResult")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        detailBack=(ImageButton)findViewById(R.id.detail_back);
        heart=(ImageButton)findViewById(R.id.heart);
        etc=(ImageButton)findViewById(R.id.etc);
        detailCatagoly=(TextView)findViewById(R.id.detail_catagoly);
        detailTitle=(TextView)findViewById(R.id.detail_title);
        detailNicname=(TextView)findViewById(R.id.detail_nic);
        viewCnt=(TextView)findViewById(R.id.detail_viewCnt);
        heartCnt=(TextView)findViewById(R.id.detail_heartCnt);
        detailProfile=(ImageView)findViewById(R.id.detail_profile);
        commentProfile=(ImageView)findViewById(R.id.comment_profile);
        pieceDetail=(LinearLayout)findViewById(R.id.piece_deatil);
        addComment=(ImageButton)findViewById(R.id.add_comment);
        commentWrite=(EditText)findViewById(R.id.comment_write);



        detailText = (TextView) findViewById(R.id.detail_text);
        detail_img_recyclerview = (RecyclerView)findViewById(R.id.detail_img_recyclerview);


        JsonObject inputJson = new JsonObject();


        Intent intent = getIntent();
        String fileId = intent.getStringExtra("FileId");

        Log.d("진희: fileId 확인 ",fileId );
        ApiService.INSTANCE.getDetailPieceService().getDeatil(fileId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {

                            ArrayList<String> hasField = new ArrayList<>();
                            for(int i =0; i<it.getPiece().getHasField().size(); i++){
                                String fielditem = it.getPiece().getHasField().get(i);
                                hasField.add(fielditem);
                            }
                            Log.e("진희: hasField list ", hasField.toString());
                            detailCatagoly.setText(hasField.toString());
//                            String replace = detailCatagoly.getText().toString();
//                            replace = replace.replace("[","");
//                            replace = replace.replace("]","");
//                            replace = replace.replace(","," / ");

                            detailTitle.setText(it.getPiece().getTitle());

                            detailNicname.setText(it.getPiece().getAuthor().getUserId());

                            viewCnt.setText(String.valueOf(it.getPiece().getViews()));
                            heartCnt.setText(String.valueOf(it.getPiece().getLikeCount()));

                            //recyclerview 이미지 추가
                            recyclerView = (RecyclerView) findViewById(R.id.detail_img_recyclerview);

                            ArrayList<DetailImgItem> imgs = new ArrayList<>();

                            for(int i = 0; i<it.getPiece().getFileUrl().size(); i++){
                                String pieceUrl = it.getPiece().getFileUrl().get(i);
                                imgs.add(new DetailImgItem(pieceUrl));
                            }

                            RecyclerView.Adapter adapter = new DetailImgAdapter(imgs);
                            recyclerView.setAdapter(adapter);

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getApplicationContext(),LinearLayoutManager.HORIZONTAL,true);
                            recyclerView.setLayoutManager(linearLayoutManager);



                            detailText.setText(it.getPiece().getDescription());

                            Log.e("tttestlll",it.toString());

                            //comments
                            Log.e("tttest",it.toString());
                        },it -> {
                            Log.e("ffffailed",it.toString());
                        });






        //Intent intent2 = getIntent();

        String token = getIntent().getStringExtra("token");
        Toast.makeText(this,"token = " + token, Toast.LENGTH_LONG).show();

        Log.d("진희: token 확인 ",token );

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService.INSTANCE.getLikeTrueFalse().getBoolean(token, fileId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                it -> {
                                    Log.e("tttest",it.toString());
                                },it -> {
                                    Log.e("ffffailed",it.toString());
                                });
            }
        });


        detailBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //뒤록 가기
                onBackPressed();
            }
        });

        //\n이 있을 경우 줄바꿈
        String text = detailText.getText().toString();
        text = text.replace("\\\n", System.getProperty("line.separator"));



        //댓글 작성 버튼
        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //commentWrite.getText() 서버comments에 추가, 서버에서 불러와서 view에 추가
            }
        });



        commentView = (ExpandableListView)findViewById(R.id.comments_view);

        ArrayList<String> mGroupList = new ArrayList<String>();
        ArrayList<ArrayList<String>> mChildList = new ArrayList<ArrayList<String>>();
        ArrayList<String>  mChildListContent1 = new ArrayList<String>();
        ArrayList<String>  mChildListContent2 = new ArrayList<String>();
        ArrayList<String>  mChildListContent3 = new ArrayList<String>();

        /*댓글 sample data / 서버에서 불러오기  */


        //group에 content, child에 id
        mGroupList.add("지니");
        mGroupList.add("가옥");
        mGroupList.add("영환");

        mChildListContent1.add("멋지다");
        mChildListContent1.add("우와");
        mChildListContent1.add("안녕~~~");

        mChildListContent2.add("헉");
        mChildListContent2.add("예뻐요");
        mChildListContent2.add("하트각");

        mChildListContent3.add("팔아줘");
        mChildListContent3.add("잘해따");
        mChildListContent3.add("귀여워억");

        mChildList.add(mChildListContent1);
        mChildList.add(mChildListContent2);
        mChildList.add(mChildListContent3);

//        /********************************************************/
//
        commentView.setAdapter(new CommentAdapter(getApplicationContext(), mGroupList, mChildList));

        setExpandableListViewHeight(commentView, -1);

        commentView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(getApplicationContext(), "g click = " + groupPosition, Toast.LENGTH_SHORT).show();

                setExpandableListViewHeight(parent, groupPosition);

                return false;
            }
        });


        commentView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), "c click = " + childPosition,
                        Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        commentView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), "g Collapse = " + groupPosition,
                        Toast.LENGTH_SHORT).show();
            }
        });

        commentView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), "g Expand = " + groupPosition,
                        Toast.LENGTH_SHORT).show();
            }
        });

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
