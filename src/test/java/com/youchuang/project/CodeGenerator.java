package com.youchuang.project;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author: mohuijing
 */
public class CodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    /**
     * 用于接收键盘输入，返回键盘输入字符串
     * 用户键盘输入表名、模块名使用
     * @param tip 提示信息
     * @return
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取用户的工作目录：项目的根路径
        String projectPath = System.getProperty("user.dir");
        //生成的类、接口的路径
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("mohuijing");
        //生成代码后是否打开文件，默认打开
        gc.setOpen(false);
        //Service接口开头默认是i,去掉i
        gc.setServiceName("%sService");
        //全局配置对象设置到代码生成器对象中
        mpg.setGlobalConfig(gc);

        // 数据源配置
        //因为要连接数据库生成对应的实体、controller等等
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/youchuangdb?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        //驱动类
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("888888");
        //数据源对象设置到代码生成器对象中
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //很多项目都是规模非常庞大的，有不同模块，不想把一个类放在一个模块中，不好维护
        //模块名和Parent共同构成生成内部接口的全路径
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.youchuang");
        //包配置对象设置到代码生成器对象中
        mpg.setPackageInfo(pc);

        // 自定义配置
        //自定义参数自定义模板的时候使用，在代码中增加参数，实现自定义模板
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 模板引擎是 freemarker
        // 找到mapper.xml对应的模板，参照xml.ftl模板透过代码逻辑生成xml文件
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                // 如果不写就生成到long.java下
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileCreate(new IFileCreate() {

            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                return true;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板, 使用默认
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //表名,如果是下划线的会生成实体类转成驼峰，且首字母大写
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //字段，数据库字段是下划线的转成驼峰，且首字母大写
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        if (scanner("是否继承基类").equalsIgnoreCase("y")) {
            strategy.setSuperEntityClass("com.youchuang.project.entity.BaseEntity");
            // 写于父类中的公共字段
            strategy.setSuperEntityColumns("create_time", "modified_time", "create_account_id", "modified_account_id", "deleted");
        }
        //是否使用Lombok模式生成的实体，生成@Date注解，可以省略get、set 方法
        strategy.setEntityLombokModel(true);
        //非前后分离 ，有的要负责页面跳转的方法，默认返回JOSN格式
        strategy.setRestControllerStyle(false);

        //根据手动输入的表生成相应的controller、service、实体等等
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //是否驼峰
        strategy.setControllerMappingHyphenStyle(true);
        //发现表中有这个字段，实体类对应的属性加上逻辑删除注解，标识他为逻辑删除自段
        strategy.setLogicDeleteFieldName("deleted");
        //自动填充
        ArrayList<TableFill> tableFills = new ArrayList<>();
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill modifiedTime = new TableFill("modified_time", FieldFill.UPDATE);
        TableFill createAccountId = new TableFill("create_account_id", FieldFill.INSERT);
        TableFill modifiedAccountId = new TableFill("modified_account_id", FieldFill.UPDATE);
        tableFills.add(createTime);
        tableFills.add(modifiedTime);
        tableFills.add(createAccountId);
        tableFills.add(modifiedAccountId);
        strategy.setTableFillList(tableFills);

        //strategy.setTablePrefix(pc.getModuleName() + "_");表名前缀

        mpg.setStrategy(strategy);//把策略配置对象设置到代码生成器对象中
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());//模板引擎
        mpg.execute();//执行
    }

}

