package com.lingy.lawei.weibo.api;
import com.lingy.lawei.weibo.bean.PostComments;
import com.lingy.lawei.weibo.bean.Status;
import com.lingy.lawei.weibo.bean.StatusList;
import com.lingy.lawei.weibo.bean.User;
import com.lingy.lawei.weibo.bean.UserList;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Werb on 2016/7/26.
 * Werb is Wanbo.
 * Contact Me : werbhelius@gmail.com
 * get WeiBo with retrofit
 */
public interface WeiBoApi {
    @GET("statuses/user_timeline.json")
    Observable<StatusList> getUserTimeLine(@QueryMap Map<String,Object> params);

    @GET("users/show.json")
    Observable<User> getUserInfo(@QueryMap Map<String, String> params);

    @GET("friendships/friends.json")
    Observable<UserList> getFriendsById(@QueryMap Map<String, Object> params);

    @GET("friendships/followers.json")
    Observable<UserList> getFollowersById(@QueryMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("search/users.json")
    Observable<UserList> searchUsers(@FieldMap Map<String,Object> params);

    @FormUrlEncoded
    @POST("comments/create.json")
    Observable<PostComments> setComment(@FieldMap Map<String, Object> params);

    @Multipart
    @POST("statuses/upload.json")
    Observable<Status> sendWeiBoWithImg(
            @Part("access_token") RequestBody accessToken,
            @Part("status") RequestBody context,
            @Part("pic\";filename=\"file") RequestBody requestBody);

    @FormUrlEncoded
    @POST("statuses/update.json")
    Observable<Status> sendWeiBoWithText(@FieldMap Map<String, Object> params);
}
