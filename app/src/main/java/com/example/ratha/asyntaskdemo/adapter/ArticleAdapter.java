package com.example.ratha.asyntaskdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ratha.asyntaskdemo.R;
import com.example.ratha.asyntaskdemo.entity.Article;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ratha on 3/9/2018.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>{

    private List<Article> articles;
    private Context context;

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        this.notifyDataSetChanged();
    }

    public ArticleAdapter(Context context, List<Article> articles){
        this.context=context;
        this.articles=articles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.article_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article=articles.get(position);
        holder.image.setImageResource(article.getImage());
        holder.title.setText(article.getTitle());
        holder.date.setText(article.getDate());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView title;
        private TextView date;
        public ViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            title=itemView.findViewById(R.id.title);
            date=itemView.findViewById(R.id.date);
        }
    }

}
