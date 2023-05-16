package com.example.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class Account {
    @Id
    private String number;
    @Column(name = "balanace")
    private double balance;
}
