package com.javatechie.api.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;


@Entity
@Table(name="USERS_TBL")
@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor

public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private int age;
	private String nationality;
	
}
