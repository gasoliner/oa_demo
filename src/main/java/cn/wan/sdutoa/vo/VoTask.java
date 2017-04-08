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

    private String voAction;

    @JSONField(format = "yyyy-MM-dd")
    private Date startTime;

    @JSONField(format = "yyyy-MM-dd")
    private Date endTime;

    private String assignee;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getVoAction() {
        return voAction;
    }

    public void setVoAction(String voAction) {
        this.voAction = voAction;
    }

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

    @Override
    public String toString() {
        return "VoTask{" +
                "id='" + id + '\'' +
                ", processName='" + processName + '\'' +
                ", currentActiviti='" + currentActiviti + '\'' +
                ", owner='" + owner + '\'' +
                ", applyTime=" + applyTime +
                ", voAction='" + voAction + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", assignee='" + assignee + '\'' +
                '}';
    }
}
