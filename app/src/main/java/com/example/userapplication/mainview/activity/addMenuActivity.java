package com.example.userapplication.mainview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.userapplication.R;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;


public class addMenuActivity extends AppCompatActivity {
    private ArrayList<Dictionary> mArrayList;
    private CustomAdapter mAdapter;
    private int count = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmenu);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main_list);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        //리사이클러뷰에 LinerlayoutManger지정 (vertical)
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mArrayList = new ArrayList<>();

        //리사이클러뷰에 adapter 객체 지정
        //mAdapter = new CustomAdapter(mArrayList);
        mAdapter = new CustomAdapter(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        //항목 터치시 내부로 들어가기
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Dictionary dict = mArrayList.get(position);
                Intent intent = new Intent(getBaseContext(), addMenuResultActivity.class);

                intent.putExtra("id", dict.getId());
                intent.putExtra( "korean", dict.getKorean());
                intent.putExtra("english", dict.getEnglish());

                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

        Button buttonInsert = (Button) findViewById(R.id.button_main_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() { //데이터 추가 버튼 클릭시
            @Override
            public void onClick(View v) {

                //레이아웃 파일 edit_box.xml을 불러와 화면에 다이얼로그를 보여준다.
                AlertDialog.Builder builder = new AlertDialog.Builder(addMenuActivity.this);
                View view = LayoutInflater.from(addMenuActivity.this).inflate(R.layout.addmenu_edit_box,null,false);
                builder.setView(view);

                final Button submitButton = (Button) view.findViewById(R.id.button_dialog_submit);
                final EditText editTextID = (EditText) view.findViewById(R.id.edittext_dialog_id);
                final EditText editTextEnglish = (EditText) view.findViewById(R.id.edittext_dialog_endlish);
                final EditText editTextKorean = (EditText) view.findViewById(R.id.edittext_dialog_korean);

                submitButton.setText("항목 추가");

                final AlertDialog dialog = builder.create();

                //다이얼로그에 있는 항목 추가 버튼을 클릭시
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //사용자가 입력한 내용을 가져옴
                        String strID = editTextID.getText().toString();
                        String strEnglish = editTextEnglish.getText().toString();
                        String strKorean = editTextKorean.getText().toString();

                        //ArrayList에 추가하기
                        Dictionary dic = new Dictionary(strID, strEnglish, strKorean);
                        mArrayList.add(0, dic); //RecyclerView의 첫 줄에 삽입
                        //mArrayList.add(dic); // RecyclerView의 마지막 줄에 삽입

                        //어댑터에서 RecycleView에 반영하도록 설정
                        mAdapter.notifyItemInserted(0);
                        //mAdapter.notifyDataSetChanged();

                        dialog.dismiss();
                    }
                });
               dialog.show();
            }
        });
    }
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private addMenuActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final addMenuActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
}


