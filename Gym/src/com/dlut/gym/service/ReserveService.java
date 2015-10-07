package com.dlut.gym.service;

import java.util.*;

public class ReserveService extends BaseService {
	/**
	 * 
	 * @param paramList (venuesId, userId, location, startTime, endTime)
	 * @return �û�ԤԼ�������������ݿ����Ӱ������
	 */
	public int makeReserve(List<Object> paramList) {
		String sql = "insert into tbl_record(venues_id,user_id,location,"
				+ "order_start_time,order_end_time) values(?,?,?,?,?)";
		return this.execute(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (recordId)
	 * @return �û�ȡ��ԤԼ���������ݿ����Ӱ������
	 */
	public int cancelReserve(List<Object> paramList) {
		String sql = "delete from tbl_record where id = ?";
		return this.execute(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (venuesId, location, startTime)
	 * @return ����ʱ�Σ���ѡ�����Ƿ��Ѿ���ԤԼ������ͬһ����ͬһʱ����ʹ��
	 */
	public int checkReserve(List<Object> paramList) {
		String sql = "select count(*) from tbl_record where venues_id = ? and"
				+ " location=? and order_start_time = ?";
		return this.getCount(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (userId, startTime, endTime)
	 * @return ��ȡ�û��ض�ʱ����ڵ�ԤԼ��¼���������� v_name�����غ� location��ԤԼ��ʼʱ�� order_start_time��
	 * ����ʱ�� order_end_time
	 */
	public List<Map<String, String>> getReserve(List<Object> paramList) {
		String sql = "select v.v_name,r.location,r.order_start_time,r.order_end_time "
				+ "	from tbl_venues v,tbl_record r where v.id = r.venues_id "
				+ " and r.user_id=? and r.order_start_time >= ? and r.order_end_time <= ?"
				+ " order by r.order_start_time desc";
		return this.getQueryList(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (userId, queryDay)
	 * @return ��ȡ�û�ָ�����ڵ�ԤԼ��¼���������� v_name�����غ� location��ԤԼ��ʼʱ�� order_start_time��
	 * ����ʱ�� order_end_time
	 */
	public List<Map<String, String>> getReserveByDate(List<Object> paramList) {
		String sql = "select v.v_name,r.location,r.order_start_time,r.order_end_time "
				+ "	from tbl_venues v,tbl_record r where v.id = r.venues_id "
				+ " and r.user_id=? and date(r.order_start_time) = ? "
				+ " order by r.order_start_time desc";
		return this.getQueryList(sql, paramList);
	}
}
