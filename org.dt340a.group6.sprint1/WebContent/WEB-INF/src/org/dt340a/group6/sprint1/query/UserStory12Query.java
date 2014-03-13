package org.dt340a.group6.sprint1.query;

import java.util.Date;
import java.util.List;

import org.dt340a.group6.sprint1.entity.CallFailure;
import org.dt340a.group6.sprint1.persistence.PersistenceUtil;

public class UserStory12Query {
	
	public UserStory12Query() {
		
	}
	
	//CallFailure.findAllIMSIsWithCallFailureGivenTime
	public List<CallFailure> findAllIMSIsWithCallFailureGivenTime(Date startDateTime, Date endDateTime){
		return PersistenceUtil.findAllIMSIsWithCallFailureGivenTime(startDateTime, endDateTime);
	}
}
