package cn.wan.sdutoa.po;

public class JsjUser {
    private Long uid;

    private String employeenum;

    private String username;

    private String password;

    private String salt;

    private Integer deptid;

    private String phone;

    private String email;

    private String roleidsstr;

    private Boolean locked;

    private String role;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getEmployeenum() {
        return employeenum;
    }

    public void setEmployeenum(String employeenum) {
        this.employeenum = employeenum == null ? null : employeenum.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRoleidsstr() {
        return roleidsstr;
    }

    public void setRoleidsstr(String roleidsstr) {
        this.roleidsstr = roleidsstr == null ? null : roleidsstr.trim();
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    @Override
    public String toString() {
        return "JsjUser{" +
                "uid=" + uid +
                ", employeenum='" + employeenum + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", deptid=" + deptid +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", roleidsstr='" + roleidsstr + '\'' +
                ", locked=" + locked +
                ", role='" + role + '\'' +
                '}';
    }
}