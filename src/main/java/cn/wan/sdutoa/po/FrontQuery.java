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
}
