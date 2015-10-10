package com.dlut.gym.service;

import java.util.*;

public class UserService extends BaseService {
	/**
	 * �����û��˺Ų�ѯ����
	 * @param paramList (userId)
	 * @return �û����� password
	 */
	public String getPassword(List<Object> paramList) {
		String sql = "select password from tbl_user where userId = ?";
		Map<String, String> userMap = null;
		return (userMap = this.getQueryMap(sql, paramList)) != null ? userMap.get("password") : null;
	}
	
	/**
	 * �����û��˺Ų�ѯ�û����
	 * @param paramList (userId)
	 * @return �û���� userRole
	 */
	public String getRole(List<Object> paramList) {
		String sql = "select userRole from tbl_user where userId = ?";
		Map<String, String> userMap = null;
		return (userMap = this.getQueryMap(sql, paramList)) != null ? userMap.get("userRole") : null;
	}
	
	/**
	 * �����û� cookie
	 * @param paramList (userNameCookie, userId)
	 * @return �������ݿ����Ӱ������
	 */
	public int setCookie(List<Object> paramList) {
		String sql = "update tbl_user set cookie = ? where userId = ?";
		return this.execute(sql, paramList);
	}
	
	/**
	 * ��ѯ�û��ĸ�����Ϣ
	 * @param paramList (userId)
	 * @return �û� userId���û��� userName���û������� creditWorthiness
	 */
	public List<Map<String, String>> getUserInfo(List<Object> paramList){
		String sql = "select userId, userName, creditWorthiness from tbl_user where userId = ?";
		return this.getQueryList(sql, paramList);
	}
}
