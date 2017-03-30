package cn.wan.sdutoa.po;

/**
 * Created by wanzhenghang on 2017/2/17.
 */
public class FrontQuery {
    private int page;
    private int rows;
    private int pageSize;
    private int start;
    private String [] roleDDL;
    private int syid;
    private String schoolyear;
    private int blid;
    private String booklevel;
    private int stid;
    private String searchtype;
    private int competitionid;
    private String competition;
    private int awardlevelid;
    private String awardlevel;
    private int gradeid;
    private String grade;

    public FrontQuery() {
    }

    public FrontQuery(int start, int pageSize) {
        this.start = start;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String[] getRoleDDL() {
        return roleDDL;
    }

    public void setRoleDDL(String[] roleDDL) {
        this.roleDDL = roleDDL;
    }

    public int getSyid() {
        return syid;
    }

    public void setSyid(int syid) {
        this.syid = syid;
    }

    public String getSchoolyear() {
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {

        this.schoolyear = schoolyear;
    }

    public int getBlid() {
        return blid;
    }

    public void setBlid(int blid) {
        this.blid = blid;
    }

    public String getBooklevel() {
        return booklevel;
    }

    public void setBooklevel(String booklevel) {
        this.booklevel = booklevel;
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public String getSearchtype() {
        return searchtype;
    }

    public void setSearchtype(String searchtype) {

        this.searchtype = searchtype;
    }

    public int getCompetitionid() {
        return competitionid;
    }

    public void setCompetitionid(int competitionid) {
        this.competitionid = competitionid;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public int getAwardlevelid() {
        return awardlevelid;
    }

    public void setAwardlevelid(int awardlevelid) {
        this.awardlevelid = awardlevelid;
    }

    public String getAwardlevel() {
        return awardlevel;
    }

    public void setAwardlevel(String awardlevel) {
        this.awardlevel = awardlevel;
    }

    public int getGradeid() {
        return gradeid;
    }

    public void setGradeid(int gradeid) {
        this.gradeid = gradeid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
