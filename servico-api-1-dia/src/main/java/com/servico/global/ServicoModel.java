package com.servico.global;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;




@Entity
@Table(name="tb_servico")
	public class ServicoModel {
		
	

		@Id
		@Column
		@GeneratedValue(strategy=GenerationType.SEQUENCE)
		private Long id;
		
		@Column
		private String nome;
		
		@Column
		@JsonFormat(pattern="yyyy-MM-dd")
		private Date date;
		
		//getters e setters
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
		
		
}
