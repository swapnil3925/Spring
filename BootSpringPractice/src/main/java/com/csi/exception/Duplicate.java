package com.csi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.IM_USED)
public class Duplicate  extends Exception{
		public Duplicate(String msg) {
			// TODO Auto-generated constructor stub
			super(msg);
		}
	
} 
