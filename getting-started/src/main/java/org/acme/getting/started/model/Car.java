package org.acme.getting.started.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Car extends PanacheEntity {

    public String name;
    public String brand;
}
