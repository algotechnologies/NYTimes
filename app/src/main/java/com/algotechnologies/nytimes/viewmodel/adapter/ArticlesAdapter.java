package com.algotechnologies.nytimes.viewmodel.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.algotechnologies.nytimes.databinding.ArticleBinding;
import com.algotechnologies.nytimes.model.dto.Article;
import com.algotechnologies.nytimes.viewmodel.contract.OnItemClickListener;

import java.util.List;

/**
 * Created by Saad Aftab on 14/07/2018.
 */
public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder> {

    private List<Article> articleList;
    private LayoutInflater layoutInflater;
    private OnItemClickListener clickListener;

    public ArticlesAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ArticleBinding articleBinding = ArticleBinding.inflate(layoutInflater, parent, false);
        return new ArticlesViewHolder(articleBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.bind(article);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public void setClickListener(OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ArticlesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ArticleBinding articleBinding;

        public ArticlesViewHolder(ArticleBinding articleBinding) {
            super(articleBinding.getRoot());

            this.articleBinding = articleBinding;
            this.itemView.setOnClickListener(this);
        }

        public void bind(Article article) {
            this.articleBinding.setArticleView(article);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onClick(v, getAdapterPosition());
        }

    }

}
