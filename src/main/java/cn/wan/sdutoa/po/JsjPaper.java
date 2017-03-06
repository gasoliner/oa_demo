package cn.wan.sdutoa.po;

import java.util.Date;

public class JsjPaper {
    private String uuid;

    private String title;

    private String author;

    private String particpants;

    private Integer level;

    private Date publisheddate;

    private Integer type;

    private String volumeperiod;

    private String annex;

    private String schoolyear;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getParticpants() {
        return particpants;
    }

    public void setParticpants(String particpants) {
        this.particpants = particpants == null ? null : particpants.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getPublisheddate() {
        return publisheddate;
    }

    public void setPublisheddate(Date publisheddate) {
        this.publisheddate = publisheddate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getVolumeperiod() {
        return volumeperiod;
    }

    public void setVolumeperiod(String volumeperiod) {
        this.volumeperiod = volumeperiod == null ? null : volumeperiod.trim();
    }

    public String getAnnex() {
        return annex;
    }

    public void setAnnex(String annex) {
        this.annex = annex == null ? null : annex.trim();
    }

    public String getSchoolyear() {
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear == null ? null : schoolyear.trim();
    }
}