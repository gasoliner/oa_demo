package cn.wan.sdutoa.po;

public class Role {
    private Long rid;

    private String role;

    private String ddlid;

    private String resourceIds;

    private Boolean available;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getDdlid() {
        return ddlid;
    }

    public void setDdlid(String ddlid) {
        this.ddlid = ddlid == null ? null : ddlid.trim();
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds == null ? null : resourceIds.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", role='" + role + '\'' +
                ", ddlid='" + ddlid + '\'' +
                ", resourceIds='" + resourceIds + '\'' +
                ", available=" + available +
                '}';
    }
}