package com.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hibernate.test.User;

/**
 * @author JoneM
 * JDBC 链接数据库  ,ResultSet结果集转成Model
 */
public class JdbcConnectAction {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
        String passwrod = "root";
        String userName = "root";
        String url = "jdbc:mysql://localhost:3306/hibernate?serverTimezone=UTC";
        String sql = "select * from user";
 
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, userName,
                    passwrod);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            // 转换结果集为Model
            List list = populate(rs, User.class);
            for(int i = 0 ; i<list.size() ; i++){
            	User user = (User) list.get(i);
            	System.out.println(user.toString());
            }
 
            // 关闭记录集
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
 
            // 关闭声明
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
 
            // 关闭链接对象
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/*
     * 将rs结果转换成Entity对象列表
     * @param rs jdbc结果集
     * @param clazz 对象的映射类
     * return 封装了对象的结果列表
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static List populate (ResultSet rs,Class clazz) 
			throws InstantiationException, IllegalAccessException{
		//返回结果的列表集合
		List list = new ArrayList();
		try {
			//获取结果集的元素个数
			int colCount;
			//结果集的元素对象 
			ResultSetMetaData rsmd = rs.getMetaData();
			colCount = rsmd.getColumnCount();
			//业务对象的属性数组
			Field[] fields = clazz.getDeclaredFields();
			
			//对每一条记录进行操作
			while(rs.next()){
				Object obj = clazz.newInstance();//构造业务对象实体
				//将每一个字段取出进行赋值
				for(int i = 1;i<=colCount;i++){
					Object value = rs.getObject(i);
					//寻找该列对应的对象属性
					for(int j=0;j<fields.length;j++){
						Field f = fields[j];
						//如果匹配进行赋值
						if(f.getName().equalsIgnoreCase(rsmd.getColumnName(i))){
							boolean flag = f.isAccessible();
							f.setAccessible(true);
							f.set(obj, value);
							f.setAccessible(flag);
						}
					}
				}
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return list;
	}
	

}
