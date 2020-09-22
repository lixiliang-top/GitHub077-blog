package cn.kgc.ssm.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Blog {
    private Integer id;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishtime;

    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}