package com.three2one.springbootthree2onetest.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "course_name")
	private String courseName;

	@Column(name = "description")
	private String description;

	@Column(name = "publish_date")
	private Date publishDate;

	@Column(name = "last_update")
	private Date lastUpdate;

	@Column(name = "total_hour")
	private Long totalHour;

	@Column(name = "instractor")
	private String instractor;

	@ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "courses")
	@JsonIgnoreProperties({ "courses" })
	private Set<Student> students = new HashSet<>();

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Long getTotalHour() {
		return totalHour;
	}

	public void setTotalHour(Long totalHour) {
		this.totalHour = totalHour;
	}

	public String getInstractor() {
		return instractor;
	}

	public void setInstractor(String instractor) {
		this.instractor = instractor;
	}

}
