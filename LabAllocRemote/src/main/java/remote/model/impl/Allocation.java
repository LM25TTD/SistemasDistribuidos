package remote.model.impl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Allocation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8251876054332507704L;
	/**
	 * 
	 */
	private static final Integer STATUS_NEW=1;
	private static final Integer STATUS_OLD=2;
	private static final Integer STATUS_CANCELLED=3;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer idAllocation;
	
	@Column
	private String allocationOwner;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	
	@Column
	private Integer status;

	@ManyToOne
	private Lab labAllocated;

	public Integer getIdAllocation() {
		return idAllocation;
	}

	public void setIdAllocation(Integer idAllocation) {
		this.idAllocation = idAllocation;
	}

	public String getAllocationOwner() {
		return allocationOwner;
	}

	public void setAllocationOwner(String allocationOwner) {
		this.allocationOwner = allocationOwner;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Lab getLabAllocated() {
		return labAllocated;
	}

	public void setLabAllocated(Lab labAllocated) {
		this.labAllocated = labAllocated;
	}
	
	
}
