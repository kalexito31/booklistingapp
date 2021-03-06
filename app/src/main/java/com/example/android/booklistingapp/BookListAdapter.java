package com.example.android.booklistingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import static android.text.TextUtils.join;


/**
 * Created by Kevin on 6/18/2017.
 */

public class BookListAdapter extends ArrayAdapter<Book> {

    public BookListAdapter(Context context, List<Book> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.book_item, parent, false);
        }

        Book currentBook = getItem(position);

        //Set title for the book
        TextView titleView = (TextView) listItemView.findViewById(R.id.book_title);
        titleView.setText(currentBook.getBookTitle());

        //Set authors for the book
        TextView authorView = (TextView) listItemView.findViewById(R.id.book_authors);
        String authors = join(", ", currentBook.getBookAuthors());
        authorView.setText(authors);

        //Set description for the book
        TextView descriptionView = (TextView) listItemView.findViewById(R.id.book_description);
        descriptionView.setText(currentBook.getBookDescription());

        //Set book image
        ImageView thumbnailView = (ImageView) listItemView.findViewById(R.id.book_image);
        Glide.with(getContext()).load(currentBook.getBookThumbnailLink()).into((ImageView) thumbnailView);

        return listItemView;
    }
}
