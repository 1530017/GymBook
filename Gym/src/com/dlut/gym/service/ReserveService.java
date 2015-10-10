package com.dlut.gym.service;

import java.util.*;

public class ReserveService extends BaseService {
	/**
	 * �û�ԤԼ����
	 * @param paramList (venuesId, userId, location, startTime, endTime)
	 * @return �������ݿ����Ӱ������
	 */
	public int makeReserve(List<Object> paramList) {
		String sql = "insert into tbl_record(venuesId, userId, location,"
				+ " startTime, endTime) values(?, ?, ?, ?, ?)";
		return this.execute(sql, paramList);
	}
	
	/**
	 * �û�ȡ��ԤԼ
	 * @param paramList (recordId)
	 * @return �������ݿ����Ӱ������
	 */
	public int cancelReserve(List<Object> paramList) {
		String sql = "delete from tbl_record where recordId = ?";
		return this.execute(sql, paramList);
	}
	
	/**
	 * ����ʱ�Σ���ѡ�����Ƿ��Ѿ���ԤԼ������ͬһ����ͬһʱ����ʹ��
	 * @param paramList (venuesId, location, startTime)
	 * @return ��ʱ�Σ���ѡ���ص�ԤԼ��Ŀ�����Ϊ 0 ����ɽ���ԤԼ
	 */
	public int checkReserve(List<Object> paramList) {
		String sql = "select count(*) from tbl_record where venuesId = ? and"
				+ " location = ? and startTime = ?";
		return this.getCount(sql, paramList);
	}
	
	/**
	 * ��ȡ�û��ض�ʱ����ڵ�ԤԼ��¼
	 * @param paramList (userId, startTime, endTime)
	 * @return ԤԼ�� recordId ���������� venuesName�����غ� location��ԤԼ��ʼʱ�� startTime��
	 * ����ʱ�� endTime
	 */
	public List<Map<String, String>> getReserve(List<Object> paramList) {
		String sql = "select r.recordId, v.venuesName, r.location, r.startTime, r.endTime "
				+ "	from tbl_venues v,tbl_record r where v.venuesId = r.venuesId "
				+ " and r.userId = ? and r.startTime >= ? and r.endTime <= ?"
				+ " order by r.startTime desc";
		return this.getQueryList(sql, paramList);
	}
	
	/**
	 * ��ȡ�û�ָ�����ڵ�ԤԼ��¼
	 * @param paramList (userId, queryDay)
	 * @return ԤԼ�� recordId ���������� venuesName�����غ� location��ԤԼ��ʼʱ�� startTime��
	 * ����ʱ�� endTime
	 */
	public List<Map<String, String>> getReserveByDate(List<Object> paramList) {
		String sql = "select r.recordId, v.venuesName, r.location, r.startTime, r.endTime "
				+ "	from tbl_venues v,tbl_record r where v.venuesId = r.venuesId "
				+ " and r.userId = ? and date(r.startTime) = ? order by r.startTime desc";
		return this.getQueryList(sql, paramList);
	}
}
