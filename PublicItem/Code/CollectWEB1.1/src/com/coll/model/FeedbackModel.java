package com.coll.model;

/**
*@author:liwengbincoll@foxmail.com
*@date:2017/10/22 0022 14:39
*@explain:�������������Ϣʵ����
*/
public class FeedbackModel {
    private String feed_id;
    private String user_email;
    private String feed_content;//����������
    private Integer feed_size;//�����Ĵ���

    public String getFeed_id() {
        return feed_id;
    }

    public void setFeed_id(String feed_id) {
        this.feed_id = feed_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getFeed_content() {
        return feed_content;
    }

    public void setFeed_content(String feed_content) {
        this.feed_content = feed_content;
    }

    public Integer getFeed_size() {
        return feed_size;
    }

    public void setFeed_size(Integer feed_size) {
        this.feed_size = feed_size;
    }

    public FeedbackModel() {
        super();
    }

    /**
     *@path:com.coll.model/FeedbackModel
     *@parame:[feed_id, user_email, feed_content, feed_size]
     *@return:[]
     */
    public FeedbackModel(String feed_id, String user_email, String feed_content, Integer feed_size) {
        super();
        this.feed_id = feed_id;
        this.user_email = user_email;
        this.feed_content = feed_content;
        this.feed_size = feed_size;
    }

    @Override
    public String toString() {
        return "FeedbackModel{" +
                "feed_id='" + feed_id + '\'' +
                ", user_email='" + user_email + '\'' +
                ", feed_content='" + feed_content + '\'' +
                ", feed_size=" + feed_size +
                '}';
    }
}
