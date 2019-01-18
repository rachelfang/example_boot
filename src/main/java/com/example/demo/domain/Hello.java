package com.example.demo.domain;

/**
 * Created by fangjing on 2019/1/15.
 */
public class Hello {

    private final long id;
    private final String content;
    private  final String name;

    public Hello(long id, String content, String name) {
        this.id = id;
        this.content = content;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getName()
    {
        return name;
    }
}