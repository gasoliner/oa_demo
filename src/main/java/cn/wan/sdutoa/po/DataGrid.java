package cn.wan.sdutoa.po;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanzhenghang on 2017/2/17.
 */
public class DataGrid {
    private Long total = 0L;
    private Object rows ;

    public Long getTotal() {
            return total;
        }

    public void setTotal(Long total) {
            this.total = total;
        }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }
}
