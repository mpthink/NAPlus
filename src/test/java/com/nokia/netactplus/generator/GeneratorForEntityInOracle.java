package com.nokia.netactplus.generator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GeneratorForEntityInOracle {

	//create tables
	/*
	 *
	 *
	 *
	 	create table FM_FX_ALARM as select * from FM.FX_ALARM where 1=2;
		create table CMDINT_ND_IN_FTP as select * from CMDINT.ND_IN_FTP where 1=2;
		create table CMDINT_ND_IN_HTTP as select * from CMDINT.ND_IN_HTTP where 1=2;
		create table CMDINT_ND_IN_NE_3_SSNMP as select * from CMDINT.ND_IN_NE_3_SSNMP where 1=2;
		create table CMDINT_ND_IN_NE_3_SWS as select * from CMDINT.ND_IN_NE_3_SWS where 1=2;
		create table CMDINT_ND_IN_SNMP as select * from CMDINT.ND_IN_SNMP where 1=2;
		create table CMDINT_ND_IN_SSH as select * from CMDINT.ND_IN_SSH where 1=2;
	
		create table NASDA_NASDA_OBJECTS as select * from NASDA.NASDA_OBJECTS where 1=2;
		create table NASDA_NASDA_REF_MR as select * from NASDA.NASDA_REF_MR where 1=2;
		create table NASDA_NASDA_REF_AGENT as select * from NASDA.NASDA_REF_AGENT where 1=2;
		//NASDA_OBJECT_CLASS定义了所有支持的NASDA object， 通过oc_adaptation字段可以区分common、interface or connectivity，在创建object的时候需要提供
		create table NASDA_NASDA_OBJECT_CLASS as select * from NASDA.NASDA_OBJECT_CLASS where 1=2;
		//FM_CRC_META表是FMB deploy的记录表，记录了agent_class和adaptation Id及release的关系，在创建MO，选择release的时候使用
		create table FM_FM_CRC_META as select * from FM.FM_CRC_META where 1=2;
	 *
	 *
	 */
	public static void main(String[] args) throws SQLException {
		AutoGenerator mpg = new AutoGenerator();

		//global config
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("D://temp");
		gc.setFileOverride(true);
		gc.setActiveRecord(false);// 开启 activeRecord 模式
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true); // XML ResultMap
		gc.setBaseColumnList(true);// XML columList
		gc.setAuthor("mpthink");

		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		// gc.setMapperName("%sDao");
		// gc.setXmlName("%sDao");
		// gc.setServiceName("MP%sService");
		// gc.setServiceImplName("%sServiceDiy");
		// gc.setControllerName("%sAction");
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.ORACLE);
		//		dsc.setTypeConvert(new MySqlTypeConvert(){
		//            // 自定义数据库表字段类型转换【可选】
		//            @Override
		//            public DbColumnType processTypeConvert(String fieldType) {
		//                System.out.println("转换类型：" + fieldType);
		//                return super.processTypeConvert(fieldType);
		//            }
		//        })

		dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
		dsc.setUsername("omc");
		dsc.setPassword("omc");
		dsc.setUrl("jdbc:oracle:thin:@10.92.67.49:1521:oss");
		String sql = "select distinct dn,alarm_number from fx_alarm";
		PreparedStatement pre = dsc.getConn().prepareStatement(sql);// 实例化预编译语句
		ResultSet rs = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		System.out.println("test:  " + rs.getFetchSize());
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		//strategy.setTablePrefix("bmd_");// 此处可以修改为您的表前缀

		strategy.setNaming(NamingStrategy.nochange);// 表名生成策略
		strategy
			.setInclude(
				new String[] {"FX_ALARM", "ND_IN_FTP", "ND_IN_HTTP", "ND_IN_NE_3_SSNMP", "ND_IN_NE_3_SWS", "ND_IN_SNMP", "ND_IN_SSH", "NASDA_OBJECTS",
					"NASDA_REF_MR", "NASDA_REF_AGENT", "NASDA_OBJECT_CLASS", "FM_BASIC_ADAPTATION"}); // 需要生成的表
		// strategy.setExclude(new String[]{"test"}); // 排除生成的表
		// 字段名生成策略
		strategy.setFieldNaming(NamingStrategy.nochange);
		//strategy.setDbColumnUnderline(true);
		// 自定义实体父类
		// strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
		// 自定义实体，公共字段
		// strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
		// 自定义 mapper 父类
		// strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
		// 自定义 service 父类
		// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
		// 自定义 service 实现类父类
		// strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
		// 自定义 controller 父类
		// strategy.setSuperControllerClass("com.baomidou.demo.TestController");
		// 【实体】是否生成字段常量（默认 false）
		// public static final String ID = "test_id";
		// strategy.setEntityColumnConstant(true);
		// 【实体】是否为构建者模型（默认 false）
		// public User setName(String name) {this.name = name; return this;}
		// strategy.setEntityBuliderModel(true);
		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.nokia");
		pc.setModuleName("netactplus.webmonitor");
		pc.setController("controller");
		mpg.setPackageInfo(pc);

		// 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
		//		InjectionConfig cfg = new InjectionConfig() {
		//			@Override
		//			public void initMap() {
		//				Map<String, Object> map = new HashMap<String, Object>();
		//				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
		//				this.setMap(map);
		//			}
		//		};

		// 自定义 xxList.jsp 生成
		//		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		//		focList.add(new FileOutConfig("/template/list.jsp.vm") {
		//			@Override
		//			public String outputFile(TableInfo tableInfo) {
		//				// 自定义输入文件名称
		//				return "D://my_" + tableInfo.getEntityName() + ".jsp";
		//			}
		//		});

		//cfg.setFileOutConfigList(focList);
		//		mpg.setCfg(cfg);

		// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
		// 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
		// TemplateConfig tc = new TemplateConfig();
		// tc.setController("...");
		// tc.setEntity("...");
		// tc.setMapper("...");
		// tc.setXml("...");
		// tc.setService("...");
		// tc.setServiceImpl("...");
		// mpg.setTemplate(tc);

		// 执行生成
		mpg.execute();

		// 打印注入设置
		//System.err.println(mpg.getCfg().getMap().get("abc"));

	}

}
