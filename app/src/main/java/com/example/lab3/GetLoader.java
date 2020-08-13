package com.example.lab3;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetLoader extends AsyncTask<String,String,String> {
    List<About> getList = new ArrayList<>();
    RecyclerView recyclerView;
    Adapter adapter;
    Context context;

    public GetLoader(RecyclerView recyclerView, Context context) {
        this.recyclerView = recyclerView;
        this.context = context;
    }

    @Override
    protected String doInBackground(String... search) {
        String data = "";
        try {
            String Link = "http://dotplays.com/wp-json/wp/v2/search?search=" + URLEncoder.encode(search[0], "UTF-8") + "&_embed";
            URL url = new URL(Link);
            // kết nối đến máy chủ
            HttpURLConnection httpURLConnection = (HttpURLConnection)
                    url.openConnection();

            // read FILE từ link
            InputStream inputStream = httpURLConnection.getInputStream();
            // nhập, xuất dữ liệu ( read file từ inputstream )
            Scanner scanner = new Scanner(inputStream);
            // kiểm tra read token = từ có nghĩa trong String
            while (scanner.hasNext()){
                // read String
                data += scanner.nextLine();
            }
            // Đóng kết nối
            scanner.close();
            inputStream.close();
            httpURLConnection.disconnect();

        } catch (Exception e) {
            Log.e("abc",e.getMessage());
        }
        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try{
            JSONArray jsonArray = new JSONArray(s);
            for(int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
               String titles = jsonObject.getString("title");
               String url = jsonObject.getString("url");
               // addd list
                About get = new About();
                get.title = titles;
                get.date = "15/07/2020";
                get.url = url;
                getList.add(get);
            }
            adapter = new Adapter(context,recyclerView, getList);
            recyclerView.setAdapter(adapter);
        }
        catch (Exception e){

        }
    }
}

