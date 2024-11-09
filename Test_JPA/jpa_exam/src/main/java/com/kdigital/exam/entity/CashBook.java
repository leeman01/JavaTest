package com.kdigital.exam.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="cashbook")
public class CashBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seq;
	@CreationTimestamp
	private LocalDateTime today;
	@Column(name="item_type")
	@Enumerated(EnumType.STRING)
	private ItemType itemtype;
	private String detail;
	private Integer amount;
	private String note;
	// 생성자 정의 (Insert 할때 seq를 사용하지 않아서)
	public CashBook(ItemType itemtype, String detail, Integer amount, String note) {
		super();
		this.itemtype = itemtype;
		this.detail = detail;
		this.amount = amount;
		this.note = note;
	}
	@Override
	public String toString() {
	
		return this.seq + "/"+this.today + "/" + this.note + "/" + this.amount +"/" + this.detail ;
	}
}
