package com.dlut.gym.service;

import java.util.*;
public class VenuesService extends BaseService {
	/**
	 * ��ѯ���г��ݵ���Ϣ�б�
	 * @return ���� venuseId�� ������ venuesName�� ������ venuesNum�� ���ݷ��� venuesCharge�� ����ʱ�� openTime�� 
	 * �չ�ʱ�� closeTime
	 */
	public List<Map<String, String>> getVenuesInfo() {
		String sql = "select venuesId, venuesName, venuesNum, venuesCharge, time(openTime) openTime, "
				+ "time(closeTime) closeTime from tbl_venues where isOpen = 1";
		return this.getQueryList(sql, null);
	}
	
	/**
	 * ��ѯָ�����ݵ���Ϣ
	 * @param paramList (venuesId)
	 * @return ָ������ venuseId�� ������ venuesName�� ������ venuesNum�� ���ݷ��� venuesCharge�� ����ʱ�� openTime�� 
	 * �չ�ʱ�� closeTime
	 */
	public Map<String, String> getVenuesInfo(List<Object> paramList) {
		String sql = "select venuesId, venuesName, venuesNum, venuesCharge, time(openTime) openTime, "
				+ "time(closeTime) closeTime from tbl_venues where venuesId = ?";
		return this.getQueryMap(sql, paramList);
	}
	
	/**
	 * ��ѯָ�����ݣ�ָ�����ڶ�Ӧ��ԤԼ��Ϣ
	 * @param paramList (venuesId, queryDay)
	 * @return ԤԼ�� recordId���û� userId�����غ� location��ԤԼ��ʼʱ�� startTime������ʱ�� endTime
	 */
	public List<Map<String, String>> getVenuesRecord(List<Object> paramList) {
		String sql = "select recordId, userId, location, time(startTime) startTime,"
				+ "time(endTime) endTime from tbl_record where venuesId = ? and "
				+ "date(startTime) = ?";
		return this.getQueryList(sql, paramList);
	}
	
	/**
	 * ��ѯָ�����ݣ�ָ�����ڣ�ָ��ʱ��ζ�Ӧ��ԤԼ��Ϣ
	 * @param paramList (venuesId, queryDay, queryTime)
	 * @return ԤԼ�� recordId���û� userId�����غ� location��ԤԼ��ʼʱ�� startTime������ʱ�� endTime
	 */
	public List<Map<String, String>> getVenuesRecordByTime(List<Object> paramList) {
		String sql = "select recordId, userId, location, time(startTime) startTime,"
				+ "time(endTime) endTime from tbl_record where venuesId = ? and "
				+ "date(startTime) = ? and time(startTime) = ?";
		return this.getQueryList(sql, paramList);
	}
}
