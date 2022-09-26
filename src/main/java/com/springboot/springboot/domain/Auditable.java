package com.springboot.springboot.domain;
import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public class Auditable {

    private String Created;
    private String Modified;
    private LocalDateTime CreatedBy;
    private LocalDateTime ModifiedBy;
    
    public Auditable() {
        Created = null;
        CreatedBy = null;
        Modified = null;
        ModifiedBy = null;
    }

    public Auditable(String created, LocalDateTime createdBy) {
        Created = created;
        CreatedBy = createdBy;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String created) {
        Created = created;
    }

    public LocalDateTime getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(LocalDateTime createdBy) {
        CreatedBy = createdBy;
    }

    public String getModified() {
        return Modified;
    }

    public void setModified(String modified) {
        Modified = modified;
    }

    public LocalDateTime getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(LocalDateTime modifiedBy) {
        ModifiedBy = modifiedBy;
    }
}

