package cn.wan.sdutoa.po;

public class JsjAwards {
    private Long aid;

    private Integer competitionid;

    private Integer level;

    private Integer grade;

    private String specialty;

    private String achievement;

    private String stuname;

    private String classes;

    private String teacher;

    private String atime;

    private String prizeunit;

    private String comment;

    private String filenum;

    private String schoolyear;

    private Integer state;

    private String postil;

    private String employeenum;

    private String annex;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Integer getCompetitionid() {
        return competitionid;
    }

    public void setCompetitionid(Integer competitionid) {
        this.competitionid = competitionid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement == null ? null : achievement.trim();
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime == null ? null : atime.trim();
    }

    public String getPrizeunit() {
        return prizeunit;
    }

    public void setPrizeunit(String prizeunit) {
        this.prizeunit = prizeunit == null ? null : prizeunit.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getFilenum() {
        return filenum;
    }

    public void setFilenum(String filenum) {
        this.filenum = filenum == null ? null : filenum.trim();
    }

    public String getSchoolyear() {
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear == null ? null : schoolyear.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPostil() {
        return postil;
    }

    public void setPostil(String postil) {
        this.postil = postil == null ? null : postil.trim();
    }

    public String getEmployeenum() {
        return employeenum;
    }

    public void setEmployeenum(String employeenum) {
        this.employeenum = employeenum == null ? null : employeenum.trim();
    }

    public String getAnnex() {
        return annex;
    }

    public void setAnnex(String annex) {
        this.annex = annex == null ? null : annex.trim();
    }
}