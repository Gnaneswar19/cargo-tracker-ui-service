package com.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.TrackingInfo;
import com.user.repository.UserManangmentRepository;

@Service("trackerManagementService")
public class UserManangmentService {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(UserManangmentService.class);
	
	@Autowired
	UserManangmentRepository userManangmentRepository;

	public List<TrackingInfo> getTracingInfoList() {
		List<TrackingInfo> list = userManangmentRepository.findAll();
		if(list.size() > 0 && list != null) {
			return list;
		}
		return null;
	}
	
	public List<TrackingInfo> getLatestTracingInfoList(String lastTimeStamp) {
		List<TrackingInfo> list = userManangmentRepository.getLatestActiveTrakingList(lastTimeStamp);
		if(list.size() > 0 && list != null) {
			return list;
		}
		return null;
	}
}
