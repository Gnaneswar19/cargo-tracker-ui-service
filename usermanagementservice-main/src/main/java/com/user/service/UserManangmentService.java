package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.TrackingInfo;
import com.user.repository.UserManangmentRepository;

@Service("trackerManagementService")
public class UserManangmentService {
	
	@Autowired
	UserManangmentRepository userManangmentRepository;

	public List<TrackingInfo> getTracingInfoList() {
		List<TrackingInfo> list = userManangmentRepository.getActiveTrakingList();
		if(list.size() > 0 && list != null) {
			return list;
		}
		return null;
	}
	
	public List<TrackingInfo> getTracingInfoList() {
		List<TrackingInfo> list = userManangmentRepository.getActiveTrakingList();
		if(list.size() > 0 && list != null) {
			return list;
		}
		return null;
	}
}
