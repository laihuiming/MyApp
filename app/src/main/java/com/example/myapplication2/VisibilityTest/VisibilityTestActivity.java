package com.example.myapplication2.VisibilityTest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.myapplication2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
@Route(path = "/app/VisibilityTestActivity")
public class VisibilityTestActivity extends Activity {
    private static final String TAG = "VisibilityTestActivity";
    @BindView(R.id.tv_msg1)
    TextView tvMsg1;
    @BindView(R.id.tv_unread_msg1)
    TextView tvUnreadMsg1;
    @BindView(R.id.tv_msg2)
    TextView tvMsg2;
    @BindView(R.id.tv_unread_msg2)
    TextView tvUnreadMsg2;
    @BindView(R.id.tv_msg3)
    TextView tvMsg3;
    @BindView(R.id.tv_unread_msg3)
    TextView tvUnreadMsg3;
    @BindView(R.id.tv_msg4)
    TextView tvMsg4;
    @BindView(R.id.tv_unread_msg4)
    TextView tvUnreadMsg4;
    int msg = 1;
    private int run(){
        msg = msg+1;
        return msg;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visibility_test);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.tv_msg1, R.id.tv_msg2, R.id.tv_msg3, R.id.tv_msg4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_msg1:
                int unreadmsg = msg;
                tvUnreadMsg1.setVisibility(unreadmsg>0?View.VISIBLE:View.INVISIBLE);
                tvUnreadMsg1.setText(unreadmsg+"");
                if (unreadmsg>99){
                    tvUnreadMsg1.setText("99+");
                }
                break;
            case R.id.tv_msg2:
                int unreadmsg2 = 120;
                tvUnreadMsg2.setVisibility(unreadmsg2>0?View.VISIBLE:View.INVISIBLE);
                tvUnreadMsg2.setText(unreadmsg2+"");
                if (unreadmsg2>99){
                    tvUnreadMsg2.setText("99+");
                }
                break;
            case R.id.tv_msg3:
                int unreadmsg3 = msg;
                tvUnreadMsg3.setVisibility(unreadmsg3>0?View.VISIBLE:View.INVISIBLE);
                tvUnreadMsg3.setText(unreadmsg3+"");
                if (unreadmsg3>99){
                    tvUnreadMsg3.setText("99+");
                }
                run();
                Log.e(TAG,"UnReadMsg3:"+unreadmsg3);
                break;
            case R.id.tv_msg4:
                int unreadmsg4 = msg;
                tvUnreadMsg4.setVisibility(unreadmsg4>0?View.VISIBLE:View.GONE);
                tvUnreadMsg4.setText(unreadmsg4+"");
                if (unreadmsg4>99){
                    tvUnreadMsg4.setText("99+");
                }
                run();
                Log.e(TAG,"UnReadMsg4:"+unreadmsg4);
                break;
        }
    }
}
