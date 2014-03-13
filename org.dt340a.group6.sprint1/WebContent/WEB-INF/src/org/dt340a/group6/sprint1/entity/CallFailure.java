package org.dt340a.group6.sprint1.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
 @NamedQuery(name = "CallFailure.findByIMSI", query = "select o from CallFailure o where o.iMSI=:IMSI"),
 @NamedQuery(name = "CallFailure.findAll", query = "select o from CallFailure o order by o.iMSI"),
 @NamedQuery(name = "CallFailure.findAllBetween", query = "select o from CallFailure o where o.dateTime between :startDateTime and :endDateTime order by o.iMSI"),
 @NamedQuery(name = "CallFailure.findCountOfOccurancesForGivenIMSI", query = "select count(*) from CallFailure o where o.iMSI=:IMSI"),
// @NamedQuery(name = "CallFailure.findAllBetweenCountOfEach", query = "select new List(o.imsi, count(o)) from (select o from CallFailure o where o.dateTime between :startDateTime and :endDateTime order by o.iMSI) group by iMSI"),
 // @NamedQuery(name = "CallFailure.findAllBetweenCountOfEach", query = "select imsi, count(*) from (select o from CallFailure o where o.dateTime between :startDateTime and :endDateTime order by o.iMSI) group by iMSI"),
 //USER STORY 12 : select IMSI, dateTime from (select IMSI, dateTime from callfailure o where o.dateTime > '2013-01-11 17:15:00' group by iMSI) b where b.dateTime < '2013-01-11 17:18:00';
// @NamedQuery(name = "CallFailure.findAllIMSIsWithCallFailureGivenTime", query = "select b.imsi, b.dateTime from (select a.iMSI, a.dateTime from CallFailure a where a.dateTime>:startDateTime group by a.iMSI) b where b.dateTime<:endDateTime"),
})

@Entity
public class CallFailure {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int baseDataID;
	private Date dateTime;
	@ManyToOne
	private Cause cause;
	@ManyToOne
	private FailureClass failureClass;
	@ManyToOne
	private Equipment equipment;
	@ManyToOne
	private CountryOperator countryOperator;
	private int cellId;
	private int duration;
	private String nEVersion;
	private String iMSI;
	private String hier3;
	private String hier32;
	private String hier321;

	public CallFailure() {

	}

	private CallFailure(Builder builder) {
		this.dateTime = builder.dateTime;
		this.cause = builder.cause;
		this.failureClass = builder.failureClass;
		this.equipment = builder.equipment;
		this.countryOperator = builder.countryOperator;
		this.cellId = builder.cellId;
		this.duration = builder.duration;
		this.nEVersion = builder.nEVersion;
		this.iMSI = builder.iMSI;
		this.hier3 = builder.hier3;
		this.hier32 = builder.hier32;
		this.hier321 = builder.hier321;
	}

	public static class Builder {
		private Date dateTime;
		private Cause cause;
		private FailureClass failureClass;
		private Equipment equipment;
		private CountryOperator countryOperator;
		private int cellId;
		private int duration;
		private String nEVersion;
		private String iMSI;
		private String hier3;
		private String hier32;
		private String hier321;

		public Builder() {
			super();
		}

		public Builder dateTime(Date dateTime) {
			this.dateTime = dateTime;
			return this;
		}

		public Builder cause(Cause cause) {
			this.cause = cause;
			return this;
		}

		public Builder failureClass(FailureClass failureClass) {
			this.failureClass = failureClass;
			return this;
		}

		public Builder equipment(Equipment equipment) {
			this.equipment = equipment;
			return this;
		}

		public Builder countryOperator(CountryOperator countryOperator) {
			this.countryOperator = countryOperator;
			return this;
		}

		public Builder cellId(int cellId) {
			this.cellId = cellId;
			return this;
		}

		public Builder duration(int duration) {
			this.duration = duration;
			return this;
		}

		public Builder nEVersion(String nEVersion) {
			this.nEVersion = nEVersion;
			return this;
		}

		public Builder iMSI(String iMSI) {
			this.iMSI = iMSI;
			return this;
		}

		public Builder hier3(String hier3) {
			this.hier3 = hier3;
			return this;
		}

		public Builder hier32(String hier32) {
			this.hier32 = hier32;
			return this;
		}

		public Builder hier321(String hier321) {
			this.hier321 = hier321;
			return this;
		}

		public CallFailure build() {
			return new CallFailure(this);
		}

	}

	public int getBaseDataID() {
		return baseDataID;
	}

	public void setBaseDataID(int baseDataID) {
		this.baseDataID = baseDataID;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Cause getCause() {
		return cause;
	}

	public void setCause(Cause cause) {
		this.cause = cause;
	}

	public FailureClass getFailureClass() {
		return failureClass;
	}

	public void setFailureClass(FailureClass failureClass) {
		this.failureClass = failureClass;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public CountryOperator getCountryOperator() {
		return countryOperator;
	}

	public void setCountryOperator(CountryOperator countryOperator) {
		this.countryOperator = countryOperator;
	}

	public int getCellId() {
		return cellId;
	}

	public void setCellId(int cellId) {
		this.cellId = cellId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getnEVersion() {
		return nEVersion;
	}

	public void setnEVersion(String nEVersion) {
		this.nEVersion = nEVersion;
	}

	public String getiMSI() {
		return iMSI;
	}

	public void setiMSI(String iMSI) {
		this.iMSI = iMSI;
	}

	public String getHier3() {
		return hier3;
	}

	public void setHier3(String hier3) {
		this.hier3 = hier3;
	}

	public String getHier32() {
		return hier32;
	}

	public void setHier32(String hier32) {
		this.hier32 = hier32;
	}

	public String getHier321() {
		return hier321;
	}

	public void setHier321(String hier321) {
		this.hier321 = hier321;
	}

}
