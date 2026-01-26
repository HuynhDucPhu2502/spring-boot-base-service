package com.fis.spring_boot_base_service.infra.persistence.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity {

  @CreatedDate
  @Column(name = "created_at", nullable = false, updatable = false)
  private Long createdAt;

  @LastModifiedDate
  @Column(name = "updated_at")
  private Long updatedAt;

  @CreatedBy
  @Column(name = "created_by", length = 50, updatable = false)
  private String createdBy;

  @LastModifiedBy
  @Column(name = "updated_by", length = 100)
  private String updatedBy;
}
