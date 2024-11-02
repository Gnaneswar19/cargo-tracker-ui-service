package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.user.model.TrackingInfo;


public interface UserManangmentRepository extends JpaRepository<TrackingInfo, Long> {
	
	@Query(value = "select TRACKER_ID, CARGO_ID, SPEED, DIRECTION, COURSE, LONGITUDE, LATITUDE, ESEAL, STATUS, CREATED_DT, UPDATED_DT, INSERTED_By, UPDATED_BY, DEVICE_ID, VEHICLE_NO from cargo.tracking_info t where t.UPDATED_DT >= (:lastTimeStamp)", nativeQuery = true)
	List<TrackingInfo> getLatestActiveTrakingList(String lastTimeStamp);
}
