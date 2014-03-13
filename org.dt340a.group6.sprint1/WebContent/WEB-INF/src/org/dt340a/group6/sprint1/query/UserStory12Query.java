package org.dt340a.group6.sprint1.query;

import java.util.Date;
import java.util.List;

import org.dt340a.group6.sprint1.entity.CallFailure;
import org.dt340a.group6.sprint1.persistence.PersistenceUtil;

public class UserStory12Query {
	
	public UserStory12Query() {
		
	}
	
	public List<CallFailure> findAllIMSIsWithCallFailureGivenTime(Date startDateTime, Date endDateTime){
		return PersistenceUtil.findAllIMSIsWithCallFailureGivenTime(startDateTime, endDateTime);
	}
	
	public List<CallFailure> findAll(){
		return PersistenceUtil.findAll();
	}
	
	public List<CallFailure> findAllBetween(Date startDateTime, Date endDateTime){
		return PersistenceUtil.findAllBetween(startDateTime, endDateTime);
	}
	
	
	public List<CallFailure> findCountOfOccurancesForGivenIMSI(String imsi){
		return PersistenceUtil.findCountOfOccurancesForGivenIMSI(imsi);
	}

}
