package com.kh.spring12.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "station")
@SequenceGenerator(
	name = "station_seq",
	sequenceName = "station_seq",
	initialValue = 1,
	allocationSize = 1
)

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Station {
	@Id
	@GeneratedValue(generator = "station_seq")
	private Long stationNo;
	@Column(nullable = false, unique = true, length = 30)
	private String stationName;
	@Column(nullable = false, length = 90)
	private String subwayLine;
	@Column
	private String location; //위치 (동)
	@CreationTimestamp
	private LocalDateTime ctime;
	@UpdateTimestamp
	private LocalDateTime utime;
}
