package com.apec.pos.entity;

import java.util.Date;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "create_by")
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    // Constructors, getters, and setters (you can generate them automatically or write them manually)

    // Constructor with createBy and modifiedBy arguments
    public BaseEntity(String createBy, String modifiedBy) {
        this.createDate = new Date();
        this.modifiedDate = new Date();
        this.createBy = createBy;
        this.modifiedBy = modifiedBy;
    }

    public BaseEntity() {
    }

 
    public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	// Custom method to update modified date and modified by
    @PreUpdate
    protected void onUpdate() {
        this.modifiedDate = new Date();
        // You can get the current user or system user here and set the modifiedBy field accordingly
        // For example: this.modifiedBy = getCurrentUser();
    }
}
