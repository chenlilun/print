package com.example.print.utils;




import java.util.Collections;

public class CodeGenerator {
    /**
     * RUN THIS
     */
    //生成文件所在项目路径
    private static String baseProjectPath = "D:\\java\\demo";

    //基础包名
    private static String basePackage="com.xyzh.mybatisplus.demo";
    //设置作者
    private static String authorName="adrian";
    //这里是要生成的表名（如果全部要生成的话，这里注释掉）
    //private static String[] tables= {"t_role","t_resource","t_role_resource","t_user_role"};
    //可以设置table前缀
    private static String prefix="t_";

    //数据库配置四要素
    private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://10.12.3.205:1433;DatabaseName=ASRS_YJ_CP_1";
    private static String username = "sa";
    private static String password = "asrs-123";


    public static void main(String[] args) {



    }

}
