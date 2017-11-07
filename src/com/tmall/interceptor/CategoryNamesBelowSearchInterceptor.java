package com.tmall.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tmall.pojo.Category;
import com.tmall.service.CategoryService;
import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by OovEver on 2017/11/7.
 * 1. 如果发现是以/fore开头的访问就进行处理
 2. 取出所有的分类对象
 3. 放在session的"cs"中
 */
public class CategoryNamesBelowSearchInterceptor extends AbstractInterceptor{
    @Autowired
    CategoryService categoryService;
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext      ctx            = invocation.getInvocationContext();
        HttpServletRequest request        = (HttpServletRequest) ctx.get(StrutsStatics.HTTP_REQUEST);
        ServletContext     servletContext = (ServletContext) ctx.get(StrutsStatics.SERVLET_CONTEXT);
        String contextPath = servletContext.getContextPath();
        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri, contextPath);
        if(uri.startsWith("/fore")){
            List<Category> cs = categoryService.list();
            ctx.getSession().put("cs", cs);
        }
        return invocation.invoke();
    }
}
