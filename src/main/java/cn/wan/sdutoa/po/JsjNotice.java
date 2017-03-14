package cn.wan.sdutoa.po;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class JsjNotice {
    private String uuid;

    private String title;

    private String content;

    private String user;

    @JSONField(format = "yyyy-MM-dd")
    private Date begindate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    @Override
    public String toString() {
        return "JsjNotice{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user='" + user + '\'' +
                ", begindate=" + begindate +
                '}';
    }
}