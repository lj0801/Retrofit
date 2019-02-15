package bwei.com.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity {



    private UserBeans userBeans;
    private EditText edit_phone;
    private EditText edit_pwd;
    private String phones;
    private String pwds;
    private UserApiService userApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        edit_phone = findViewById(R.id.edit_phone_register);

        edit_pwd = findViewById(R.id.edit_pwd_register);


    }

    public void bun_1(View  view) {
        //拿取输入的值
        phones = edit_phone.getText().toString();
        pwds = edit_pwd.getText().toString();
        //第一步创建retrofit管理者
        Retrofit  retrofit=new Retrofit.Builder()
                .baseUrl(MyApi.BASE_URL)//主机名
                .addConverterFactory(GsonConverterFactory.create())//数据解析式
                .build()
                ;
        //第二步事件接口
        userApiService = retrofit.create(UserApiService.class);

        //第三步
        //final Call<UserBeans>  register=userApiService.register("18612991022","111111");
        final Call<UserBeans>  register= userApiService.register( phones, pwds);
        //第四部请求
        register.enqueue(new Callback<UserBeans>() {
            @Override
            public void onResponse(Call<UserBeans> call, Response<UserBeans> response) {
                //响应提
                userBeans = response.body();
                if(userBeans.status.equals("0000")){

                    Toast.makeText(MainActivity.this,userBeans.message,Toast.LENGTH_LONG).show();

                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                }else{
                    Toast.makeText(MainActivity.this,userBeans.message,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserBeans> call, Throwable t) {
            }
        });


    }
    public   void     bun_2(View  view){
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }
}
