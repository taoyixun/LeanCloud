package com.xutaotao.leancloud;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.RequestPasswordResetCallback;
import com.avos.avoscloud.SignUpCallback;

public class SendActivity extends AppCompatActivity {

    private final int SEND_SUCCESSES = 1;
    private final int SEND_FAILURES = SEND_SUCCESSES + 1;

    private static String[] mContents = new String[]{};
    private static int mPosition;
    private static int mNumberOfSuccesses;
    private static int mNumberOfFailures;
    private EditText mEtContent;
    private TextView mTvPosition;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SEND_SUCCESSES:
                    // 注册成功
                    mNumberOfSuccesses++;
                    break;
                case SEND_FAILURES:
                    // 失败的原因可能有多种，常见的是用户名已经存在。
                    mNumberOfFailures++;
                    break;
            }

            updateNumber();
            mPosition++;
            if (mPosition <= mContents.length - 1) {
                send();
            } else {
                mTvPosition.setText(mTvPosition.getText() + "\n发送完成.");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        mEtContent = findViewById(R.id.content);
        mTvPosition = findViewById(R.id.position);

        updateNumber();
        if (mContents.length != 0) {
            for (String content : mContents) {
                mEtContent.setText(mEtContent.getText() + content + "\n");
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void updateNumber() {
        mTvPosition.setText(
                "发送：" + mEtContent.getLineCount() + "个\n" +
                        "成功:" + mNumberOfSuccesses + "\n" +
                        "失败:" + mNumberOfFailures);
    }

    private void send() {
        if (mContents.length == 0) {
            Toast.makeText(this, "请先读取数据！", Toast.LENGTH_LONG).show();
            return;
        }
        String s = mContents[mPosition] + "@qq.com";
        AVUser.logOut();
        AVUser user = new AVUser();
        user.setUsername(s);
        user.setPassword(s);
        user.setEmail(s);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    mHandler.sendEmptyMessageDelayed(SEND_SUCCESSES, 300);
                } else {
                    mHandler.sendEmptyMessageDelayed(SEND_FAILURES, 300);
                }
            }
        });
    }

    public void onSend(View view) {
        send();
    }

    public void onReadData(View view) {
        mPosition = mNumberOfSuccesses = mNumberOfFailures = 0;
        mContents = mEtContent.getText().toString().split("\n");
        updateNumber();
    }
}
