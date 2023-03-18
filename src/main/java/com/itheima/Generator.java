package com.itheima;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Generator {
	public static void main(String[] args) {
		FastAutoGenerator.create("jdbc:mysql://localhost:3306/spring_db?serverTimezone=UTC", "root", "123456")
				.globalConfig(builder -> {
					builder.author("lugei") // 设置作者
							.enableSwagger() // 开启 swagger 模式
							.fileOverride() // 覆盖已生成文件
							.disableOpenDir() // 禁止打开目录
							.commentDate("yyyy-MM-dd")
							// .outputDir(System.getProperty("user.dir") + "\\src\\main\\java"); // 指定输出目录
							.outputDir("E:/test/java");
				})
				.packageConfig(builder -> {
					builder.parent("com.itheima") // 设置父包名
							.moduleName("system") // 设置父包模块名
							.mapper("dao")
							.pathInfo(Collections.singletonMap(OutputFile.xml,
									// System.getProperty("user.dir") + "\\src\\main\\resources")); // 设置mapperXml生成路径
									"E:/test/sources"));
				})
				.strategyConfig(builder -> {
					builder.addInclude("user") // 设置需要生成的表名
							.addTablePrefix("p_")
							.serviceBuilder()
							.formatServiceFileName("%sService")
							.formatServiceImplFileName("%sServiceImpl")
							.entityBuilder()
							.enableLombok()
							.logicDeleteColumnName("deleted")
							.enableTableFieldAnnotation()
							.controllerBuilder()
							// 映射路径使用连字符格式，而不是驼峰
							.enableHyphenStyle()
							.formatFileName("%sController")
							.enableRestStyle()
							.mapperBuilder()
							// 生成通用的resultMap
							.enableBaseResultMap()
							.superClass(BaseMapper.class)
							.formatMapperFileName("%sMapper")
							.enableMapperAnnotation()
							.formatXmlFileName("%sMapper");
				})
				.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
				.execute();
	}
}
