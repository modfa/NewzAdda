package com.example.ahad.newsappstage1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class NewsAdapter extends ArrayAdapter<News> {
    private static final String TIME_DATE_SEPARATOR = "T";
    private String currentDate;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param news           A List of News objects to display in a list
     */
    public NewsAdapter(Activity context, ArrayList<News> news) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a Listview.
        // Because this is a custom adapter for the four TextViews , the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, news);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news article at the given position in the list of news.
        News currentNews = getItem(position);

        // Find the TextView with view ID news_title
        TextView newsTitleView =  listItemView.findViewById(R.id.news_title);
        // Get the news title atribute
        String currentNewsTitle = currentNews.getmNewsTitle();
        // Display the Title of the current news article in that TextView
        newsTitleView.setText(currentNewsTitle);

        // Find the TextView with view ID section_name
        TextView sectionNameView =  listItemView.findViewById(R.id.section_name);
        // Get the news section atribute
        String currentNewsSection = currentNews.getmSectionName();
        // Display the Section of the current news article in that TextView
        sectionNameView.setText(currentNewsSection);

        // Find the TextView with view ID article_date
        TextView newsDateView =  listItemView.findViewById(R.id.article_date);

        String currentNewsPublicationDate = currentNews.getmNewsPublicationDate();
        // we need to seperate the time and date
        if(currentNewsPublicationDate.contains(TIME_DATE_SEPARATOR)){
            String [] dataAndTime = currentNewsPublicationDate.split(TIME_DATE_SEPARATOR);
            currentDate = dataAndTime[0];
        }
        // Display the Date of the current news article in that TextView
        newsDateView.setText(currentDate);

        // Find the TextView with view ID author_name
        TextView authorNameView = listItemView.findViewById(R.id.author_name);
        // Get the news publication author name attribute
        String authorName = currentNews.getmAuthorName();
        // Checking if the authorName string is empty
        if(authorName.isEmpty()){
            authorNameView.setText(R.string.no_author);
        }
        else{
        authorNameView.setText(authorName);}
        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}