package me.lumen.demo.intercepts;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
 * Created by lumen on 18-1-5.
 * mybatis intercepts 设置方法
 */
@Intercepts({
    @Signature(type = ResultSetHandler.class,
            method = "handleResultSets",
            args = {Statement.class}
    )
})
public class ExampleIntercept implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("method handleResultSets has been proccessed");
        return invocation.proceed();
    }

    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    public void setProperties(Properties properties) {

    }
}
