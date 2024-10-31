package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.user.model.TrackingInfo;

public interface UserManangmentRepository extends JpaRepository<TrackingInfo, Long> {
	
	@Query(value = "select CARGO_ID, COURSE, DIRECTION, ESEAL, LATITUDE, LONGITUDE, SPEED, STATUS from cargo.tracking_info t where t.STATUS = 1", nativeQuery = true)
	List<TrackingInfo> getActiveTrakingList();
}
