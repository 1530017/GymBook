package com.dlut.gym.service;

import java.util.*;

public class UserService extends BaseService {
	/**
	 * 
	 * @param paramList (id)
	 * @return �û����� password
	 */
	public Map<String, String> getPassword(List<Object> paramList) {
		String sql = "select password from tbl_user where id = ?";
		return this.getQueryMap(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (userId)
	 * @return �û���� role
	 */
	public Map<String, String> getRole(List<Object> paramList) {
		String sql = "select role from tbl_user where id = ?";
		return this.getQueryMap(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (userNameCookie, userId)
	 * @return �����û� cookie���������ݿ����Ӱ������
	 */
	public int setCookie(List<Object> paramList) {
		String sql = "update tbl_user set cookie = ? where id = ?";
		return this.execute(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (userId)
	 * @return �û� id���û��� name���û������� worthiness
	 */
	public List<Map<String, String>> getUserInfo(List<Object> paramList){
		String sql = "select id, name, worthiness from tbl_user where id = ?";
		return this.getQueryList(sql, paramList);
	}
}
