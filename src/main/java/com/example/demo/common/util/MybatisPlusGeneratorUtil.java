package com.example.demo.common.util;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.demo.common.web.base.BaseController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MybatisPlusGeneratorUtil {

    interface Config {
        String author = "kaito kuroba";

        // database config
        String url = "jdbc:mysql://47.115.230.231:3306/spider_data";
        String username = "root";
        String password = "bzp510719";


        // 输出路径
        String outputDir = System.getProperty("user.dir") + "/src/main/java";
        String mapperOutputDir = System.getProperty("user.dir") + "/src/main/resources/mapper";

        // 父包名
        String parent = "com.example.demo";
    }

    public static void create(List<String> tables) {
        FastAutoGenerator.create(Config.url, Config.username, Config.password)
                .globalConfig(builder -> {
                    builder.author(Config.author)
                            .outputDir(Config.outputDir)
                            // 开启swagger
                            .enableSwagger()
                            .commentDate("yyyy-MM-dd")
                            // 开启覆盖之前生成的文件
                            .fileOverride();

                })
                .packageConfig(builder -> builder.parent(Config.parent)
                        .xml("modules/sys/mapper/xml")
                        .pathInfo(Collections.singletonMap(OutputFile.mapperXml, Config.mapperOutputDir))
                )
                .strategyConfig(builder -> builder.addInclude(tables)
//                        .addTablePrefix("t_")
                        .entityBuilder()
                        .enableLombok()
                        .logicDeleteColumnName("is_deleted")
                        .enableTableFieldAnnotation()
                        .enableRemoveIsPrefix()
                        .controllerBuilder()
                        .enableRestStyle()
                        .superClass(BaseController.class)
                        .mapperBuilder()
                        .superClass(BaseMapper.class)
                        .enableMapperAnnotation())
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    public static void main(String[] args) {
        List<String> tables = new ArrayList<>();
//        tables.add("tb_role");
//        tables.add("tb_user");
//        tables.add("tb_admin");
//        tables.add("tb_sample");
//        tables.add("tb_spider");
//        tables.add("view_user");
//        tables.add("view_admin");
//        tables.add("view_sample");
        tables.add("log");

        create(tables);
    }
}
