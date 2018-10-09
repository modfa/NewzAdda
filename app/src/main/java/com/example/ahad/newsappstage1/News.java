package com.example.ahad.newsappstage1;

public class News {
    private String mSectionName;
    private String mNewsPublicationDate;
    private String mNewsTitle;
    private String mNewsUrl;
    private String mAuthorName;


    /**
     * Constructs a new {@link News} object.
     *
     * @param mSectionName         is the Section name of according to the news
     * @param mNewsPublicationDate is the news/article publication date
     * @param mNewsTitle           is the main title of the news.
     * @param mNewsUrl             is the url of the news
     */
    public News(String mSectionName, String mNewsPublicationDate, String mNewsTitle, String mNewsUrl, String mAuthorName) {
        this.mSectionName = mSectionName;
        this.mNewsPublicationDate = mNewsPublicationDate;
        this.mNewsTitle = mNewsTitle;
        this.mNewsUrl = mNewsUrl;

        this.mAuthorName = mAuthorName;
    }

    /**
     * Returns the news section.
     */
    public String getmSectionName() {
        return mSectionName;
    }

    /**
     * Returns the news publication date about the news.
     */

    public String getmNewsPublicationDate() {
        return mNewsPublicationDate;
    }

    /**
     * Returns the news title about the news.
     */
    public String getmNewsTitle() {
        return mNewsTitle;
    }

    /**
     * Returns the website URL to find more information about the news/article.
     */
    public String getmNewsUrl() {
        return mNewsUrl;
    }

    /**
     * Returns the author name of the news/article.
     */
    public String getmAuthorName() {
        return mAuthorName;
    }
}