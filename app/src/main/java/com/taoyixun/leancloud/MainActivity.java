package com.taoyixun.leancloud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtUserName;
    private EditText mEtPassword;
    private Button mBtnLogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEtUserName = findViewById(R.id.username);
        mEtPassword = findViewById(R.id.password);
        mBtnLogin = findViewById(R.id.login);

        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                AVUser.logInInBackground(mEtUserName.getText().toString(), mEtPassword.getText().toString(), new LogInCallback<User>() {
                    @Override
                    public void done(User avUser, AVException e) {
                        if (avUser != null) {
                            boolean admin = avUser.getAdmin();
                            if (admin) {
                                startActivity(new Intent(MainActivity.this, SendActivity.class));
                            }
                        }
                    }
                }, User.class);
                break;
        }
    }
}
