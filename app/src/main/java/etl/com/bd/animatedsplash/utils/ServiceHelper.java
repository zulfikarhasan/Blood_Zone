package etl.com.bd.animatedsplash.utils;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Zulfikar on 10/28/2016.
 */

public class ServiceHelper extends Application {
    private RequestQueue requestQueue;
    private static ServiceHelper instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized ServiceHelper getInstance(){
        return  instance;
    }

    public RequestQueue getRequestQueue(){

        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }
    public  void  addToRequest(Request request){
        getRequestQueue().add(request);
    }
}
