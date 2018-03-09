package com.example.ratha.asyntaskdemo;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ratha.asyntaskdemo.adapter.ArticleAdapter;
import com.example.ratha.asyntaskdemo.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArticleAdapter articleAdapter;
    RecyclerView recyclerView;
    List<Article> articles=new ArrayList<>();
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
        recyclerView=findViewById(R.id.rvArticle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        articleAdapter=new ArticleAdapter(this,articles);
        recyclerView.setAdapter(articleAdapter);

        new ArticleAsyncTask().execute();
    }

    private List<Article> getArticles(){
        List<Article> articles=new ArrayList<>();
        for (int i=0; i<=50 ;i++){
            articles.add(new Article("លេង\u200Bខ្លួន\u200Bមិន\u200Bចាញ់ iPhone X ម៉ាក\u200Bថ្មី\u200Bពី Oppo ធ្លាយ\u200Bរូបរាង\u200Bឲ្យ\u200Bច្បាស់\u200Bក្រឡែត",
                    " ថ្ងៃនេះ ម៉ោង 18:25",R.drawable.rathana_face_become_girl));
        }
        return articles;
    }

    class ArticleAsyncTask extends AsyncTask<Void,Article,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected String doInBackground(Void... voids) {
            getArticles().forEach(article->{
                publishProgress(article);
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "get Article successful";
        }

        @Override
        protected void onProgressUpdate(Article... values) {
            articles.add(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            showMessage(s);
            articleAdapter.notifyDataSetChanged();
            progressBar.setVisibility(ProgressBar.INVISIBLE);

        }

    }

    void  showMessage(String s){
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
}
