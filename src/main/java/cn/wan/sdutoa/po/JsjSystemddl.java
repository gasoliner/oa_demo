package cn.wan.sdutoa.po;

public class JsjSystemddl {
    private String uuid;

    private String keyword;

    private Integer ddlcode;

    private String ddlname;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getDdlcode() {
        return ddlcode;
    }

    public void setDdlcode(Integer ddlcode) {
        this.ddlcode = ddlcode;
    }

    public String getDdlname() {
        return ddlname;
    }

    public void setDdlname(String ddlname) {

        this.ddlname = ddlname == null ? null : ddlname.trim();
    }

    @Override
    public String toString() {
        return "JsjSystemddl{" +
                "uuid='" + uuid + '\'' +
                ", keyword='" + keyword + '\'' +
                ", ddlcode=" + ddlcode +
                ", ddlname='" + ddlname + '\'' +
                '}';
    }
}