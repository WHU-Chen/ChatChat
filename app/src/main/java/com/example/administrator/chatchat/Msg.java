package com.example.administrator.chatchat;

/**
 * Created by Administrator on 2015/8/23.
 */
public class Msg {
    final public static int TYPE_SEND=1;
    final public static int TYPE_RECEIVE=0;
    private int messegeType;
    private String content;
    public Msg(String content,int messegeType){
        this.content=content;
        this.messegeType=messegeType;
    }

    public int getMessegeType() {
        return messegeType;
    }

    public String getContent() {
        return content;
    }
}
