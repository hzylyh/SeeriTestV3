package com.seeri.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {
    public static SqlSession getSqlSession() throws IOException {
        //获取配置的资源文件
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = factory.openSession();

        return sqlSession;
    }

    public static void main(String[] args) throws IOException {
//        SqlSession session = DatabaseUtil.getSqlSession();
//        SeeriCase seeriCase = session.selectOne("loginCase");
//        System.out.println(seeriCase.getCaseName());
//        List<SeeriCase> list = session.selectList("loginCase");
//        String filePath = path + "../../../casefile/SeeriCase.csv"
//        for (SeeriCase seeriCase: list) {
//            System.out.println(seeriCase.getCaseName());
//        }
//        String dataDay = "2018-08-09";
//        SeeriLog seeriLog = new SeeriLog();
//        seeriLog.setDataDay("2018-08-10");
//        session.insert("logInsert", seeriLog);
//        session.commit();

    }
}
