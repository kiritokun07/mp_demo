package com.example.demo.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Scanner;

public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (ipt != null) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        //https://github.com/baomidou/generator
        //数据库配置(DataSourceConfig)
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder(
                "jdbc:mysql://localhost:3307/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai",
                "root",
                "root").build();

        //全局配置(GlobalConfig)
        GlobalConfig globalConfig = new GlobalConfig.Builder()
//                .fileOverride() //是否覆盖已生成文件
                .openDir(false) //是否打开生成目录
                .outputDir("src/main/java") //指定输出目录
                .author("kirito") //作者名
                .enableSwagger() //是否生成swagger注解
                .build();

        //包配置(PackageConfig)
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent(CodeGenerator.class.getCanonicalName().replace(".utils.CodeGenerator", ""))
//                .moduleName(scanner("父包模块名"))
                .entity("domain")
                .build();

        //模板配置(TemplateConfig)
        TemplateConfig templateConfig = new TemplateConfig.Builder()
//                .disable(TemplateType.CONTROLLER)
                .build();

        //策略配置(StrategyConfig)
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .addInclude(scanner("表名，多个英文逗号分割").split("[,，]"))
                .addTablePrefix(packageConfig.getModuleName() + "_")
                .entityBuilder()
                .enableLombok() //开启lombok模型
                .enableSerialVersionUID() //开启生成serialVersionUID
                .idType(IdType.AUTO)
                .naming(NamingStrategy.underline_to_camel) //数据库表映射到实体的命名策略
                .columnNaming(NamingStrategy.underline_to_camel) //数据库表字段映射到实体的命名策略
                .versionColumnName("version") //乐观锁数据库表字段
                .addTableFills(new Column("create_time", FieldFill.INSERT))
                .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
//                .enableTableFieldAnnotation()
                .controllerBuilder()
//                .enableHyphenStyle() //开启驼峰转连字符
                .enableRestStyle() //开启生成@RestController控制器
                .mapperBuilder()
                .serviceBuilder()
                .build();

        //代码生成器
        AutoGenerator generator = new AutoGenerator(dataSourceConfig)
                .global(globalConfig)
                .packageInfo(packageConfig)
                .template(templateConfig)
                .strategy(strategyConfig);
        generator.execute();

    }

}
