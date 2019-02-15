package bwei.com.retrofit.Api;


import bwei.com.retrofit.Beans.SearchBeans;
import bwei.com.retrofit.Beans.ShopBean;
import bwei.com.retrofit.Beans.UserBeans;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserApiService    {

      @POST("small/user/v1/register")
      @FormUrlEncoded
      Call<UserBeans>  register (@Field("phone") String  mobile,@Field("pwd") String p);
      @GET("small/user/v1/register")
      Call<UserBeans> re(@Query("phone") String mobile,@Query("pwd") String  p );

      @POST("small/user/v1/login")
      @FormUrlEncoded
      Call<UserBeans>   login (@Field("phone") String  mobile,@Field("pwd") String p);
      @GET("small/commodity/v1/commodityList")
      Call<ShopBean>  shoplist();
      @GET("small/commodity/v1/findCommodityByKeyword")
      Call<SearchBeans>  search(@Query("keyword")String keyword, @Query("page")String page, @Query("count")String count);

}
