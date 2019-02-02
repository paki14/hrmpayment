package com.sgic.trainer.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;

import com.sgic.trainer.enums.RoleName;


@Entity
@Table(name = "role", schema = "payment")
public class Role implements Serializable {
  /**
  	 * 
  	 */
  private static final long serialVersionUID = -4287459510756933063L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @NaturalId
  @Column(name = "rolename", length = 60)
  private RoleName name;

  public Role() {

  }

  public Role(RoleName name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RoleName getName() {
    return name;
  }

  public void setName(RoleName name) {
    this.name = name;
  }

}
