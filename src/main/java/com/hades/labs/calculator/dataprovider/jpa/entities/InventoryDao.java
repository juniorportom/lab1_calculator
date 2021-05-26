package com.hades.labs.calculator.dataprovider.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Getter
@Setter
@Table(name = "DOJO_INVENTORY")
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDao {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "price")
    private Double price;

}
