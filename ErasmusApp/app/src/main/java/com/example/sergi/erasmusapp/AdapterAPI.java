//package com.example.sergi.erasmusapp;
//
///**
// * Created by Sergi on 30/12/2017.
// */
//
//import com.android.volley.AuthFailureError;
//import com.android.volley.Cache;
//import com.android.volley.NetworkResponse;
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.toolbox.HttpHeaderParser;
//import com.android.volley.toolbox.ImageLoader;
//import com.android.volley.toolbox.JsonArrayRequest;
//import com.android.volley.toolbox.JsonObjectRequest;
//
//import org.json.JSONObject;
//
//import java.io.UnsupportedEncodingException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class AdapterAPI {
//
//
//    public void GETRequestAPI(String url, Response.Listener responseListener, Response.ErrorListener errorListener, final Map<String,String> headers){
//        String  REQUEST_TAG = "com.androidtutorialpoint.volleyJsonObjectRequest";
//        JsonObjectRequest jsonObjectReq = new JsonObjectRequest(Request.Method.GET, url, null, responseListener, errorListener) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String>  params = new HashMap<String, String>();
//                params = headers;
//                return params;
//            }
//        };
//        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectReq,REQUEST_TAG);
//    }
//
//
//
//    public void GETJsonArrayRequestAPI(String url, Response.Listener responseListener, Response.ErrorListener errorListener, final Map<String, String> headers){
//        String  REQUEST_TAG = "com.androidtutorialpoint.volleyJsonArrayRequest";
//
//        JsonArrayRequest jsonArrayReq = new JsonArrayRequest(Request.Method.GET, BASE_URL+url, null, responseListener, errorListener){
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String>  params = new HashMap<>();
//                params = headers;
//                return params;
//            }
//        };
//        // Adding JsonObject request to request queue
//        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayReq, REQUEST_TAG);
//    }
//
//}
