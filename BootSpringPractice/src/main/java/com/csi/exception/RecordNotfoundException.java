package com.csi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RecordNotfoundException extends Exception{
	
	
	public RecordNotfoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

}
