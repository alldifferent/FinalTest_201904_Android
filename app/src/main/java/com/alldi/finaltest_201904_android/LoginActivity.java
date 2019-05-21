package com.alldi.finaltest_201904_android;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alldi.finaltest_201904_android.databinding.ActivityLoginBinding;
import com.alldi.finaltest_201904_android.utils.ConnectServer;
import com.alldi.finaltest_201904_android.utils.ContentUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity {

    ActivityLoginBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        act.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String user_Id = act.userIdEdt.getText().toString();
                String password = act.passwordEdt.getText().toString();

                ConnectServer.postRequestLogin(mContect, user_Id, password, new ConnectServer.JsonHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                try {
                                    int code = json.getInt("code");



                                    if (code == 200){

                                        JSONObject data = json.getJSONObject("data");
                                        String token = data.getString("token");


                                        ContentUtil.setUserToken(mContect, token);


                                        Intent intent = new Intent(mContect, MainActivity.class);
                                        intent.putExtra("token", token);
                                        startActivity(intent);
                                        finish();


                                    }else {

                                        String message = json.getString("message");
                                        Toast.makeText(mContect, message, Toast.LENGTH_SHORT).show();

                                    }



                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                                
                            }
                        });
                        
                    }
                });
                
            }
        });
    }

    @Override
    public void setValues() {



        String saveToken = ContentUtil.getUserToken(mContect);
//        if (saveToken != null){
//            Intent intent = new Intent(mContect, MainActivity.class);
//            intent.putExtra("token", saveToken);
//            startActivity(intent);
//            finish();
//        }

    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }
}
