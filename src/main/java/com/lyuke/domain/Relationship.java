package com.lyuke.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Lyuke
 * @Date 2017-03-26 06:15
 */
@Entity
@Table(name="t_relationship")
public class Relationship {
	@Id
	@Column(name="rs_id")
	private String relationshipId;
	
	@JoinColumn(name="rs_fromuser",referencedColumnName="users_id", nullable=false, updatable=false)
	@OneToOne(optional=false,targetEntity=User.class)
	private User fromUserId;
	
	@JoinColumn(name="rs_touser",referencedColumnName="users_id",nullable=false, updatable=false)
	@OneToOne(optional=false,targetEntity=User.class)
	private User toUserId;

	public String getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(String relationshipId) {
		this.relationshipId = relationshipId;
	}

	public User getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(User fromUserId) {
		this.fromUserId = fromUserId;
	}

	public User getToUserId() {
		return toUserId;
	}

	public void setToUserId(User toUserId) {
		this.toUserId = toUserId;
	}
	
	
}
