package com.dlut.gym.service;

import java.util.*;
public class VenuesService extends BaseService {
	/**
	 * 
	 * @return ���� id�� ������ v_name�� ������ num�� ���ݷ��� charge�� ����ʱ�� open_time�� �չ�ʱ�� close_time
	 */
	public List<Map<String, String>> getVenuesInfo() {
		String sql = "select id, v_name, num, charge, time(open_time) open_time, "
				+ "time(close_time) close_time from tbl_venues where is_open = 1";
		return this.getQueryList(sql, null);
	}
	
	/**
	 * 
	 * @param paramList (venuesId)
	 * @return ָ������ id�������� v_name�������� num 
	 */
	public Map<String, String> getVenuesInfo(List<Object> paramList) {
		String sql = "select id, v_name, num  from tbl_venues where id = ?";
		return this.getQueryMap(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (venuesId, queryDay)
	 * @return ָ�����ݣ�ָ�����ڣ��Ѿ�ԤԼ���ض�Ӧ��ԤԼ id���û� user_id�����غ� location��ԤԼ��ʼʱ�� order_start_time������ʱ�� order_end_time
	 */
	public List<Map<String, String>> getVenuesRecord(List<Object> paramList) {
		String sql = "select id, user_id, location, time(order_start_time) order_start_time,"
				+ "time(order_end_time) order_end_time from tbl_record where venues_id = ? and "
				+ "date(order_start_time) = ?";
		return this.getQueryList(sql, paramList);
	}
	
	/**
	 * 
	 * @param paramList (venuesId, queryDay, queryTime)
	 * @return ָ�����ݣ�ָ�����ڣ�ָ��ʱ��Σ��Ѿ�ԤԼ���ض�Ӧ��ԤԼ id���û� user_id�����غ� location��ԤԼ��ʼʱ�� order_start_time������ʱ�� order_end_time
	 */
	public List<Map<String, String>> getVenuesRecordByTime(List<Object> paramList) {
		String sql = "select id, user_id, location, time(order_start_time) order_start_time,"
				+ "time(order_end_time) order_end_time from tbl_record where venues_id = ? and "
				+ "date(order_start_time) = ? and time(order_start_time) = ?";
		return this.getQueryList(sql, paramList);
	}
}
