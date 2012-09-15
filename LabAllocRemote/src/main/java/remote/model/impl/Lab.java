package remote.model.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table
public class Lab implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 843804566806801109L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer idLab;
	
	@Column(unique=true)
	private String nameLab;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="labAllocated")
	@Cascade(value={CascadeType.ALL,CascadeType.DELETE_ORPHAN})
	private List<Allocation> allocationsFromLab;

	public Integer getIdLab() {
		return idLab;
	}

	public void setIdLab(Integer idLab) {
		this.idLab = idLab;
	}

	public String getNameLab() {
		return nameLab;
	}

	public void setNameLab(String nameLab) {
		this.nameLab = nameLab;
	}

	public List<Allocation> getAllocationsFromLab() {
		return allocationsFromLab;
	}

	public void setAllocationsFromLab(List<Allocation> allocationsFromLab) {
		this.allocationsFromLab = allocationsFromLab;
	}
	
	
	

}
