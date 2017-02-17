package cn.wan.sdutoa.po;

/**
 * Created by wanzhenghang on 2017/2/17.
 */
public class Role {
    private long rid;
    private String role;

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", role='" + role + '\'' +
                '}';
    }
}
