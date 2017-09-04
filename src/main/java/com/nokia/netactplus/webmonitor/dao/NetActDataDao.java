package com.nokia.netactplus.webmonitor.dao;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nokia.netactplus.common.exception.DAOExceptionOfOracle;

@Repository
public class NetActDataDao {
	private final static Logger LOGGER = LoggerFactory.getLogger(NetActDataDao.class);
	private String prefixOfEntityPakcge = "com.nokia.netactplus.webmonitor.entity";

	public int getTotalRows(String className, String condition, Connection conn) {
		String tableName = className;
		String countSQL = "select count(*) totalCount from " + tableName + " " + condition;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int total = 0;
		try {
			ps = conn.prepareStatement(countSQL);
			rs = ps.executeQuery();
			if (rs.next()) {
				total = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			LOGGER.error("SQLException: get totalCount from oracle DB failed with SQL: " + countSQL, e);
			throw new DAOExceptionOfOracle("Get data from oracle DB failed!", e);
		}
		return total;
	}



	/**
	 * 返回实体对象集合，如果只有一个也返回集合，业务逻辑做相应处理
	 * @param className
	 *          类名，不包含包名
	 * @param contitions
	 *        sql查询条件，如： AGENT_ID = "xxx"
	 * @param conn
	 *        数据库连接
	 * @return
	 *        对象集合
	 */
	@SuppressWarnings("rawtypes")
	public List<? extends Object> selectObjects(String className, String condition, Connection conn, String pagination) {
		String tableName = className;
		String fullClassName = prefixOfEntityPakcge + "." + className;
		Class objectClass = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object> objects = new LinkedList<>();
		try {
			objectClass = Class.forName(fullClassName);
		} catch (ClassNotFoundException e) {
			LOGGER.error("ClassNotFoundException: class not found for " + className);
		}

		String selectSQL = constructSelectSQL(tableName);
		if (condition != null) {
			selectSQL = String.format(selectSQL, condition);
		} else {
			selectSQL = String.format(selectSQL, "");
		}

		if (pagination != null) {
			selectSQL = selectSQL + pagination;
		}

		LOGGER.debug("select SQL: " + selectSQL);
		try {
			ps = conn.prepareStatement(selectSQL);
			rs = ps.executeQuery();
			Method[] methods = objectClass.getMethods();
			Object obj = null;
			while (rs.next()) {
				obj = objectClass.newInstance();
				for (Method method : methods) {
					String methodName = method.getName();
					if (methodName.startsWith("set")) {
						String columnName = methodName.substring(3, methodName.length());
						Class[] parameters = method.getParameterTypes();
						if (parameters[0] == String.class) {
							method.invoke(obj, rs.getString(columnName));
						} else if (parameters[0] == Double.class) {
							method.invoke(obj, new Double(rs.getDouble(columnName)));
						} else if (parameters[0] == Date.class) {
							method.invoke(obj, rs.getDate(columnName));
						}
					}
				}
				objects.add(obj);
			}

		} catch (SQLException e) {
			LOGGER.error("SQLException: get data from oracle DB failed with SQL, " + selectSQL, e);
			throw new DAOExceptionOfOracle("SQLException: get data from oracle DB failed", e);
		} catch (Exception e) {
			LOGGER.error("Exception: get data from oracle DB failed with SQL, " + selectSQL, e);
			throw new DAOExceptionOfOracle("Get data from oracle DB failed", e);
		}
		return objects;
	}
	
	/**
	 * 返回实体对象集合，如果只有一个也返回集合，业务逻辑做相应处理
	 * @param sql 查询sql
	 * @param conn 数据库连接
	 * @return 对象集合
	 */
	@SuppressWarnings("rawtypes")
	public List<? extends Object> selectObjects(String className,String sql, Connection conn) {
		Class objectClass = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String fullClassName = prefixOfEntityPakcge + "." + className;

		List<Object> objects = new LinkedList<>();
		try {
			objectClass = Class.forName(fullClassName);
		} catch (ClassNotFoundException e) {
			LOGGER.error("ClassNotFoundException: class not found for " + className);
		}

		LOGGER.debug("select SQL: " + sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Method[] methods = objectClass.getMethods();
			Object obj = null;
			while (rs.next()) {
				obj = objectClass.newInstance();
				for (Method method : methods) {
					String methodName = method.getName();
					if (methodName.startsWith("set")) {
						String columnName = methodName.substring(3, methodName.length());
						Class[] parameters = method.getParameterTypes();
						if (parameters[0] == String.class) {
							method.invoke(obj, rs.getString(columnName));
						} else if (parameters[0] == Double.class) {
							method.invoke(obj, new Double(rs.getDouble(columnName)));
						} else if (parameters[0] == Date.class) {
							method.invoke(obj, rs.getDate(columnName));
						}
					}
				}
				objects.add(obj);
			}

		} catch (SQLException e) {
			LOGGER.error("SQLException: get data from oracle DB failed with SQL, " + sql, e);
			throw new DAOExceptionOfOracle("SQLException: get data from oracle DB failed", e);
		} catch (Exception e) {
			LOGGER.error("Exception: get data from oracle DB failed with SQL, " + sql, e);
			throw new DAOExceptionOfOracle("Get data from oracle DB failed", e);
		}
		return objects;
	}
	
	/**
	 * 返回实体对象集合，如果只有一个也返回集合，业务逻辑做相应处理
	 * @param sql 查询sql
	 * @param conn 数据库连接
	 * @return 对象集合
	 */
	public List<Map<String, Object>> executeQuery(String sql, Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		LOGGER.debug("select SQL: " + sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
			int columnCount = md.getColumnCount();
			while (rs.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(rowData);
			}
			return list;

		} catch (SQLException e) {
			LOGGER.error("SQLException: get data from oracle DB failed with SQL, " + sql, e);
			throw new DAOExceptionOfOracle("SQLException: get data from oracle DB failed", e);
		} catch (Exception e) {
			LOGGER.error("Exception: get data from oracle DB failed with SQL, " + sql, e);
			throw new DAOExceptionOfOracle("Get data from oracle DB failed", e);
		}
	}
	
	/**
	 * 返回实体对象集合，如果只有一个也返回集合，业务逻辑做相应处理
	 * @param sql 查询sql
	 * @param key 作为结果map的key列
	 * @param conn 数据库链接
	 * @return 以列key为key的map
	 */
	public Map<Object,Map<String, Object>> executeQuery(String sql, String key, Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		LOGGER.debug("select SQL: " + sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Map<Object,Map<String, Object>> map = new HashMap<Object,Map<String, Object>>();
			ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
			int columnCount = md.getColumnCount();
			while (rs.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), rs.getObject(i));
				}
				map.put(rs.getObject(key),rowData);
			}
			return map;

		} catch (SQLException e) {
			LOGGER.error("SQLException: get data from oracle DB failed with SQL, " + sql, e);
			throw new DAOExceptionOfOracle("SQLException: get data from oracle DB failed", e);
		} catch (Exception e) {
			LOGGER.error("Exception: get data from oracle DB failed with SQL, " + sql, e);
			throw new DAOExceptionOfOracle("Get data from oracle DB failed", e);
		}
	}
	
	private String constructSelectSQL(String tableName) {
		String sql = "select c.* from (select b.*,rownum rn from (select * from " + tableName + " a  %s) b ) c";
		return sql;
	}


}
