package bwei.com.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import bwei.com.retrofit.Api.MyApi;
import bwei.com.retrofit.Api.UserApiService;
import bwei.com.retrofit.Beans.UserBeans;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private EditText edit_phone;
    private EditText edit_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //创建初始化控件方法
        createinit();
    }

    private void createinit() {
        edit_phone = findViewById(R.id.edit_phone);
        edit_pwd = findViewById(R.id.edit_pwd);
    }
    public  void     bun_login(View  view){
       //拿到获取的值
        String phone = edit_phone.getText().toString();
        String pwd = edit_pwd.getText().toString();
        //第一步拿到retrofit的管理者
        Retrofit    retrofit=new Retrofit.Builder().baseUrl(MyApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        //第二步创建接口
        UserApiService   userApiService=retrofit.create(UserApiService.class);
        //第三部请求post数据
        final Call<UserBeans>   login=userApiService.login(phone,pwd) ;
        //第四部利用retrofit请求
        login.enqueue(new Callback<UserBeans>() {
            @Override
            public void onResponse(Call<UserBeans> call, Response<UserBeans> response) {
                UserBeans  userBeans=response.body();
                if(userBeans.status.equals("0000")){
                    Toast.makeText(LoginActivity.this,userBeans.message,Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this,SearchActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this,userBeans.message,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserBeans> call, Throwable t) {

            }
        });
    }
}
