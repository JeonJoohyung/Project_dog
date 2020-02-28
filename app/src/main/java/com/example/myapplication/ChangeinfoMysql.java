package com.example.myapplication;

import android.os.Handler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChangeinfoMysql extends Thread{
    public static boolean active=false;

    Handler mHandler;
    String userId=null,userPw=null,url=null;
    String login_url="뭐시기뭐시기?id=";

    public ChangeinfoMysql(String id){
        mHandler=new Handler();
        userId=id;
        url=login_url+userId;
    }

    @Override
    public void run() {
        super.run();
        if(active){
            StringBuilder jsonHtml = new StringBuilder();
            try {
                URL phpUrl = new URL(url);

                HttpURLConnection conn = (HttpURLConnection)phpUrl.openConnection();
                if ( conn != null ) {
                    conn.setConnectTimeout(10000);
                    conn.setUseCaches(false);
                    if ( conn.getResponseCode() == HttpURLConnection.HTTP_OK ) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                        while ( true ) {
                            String line = br.readLine();
                            if ( line == null )
                                break;
                            jsonHtml.append(line + "\n");
                        }
                        br.close();
                    }
                    conn.disconnect();
                }
            } catch ( Exception e ) {
                e.printStackTrace();
            }
            show(jsonHtml.toString());
        }
    }

    void show(final String result){
        mHandler.post(new Runnable(){
            @Override
            public void run() {
                try {
                    JSONObject jObject = new JSONObject(result);

                    String getpw =jObject.get("USER_PASS").toString();
                    String getname=jObject.get("USER_NAME").toString();
                    String getage =jObject.get("USER_AGE").toString();
                    Changeinfo.set_text(getpw,getname,getage);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Changeinfo.set_text("false","flase","false");
                }
            }
        });
    }
}
