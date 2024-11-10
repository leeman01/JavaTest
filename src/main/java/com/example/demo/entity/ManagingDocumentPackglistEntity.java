package com.example.demo.entity;



import com.example.demo.dto.ManagingDocumentPackglistDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="managing_document_packinglist")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagingDocumentPackglistEntity  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="document_ptr_id")
	private ManagingDocumentParentEntity entity;
	
	@Column(name="packing_list_number")
	private String PackingListNumber;
	
	public static ManagingDocumentPackglistEntity ToEntity(ManagingDocumentPackglistDto dto) {
		return ManagingDocumentPackglistEntity.builder()
				.id(dto.getId())
				.entity(dto.getEntity())
				.PackingListNumber(dto.getPackingListNumber())
				.build();
	}
}
