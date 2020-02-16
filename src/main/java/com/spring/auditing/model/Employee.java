package com.spring.auditing.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE")
@Audited
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date doj;
	private String dept;
	private double salary;

	@CreatedDate
	private Date createDate;
	@LastModifiedDate
	private Date lastModifiedDate;
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String modifiedBy;

}
