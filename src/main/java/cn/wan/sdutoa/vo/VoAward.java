package cn.wan.sdutoa.vo;

import cn.wan.sdutoa.po.JsjAwards;

/**
 * Created by 万洪基 on 2017/3/28.
 */
public class VoAward extends JsjAwards {

    private String voCompetition;

    private String voLevel;

    private String voGrade;

    private String voState;

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getVoCompetition() {
        return voCompetition;
    }

    public void setVoCompetition(String voCompetition) {
        this.voCompetition = voCompetition;
    }

    public String getVoLevel() {
        return voLevel;
    }

    public void setVoLevel(String voLevel) {
        this.voLevel = voLevel;
    }

    public String getVoGrade() {
        return voGrade;
    }

    public void setVoGrade(String voGrade) {
        this.voGrade = voGrade;
    }

    public String getVoState() {
        return voState;
    }

    public void setVoState(String voState) {
        this.voState = voState;
    }
}
