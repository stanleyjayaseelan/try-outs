package com.stanley.autocomplete.autocomplete.datasource.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DictionaryEntity {

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String word;
}
