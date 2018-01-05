package me.lumen.demo.utils;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lumen on 18-1-5.
 */
public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;

    public static synchronized SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory == null){
            initSqlSessionFactoryFromXml();
        }
        return sqlSessionFactory;
    }

    private static void initSqlSessionFactoryFromXml(){
        String configPath = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(configPath);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("read config file failed");
        }
    }

    private static void initSqlSessionFactoryFromApi(){
    }

}
