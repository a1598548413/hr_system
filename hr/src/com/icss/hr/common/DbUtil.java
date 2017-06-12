package com.icss.hr.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import oracle.jdbc.driver.OracleDriver;

/**
 * ���ݿ⹤����
 * 
 * @author Administrator
 *
 */
public class DbUtil {

	private static ComboPooledDataSource dataSource;// ����Դ����

	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();// �����̶߳���

	static {
		try {
			dataSource = new ComboPooledDataSource();

			// ���Ӳ�������
			dataSource.setUser("myhr");// �û���
			dataSource.setPassword("myhr");// ����
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe"); // �����ַ���
			dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver"); // ������

			// ���ӳ�����
			dataSource.setInitialPoolSize(5); // ��ʼ������
			dataSource.setMinPoolSize(5); // ���ӳ����ٱ�������������
			dataSource.setMaxPoolSize(10); // ���ӳ���������������
			dataSource.setMaxIdleTime(60); // ������ʱ��60��

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ͨ�����ӳض��󷵻����ݿ�����
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		// ��threadLocal������Ӷ���
		Connection conn = threadLocal.get();		

		// ������Ӷ��󲻴��ڻ������Ѿ����رյģ��ʹ����ӳ�ȡ��һ�����Ӷ��󷵻أ�����Ѿ����ڣ���ֱ�ӷ���
		if (conn == null || conn.isClosed()) {
			conn = dataSource.getConnection();
			// ���õ�threadLocal��
			threadLocal.set(conn);
		}

		// �������
		//System.out.println("������ݿ����ӣ�" + conn + "ʣ�����������=" + dataSource.getNumIdleConnections());

		return conn;

	}

	/**
	 * ͨ�ùر����ӷ���
	 */
	public static void close() {
		// �ӱ����߳��л������
		Connection conn = threadLocal.get();

		try {
			// �����Ӳ�Ϊ�� �� û�ر�ʱ
			if (conn != null && !conn.isClosed()) {
				// �����
				threadLocal.set(null);
				// �ر�����
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}