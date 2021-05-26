package karmanchik.clientservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    protected Integer id;
}
