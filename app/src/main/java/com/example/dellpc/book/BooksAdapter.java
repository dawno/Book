package com.example.dellpc.book;
import com.bumptech.glide.Glide;
import  android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder> {

    private Context mContext;
    private List<Books> booksList;

public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView title,price;
    public ImageView thumbnail, overflow;


    public MyViewHolder(View view) {
         super(view);
        title = (TextView) view.findViewById(R.id.title);
        price = (TextView) view.findViewById(R.id.count);
        thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        overflow = (ImageView) view.findViewById(R.id.overflow);
    }

}
    public BooksAdapter(Context mContext, List<Books> booksList) {
        this.mContext = mContext;
        this.booksList = booksList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_card, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
       Books books = booksList.get(position);
        holder.title.setText(books.getName());
        holder.price.setText(books.getPrice() + " pages");

        // loading album cover using Glide library
        Glide.with(mContext).load(books.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }
}
