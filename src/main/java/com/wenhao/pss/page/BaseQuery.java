package com.wenhao.pss.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 这个baseQuery是包含的通用条件，此处是是一个查询hql和一个查询总数的hql
 * 和一个 当前页 每页多少条
 * Created by lenovo on 2016/10/07.
 *步骤说明
 *     该类作为一个查询基类包含了两条hql，其中一个是查询hql和一个查询总数hql，
 *     这两个hql的查询条件都是通过子类传进来的，因为每个子类的条件都不一样所以
 *     该类通过abstract修饰的，不能让其被实例，只能通过子类来实现
 *================================================================
 *第一步 该类的属性有 提供getter和setter（其中hql和count不需要提供setter，
 *       因为是从子类获得的）
 *     ①hql          这是其中一个查询条件hql
 *     ②countHql     这是查询总数的hql
 *     ③currentPage  这是当前页  从前台传来的
 *     ④pageSize     每页多少条  从前台传来的
 *     ⑤paramList    将子类传来的参数封装到list里
 *================================================================
 *第二步 构造函数（意味着子类必须要有个构造函数将子类的Class传到父类中来）
 *      通过构造函数来初始化 hql 和 countHql 和 paramList
 *================================================================
 *第三步 提供一个受保护的抽象方法
 *      子类通过实现该方法进行查询条件的传递
 */
public abstract class BaseQuery {

    //此处用 StringBuilder 考虑到StringBuilder性能较高
    protected StringBuilder hql;
    private StringBuilder countHql;
    private int currentPage = 1;
    private int pageSize = 10;
    private List paramList;


    public BaseQuery(Class entiyClass) {
        countHql = new StringBuilder().append("select count(o) from " + entiyClass.getName() + " o");
        hql = new StringBuilder().append(" select o from " + entiyClass.getName() + " o");
        paramList = new ArrayList();
    }

    protected abstract void addWhere();

    protected void addWhere(String where, Object... objects) {
        if (paramList.size() == 0) {
            countHql.append(" where ").append(where);
            hql.append(" where ").append(where);
        } else {
            countHql.append(" where ").append(where);
            hql.append(" where ").append(where);
        }
        paramList.addAll(Arrays.asList(objects));
    }


    public String getHql() {
        return hql.toString();
    }

    public String getCountHql() {
        return countHql.toString();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
