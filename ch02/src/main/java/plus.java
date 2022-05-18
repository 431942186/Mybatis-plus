import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

class plus {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/orm", "root", "020910")
                .globalConfig(builder -> {
                    builder.author("展xx") // 设置作者
                            .commentDate("yyyy-MM-dd hh:mm:ss")   //注释日期
                            .dateType(DateType.ONLY_DATE)   //定义生成的实体类中日期的类型 TIME_PACK=LocalDateTime;ONLY_DATE=Date;
                            .disableOpenDir()  //禁止打开输出目录，默认打开
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir") + "/ch02/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com") // 设置父包名
                            .moduleName("zlf")   //设置模块包名
                            .entity("entity")   //pojo 实体类包名
                            .service("service") //Service 包名
                            .serviceImpl("service.serviceImpl") // ***ServiceImpl 包名
                            .mapper("mapper")   //Mapper 包名
                            .xml("xml")  //Mapper XML 包名
                            .controller("controller") //Controller 包名
                            .other("utils") //自定义文件包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/ch02/src/main/resources/xml"));
                    //配置 **Mapper.xml 路径信息：项目的 resources 目录的 Mapper 目录下
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine())
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();


    }


}
