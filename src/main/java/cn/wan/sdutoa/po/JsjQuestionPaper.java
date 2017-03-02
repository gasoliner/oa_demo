package cn.wan.sdutoa.po;

public class JsjQuestionPaper {
    private Long qid;

    private String teacher;

    private String classname;

    private String course;

    private Integer psource;

    private Integer examineway;

    private Integer num;

    private Integer pnum;

    private Integer analyzes;

    private Integer plan;

    private Integer invigilation;

    private Integer ab;

    private Integer answer;

    private Integer standard;

    private Integer score;

    private String comment;

    private String schoolyear;

    private String filenum;

    private String ischange;

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course == null ? null : course.trim();
    }

    public Integer getPsource() {
        return psource;
    }

    public void setPsource(Integer psource) {
        this.psource = psource;
    }

    public Integer getExamineway() {
        return examineway;
    }

    public void setExamineway(Integer examineway) {
        this.examineway = examineway;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    public Integer getAnalyzes() {
        return analyzes;
    }

    public void setAnalyzes(Integer analyzes) {
        this.analyzes = analyzes;
    }

    public Integer getPlan() {
        return plan;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    public Integer getInvigilation() {
        return invigilation;
    }

    public void setInvigilation(Integer invigilation) {
        this.invigilation = invigilation;
    }

    public Integer getAb() {
        return ab;
    }

    public void setAb(Integer ab) {
        this.ab = ab;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getSchoolyear() {
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear == null ? null : schoolyear.trim();
    }

    public String getFilenum() {
        return filenum;
    }

    public void setFilenum(String filenum) {
        this.filenum = filenum == null ? null : filenum.trim();
    }

    public String getIschange() {
        return ischange;
    }

    public void setIschange(String ischange) {
        this.ischange = ischange == null ? null : ischange.trim();
    }

    @Override
    public String toString() {
        return "JsjQuestionPaper{" +
                "qid=" + qid +
                ", teacher='" + teacher + '\'' +
                ", classname='" + classname + '\'' +
                ", course='" + course + '\'' +
                ", psource=" + psource +
                ", examineway=" + examineway +
                ", num=" + num +
                ", pnum=" + pnum +
                ", analyzes=" + analyzes +
                ", plan=" + plan +
                ", invigilation=" + invigilation +
                ", ab=" + ab +
                ", answer=" + answer +
                ", standard=" + standard +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", schoolyear='" + schoolyear + '\'' +
                ", filenum='" + filenum + '\'' +
                ", ischange='" + ischange + '\'' +
                '}';
    }
}