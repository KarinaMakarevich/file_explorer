package com.epam.test_task.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class Model implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    public Model() {
        super();
    }

    public Model(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Model model = (Model) o;
        if (id == null) {
            if (model.id != null) {
                return false;
            }
        } else if (!id.equals(model.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 31 * ((id == null) ? 0 : id.hashCode());
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                '}';
    }
}
