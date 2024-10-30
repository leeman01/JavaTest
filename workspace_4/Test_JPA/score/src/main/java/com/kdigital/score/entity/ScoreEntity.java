package com.kdigital.score.entity;

import com.kdigital.score.dto.ScoreDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name="student")
public class ScoreEntity {
	@Id
	@Column(name="stid",nullable=false)
	private String stId;
	@Column(name="stname")
	private String stName;
	@Column(name="korean")
	private int korean;
	@Column(name="english")
	private int english;
	@Column(name="math")
	private int math;
	public static ScoreEntity toEntity(ScoreDTO scoreDTO) {
		return ScoreEntity.builder()
		.stId(scoreDTO.getStId())
		.stName(scoreDTO.getStName())
		.korean(scoreDTO.getKorean())
		.english(scoreDTO.getEnglish())
		.math(scoreDTO.getMath())
		.build();
	}
}
