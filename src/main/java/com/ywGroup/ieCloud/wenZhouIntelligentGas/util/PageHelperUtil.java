package com.ywGroup.ieCloud.wenZhouIntelligentGas.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2017-8-22.
 */
public class PageHelperUtil {

    private long Total;
    private int pageNum;
    private int pageSize;
    private List list;

    public long getTotal() {
        return Total;
    }

    public void setTotal(long total) {
        Total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public static PageHelperUtil toPageHeper(PageInfo pageInfo){
        PageHelperUtil pageHelperUtil = new PageHelperUtil();
        pageHelperUtil.setPageNum(pageInfo.getPageNum());
        pageHelperUtil.setTotal(pageInfo.getTotal());
        pageHelperUtil.setPageSize(pageInfo.getPageSize());
        pageHelperUtil.setList(pageInfo.getList());
        return pageHelperUtil;
    }

}
