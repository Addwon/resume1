package com.week2challenge.resume;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Size(min=2)
    String type;
    @NotNull
    @Size(min=2)
    String level;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
