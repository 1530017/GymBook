package com.dlut.gym.service;

import java.util.*;

public class SportService extends BaseService {
	/**
	 * ��ѯ�����˶���Ŀ��Ϣ�б�
	 * @return �˶���Ŀ sportId���˶���Ŀ���� sportName
	 */
	public List<Map<String, String>> getSportInfo() {
		String sql = "select sportId, sportName from tbl_sport";
		return this.getQueryList(sql, null);
	}
	
	/**
	 * ��ѯ��ָ���˶���Ŀ�ĳ�����Ϣ�б�
	 * @param paramList (sportId)
	 * @return ����ָ���˶���Ŀ�ĳ��� venuesId�������� venuesName
	 */
	public List<Map<String, String>> getSportVenues(List<Object> paramList) {
		String sql = "select venuesId, venuesName from tbl_venues where sportId = ?";
		return this.getQueryList(sql, paramList);
	}
}
