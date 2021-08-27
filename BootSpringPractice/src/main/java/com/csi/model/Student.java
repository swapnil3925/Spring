package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private int studId;

	private String studName;

	private long studContactNumber;

	private String studEmailId;

	private String studAddress;

}
