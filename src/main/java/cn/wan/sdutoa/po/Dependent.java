package cn.wan.sdutoa.po;

/**
 * Created by wanzhenghang on 2017/2/18.
 */
public class Dependent {
    private int deptid;
    private String dep;

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "deptid=" + deptid +
                ", dep='" + dep + '\'' +
                '}';
    }
}
