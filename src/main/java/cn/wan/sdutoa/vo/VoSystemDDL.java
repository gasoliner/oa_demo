package cn.wan.sdutoa.vo;

import cn.wan.sdutoa.po.JsjSystemddl;


/**
 * Created by 万洪基 on 2017/3/9.
 */
public class VoSystemDDL extends JsjSystemddl implements Comparable<VoSystemDDL> {

    @Override
    public int compareTo(VoSystemDDL o) {
        return this.getDdlcode().compareTo(o.getDdlcode());
    }
}
