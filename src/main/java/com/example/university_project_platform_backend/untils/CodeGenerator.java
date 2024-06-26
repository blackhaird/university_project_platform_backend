package com.example.university_project_platform_backend.untils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {



    public static void main(String[] args) {
        String url="jdbc:mysql://1.12.37.222:3306/university_project_platform_db?useSSL=false&useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password = "123456";
        String moduleName = "projectPlatform";
        String mapperLocation = "D:\\Work_RJ\\java_study\\university_project_platform_backend\\src\\main\\resources\\mapper\\";
        String tables = "mentor,project,project_management,student,student_group,user,Competition,credits,project_management_operation,credits_operation,websocket,home_page,student_Audit,credits_audit,activity,project_Forum,mail,student_submit";


        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("blackhaird") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            //.fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\Work_RJ\\java_study\\university_project_platform_backend\\src\\main\\java"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("com.example.university_project_platform_backend") // 设置父包名
//                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            .addTablePrefix()// 设置需要生成的表名
                            .entityBuilder()
                            .enableLombok().
                            enableFileOverride(); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
