package cn.wan.sdutoa.vo;

import cn.wan.sdutoa.po.JsjTrainingPaper;

/**
 * Created by 万洪基 on 2017/3/5.
 */
public class VoTrainingPaper extends JsjTrainingPaper {
    private String spsource;
    private String sexamineway;
    private String sanalyzes;
    private String splan;
    private String sstandard;
    private String sscore;

    public String getSpsource() {
        return spsource;
    }

    public void setSpsource(String spsource) {
        this.spsource = spsource;
    }

    public String getSexamineway() {
        return sexamineway;
    }

    public void setSexamineway(String sexamineway) {
        this.sexamineway = sexamineway;
    }

    public String getSanalyzes() {
        return sanalyzes;
    }

    public void setSanalyzes(String sanalyzes) {
        this.sanalyzes = sanalyzes;
    }

    public String getSplan() {
        return splan;
    }

    public void setSplan(String splan) {
        this.splan = splan;
    }

    public String getSstandard() {
        return sstandard;
    }

    public void setSstandard(String sstandard) {
        this.sstandard = sstandard;
    }

    public String getSscore() {
        return sscore;
    }

    public void setSscore(String sscore) {
        this.sscore = sscore;
    }
}
