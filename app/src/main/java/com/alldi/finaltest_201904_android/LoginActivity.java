package com.alldi.finaltest_201904_android;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alldi.finaltest_201904_android.databinding.ActivityLoginBinding;
import com.alldi.finaltest_201904_android.utils.ConnectServer;
import com.alldi.finaltest_201904_android.utils.ContentUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.zip.Inflater;

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

                                        if (act.autoCheckBox.isChecked()){
                                            ContentUtil.setUserToken(mContect, token);
                                        }

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

    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);

    }

}
