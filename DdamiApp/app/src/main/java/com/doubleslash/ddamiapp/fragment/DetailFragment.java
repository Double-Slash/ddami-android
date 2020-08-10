package com.doubleslash.ddamiapp.fragment;

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

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.MainActivity;
import com.doubleslash.ddamiapp.adapter.CommentAdapter;
import com.doubleslash.ddamiapp.model.DetailPieceDAO;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.doubleslash.ddamiapp.network.kotlin.DetailPieceApi;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DetailFragment extends Fragment {


    ImageButton detailBack, heart, etc, addComment;
    TextView detailCatagoly,detailTitle, detailNicname, viewCnt,heartCnt;
    ImageView detailProfile, commentProfile;//저작권 등 4이미지 추가
    LinearLayout pieceDetail; //작가가 설명하는 글 들어갈 자리
    EditText commentWrite;

    TextView detailText;
    RecyclerView detail_img_recyclerview;

    private ArrayList<String> mGroupList = null;
    private ArrayList<ArrayList<String>> mChildList = null;
    private ArrayList<String> mChildListContent = null;
    ExpandableListView commentView;


    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성
    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @SuppressLint("CheckResult")
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
        addComment=(ImageButton)view.findViewById(R.id.add_comment);
        commentWrite=(EditText)view.findViewById(R.id.comment_write);



        detailText = (TextView) view.findViewById(R.id.detail_text);
        detail_img_recyclerview = (RecyclerView) view.findViewById(R.id.detail_img_recyclerview);


//작품 등록 또는 메인의 아이템 누르면
        JsonObject inputJson = new JsonObject();
            /*
            inputJson.put("result", id);     //0,1
            inputJson.put("obj", pw);       //작품
                inputJson.put("fileUrl",);          //imagelist
                inputJson.put("comments",);         //댓글 배열
                inputJson.put("hasField",);         //분야(카테고리) 배열
                inputJson.put("views",);         //조회수
                inputJson.put("like",);         //좋아요 누른 사람 기본키 배열//heart 누르면 여기에 추가
                inputJson.put("likeCount",);         //좋아요 수
                inputJson.put("_id",);         //??
                inputJson.put("title",);         //제목
                inputJson.put("description",);         //내용
                inputJson.put("author",);         //작가
                    inputJson.put("_id",);         //작가 아이디
                    inputJson.put("userNickname",);         //작가 닉네임
                inputJson.put("created",);         //등록 시간
                inputJson.put("likeByUser",);         //내가 좋아요 눌렀는지 아닌지
             */
            /*
        inputJson.get("result");

        inputJson.get("obj");
        inputJson.get("fileUrl");       //imgList //recyclerview에 추가
        inputJson.get("comments");      //댓글 배열
        inputJson.get("hasField");      //분야(카테고리) 배열 // detailCatagoly
        inputJson.get("views");         //조회수   //viewCnt
        inputJson.get("like");          //좋아요 누른 사람 기본키 배열
        inputJson.get("likeCount");     //좋아요 수     //heartCnt
        inputJson.get("_id");           //사용자 기본키
        inputJson.get("title");                     //detailTitle
        inputJson.get("description");   //내용        //detailText

        inputJson.get("author");
        inputJson.get("_id");           //작가 기본키
        inputJson.get("userNickname");  //작가 닉네임    //detailNicname

        inputJson.get("created");       //등록 시간
        inputJson.get("likeByUser");    //좋아요 true false

             */

        //    Single<DetailPieceDAO> deatil = DetailPieceApi.getDeatil(inputJson);



        ApiService.INSTANCE.getDetailPieceService().getDeatil(inputJson)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {
                           // detailCatagoly.setText(it.getPiece().getHasField());  //list로
                            detailTitle.setText(it.getPiece().getTitle());

                            detailNicname.setText(it.getPiece().getAuthor().getUserNickname());
                            viewCnt.setText(it.getPiece().getViews());
                            heartCnt.setText(it.getPiece().getLikeCount());

                            //recyclerview 이미지 추가

                            detailText.setText(it.getPiece().getDescription());

                            //comments
                            Log.e("tttest",it.toString());
                        },it -> {
                                Log.e("failed",it.toString());
                        });





        detailBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //뒤록 가기
            }
        });

        //\n이 있을 경우 줄바꿈
        String text = detailText.getText().toString();
        text = text.replace("\\\n", System.getProperty("line.separator"));

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //누르면 fullHeart로
                //작품 상세보기 like배열에 사용자 기본키 저장
                //작품 상세보기 likeCount++, 사용자 상세보기 like++ == heartCnt
                //작품 상세보기 likeByMe = true
            }
        });

        //댓글 작성 버튼
        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //commentWrite.getText() 서버comments에 추가, 서버에서 불러와서 view에 추가
            }
        });



        commentView = (ExpandableListView)view.findViewById(R.id.comments_view);

        mGroupList = new ArrayList<String>();
        mChildList = new ArrayList<ArrayList<String>>();
        mChildListContent = new ArrayList<String>();

        /*댓글 sample data / 서버에서 불러오기  */
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
