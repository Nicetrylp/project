package domain;

import java.util.List;

public class PageBean <T>{
    private int pageNum; // 当前页
    private int pageSize;   // 每页的数据
    private int totalRecord;    //总记录条数

    private int totalPage; //总页数
    private int startIndex; // 索引

    private List<T> list;   // 每页要显示的数据

    private int start;  // 第一个显示的页数
    private int end;    // 最后一个显示的页数

    public PageBean() {
    }

    // 获得初始就可以知道的数据
    public PageBean(int pageNum, int pageSize, int totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        // 总页数
        if (totalRecord % pageSize ==0){
            // 整除,代表刚好显示完毕,没有多余信息要在新的分页上显示
            this.totalPage = totalRecord/pageSize;
        }else{
            // 不整除
            this.totalPage = totalRecord/pageSize +1;
        }

        // 开始索引
        this.startIndex = (pageNum-1)*pageSize;
        //TODO 这里是显示5页
        this.start = 1;
        this.end = 5;
        // 显示页数的算法
        if (totalPage <= 5){
            // 总页数少于5,end就是总页数的值
            this.end = this.totalPage;
        }else{
            // 如果当前是第4页,应该是 2 3  "4"  5 6
            // 如果当前是第5页,应该是 3 4  "5"  6 7
            this.start = pageNum-2;
            this.end = pageNum+2;
            if (start <= 0){
                // 如果当前是第1页,就不需要这个规则了 "1" 2 3 4 5
                this.start = 1;
                this.end = 5;
            }
            if (end >= this.totalPage){
                // 如果是倒数第二页或最后一页,也不需要这个规则
                this.end = this.totalPage;
                this.start = this.totalPage-4;
            }
        }

    }

    // get/set方法
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

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }


    @Override
    public String toString() {
        return "PageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", startIndex=" + startIndex +
                ", list=" + list +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
