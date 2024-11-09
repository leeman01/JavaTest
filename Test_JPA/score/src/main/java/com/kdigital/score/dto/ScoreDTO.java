package com.kdigital.score.dto;

import com.kdigital.score.entity.ScoreEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreDTO {
	private String stId;
	private String stName;
	private int korean;
	private int english;
	private int math;
	public static ScoreDTO toDTO(ScoreEntity scoreEntity) {
		return ScoreDTO.builder()
				.stId(scoreEntity.getStId())
				.stName(scoreEntity.getStName())
				.korean(scoreEntity.getKorean())
				.english(scoreEntity.getEnglish())
				.math(scoreEntity.getMath())
				.build();
	}
}
