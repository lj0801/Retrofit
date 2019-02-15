package bwei.com.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import bwei.com.retrofit.Api.MyApi;
import bwei.com.retrofit.Api.UserApiService;
import bwei.com.retrofit.Beans.ShopBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);






    }

    public  void     click_one(View  view){
          //第一步创建管理器
        Retrofit    retrofit=new Retrofit.Builder().baseUrl(MyApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //第二步创建接口
        UserApiService   userApiService=retrofit.create(UserApiService.class);
        final Call<ShopBean>   shoplist=userApiService.shoplist();
        shoplist.enqueue(new Callback<ShopBean>() {
            @Override
            public void onResponse(Call<ShopBean> call, Response<ShopBean> response) {

                 ShopBean  shopBean=response.body();
               //吐司内容
                Toast.makeText(ShowActivity.this,shopBean.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ShopBean> call, Throwable t) {

            }
        });

    }



}
