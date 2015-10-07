package com.dlut.gym.service;

import java.util.*;

public class SportService extends BaseService {
	/**
	 * 
	 * @return �˶���Ŀ id���˶���Ŀ���� name
	 */
	public List<Map<String, String>> getSportInfo() {
		String sql = "select id, name from tbl_sport";
		return this.getQueryList(sql, null);
	}
	
	/**
	 * 
	 * @param paramList (sportId)
	 * @return ����ָ���˶���Ŀ�������� id���������� v_name
	 */
	public List<Map<String, String>> getSportVenues(List<Object> paramList) {
		String sql = "select id, v_name from tbl_sport where sport_id = ?";
		return this.getQueryList(sql, paramList);
	}
}
