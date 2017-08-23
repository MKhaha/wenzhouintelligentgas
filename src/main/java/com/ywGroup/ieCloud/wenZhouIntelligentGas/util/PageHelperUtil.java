package com.ywGroup.ieCloud.wenZhouIntelligentGas.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2017-8-22.
 */
public class PageHelperUtil {

    private int pages;
    private int pageNum;
    private int pageSize;
    private List list;

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
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

    /**
     * 分页工具类
     * @param pageNumber
     * @param pageSize
     * @param list
     * @return
     */
    public static PageHelperUtil getPageInfo(int pageNumber, int pageSize, List list){
        PageHelper.startPage(pageNumber, pageSize);
        PageInfo pageResult = new PageInfo(list);
        pageResult.setList(list);
        return toPageHeper(pageResult);
    }

    public static PageHelperUtil toPageHeper(PageInfo pageInfo){
        PageHelperUtil pageHelperUtil = new PageHelperUtil();
        pageHelperUtil.setPageNum(pageInfo.getPageNum());
        pageHelperUtil.setPages(pageInfo.getPages());
        pageHelperUtil.setPageSize(pageInfo.getPageSize());
        pageHelperUtil.setList(pageInfo.getList());
        return pageHelperUtil;
    }

}
