package com.springboot.springboot.domain;
import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public class Auditable {

    private String CreatedBy;
    private String ModifiedBy;
    private LocalDateTime Created;
    private LocalDateTime Modified;
    
    public Auditable() {
        Created = null;
        CreatedBy = null;
        Modified = null;
        ModifiedBy = null;
    }

    public Auditable(String createdBy) {
        Created = LocalDateTime.now();
        CreatedBy = createdBy;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
        Modified   = LocalDateTime.now();
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public LocalDateTime getModified(){
        return Modified;
    }

    public LocalDateTime getCreated() {
        return Created;
    }
}

