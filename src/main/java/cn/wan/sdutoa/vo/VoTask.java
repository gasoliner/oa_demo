package cn.wan.sdutoa.vo;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by wanzhenghang on 2017/4/3.
 */
public class VoTask {

    private String id;

    private String processName;

    private String currentActiviti;

    private String owner;

    @JSONField(format = "yyyy-MM-dd")
    private Date applyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getCurrentActiviti() {
        return currentActiviti;
    }

    public void setCurrentActiviti(String currentActiviti) {
        this.currentActiviti = currentActiviti;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
}
