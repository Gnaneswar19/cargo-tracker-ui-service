package com.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.TrackingInfo;
import com.user.service.UserManangmentService;


@RestController
@RequestMapping("/api/tracker-monitor-service")
public class UserManangementController {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(UserManangementController.class);

	@Autowired
	UserManangmentService userManagementService;

	@GetMapping("")
	public ResponseEntity<List<TrackingInfo>> getActiveTrakerDetails() {
		try {
			log.info("save tracker details");
			return new ResponseEntity<>(userManagementService.getTracingInfoList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/latest-tracker-details")
	public ResponseEntity<List<TrackingInfo>> getLatestActiveTrakerDetails(@RequestParam("lastTimeStamp") String lastTimeStamp) {
		try {
			log.info("save tracker details");
			return new ResponseEntity<>(userManagementService.getLatestTracingInfoList(lastTimeStamp), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * @PutMapping("/tutorials/{id}") public ResponseEntity<Tutorial>
	 * updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
	 * Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
	 * 
	 * if (tutorialData.isPresent()) { Tutorial _tutorial = tutorialData.get();
	 * _tutorial.setTitle(tutorial.getTitle());
	 * _tutorial.setDescription(tutorial.getDescription());
	 * _tutorial.setPublished(tutorial.isPublished()); return new
	 * ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK); } else {
	 * return new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */

	
}
