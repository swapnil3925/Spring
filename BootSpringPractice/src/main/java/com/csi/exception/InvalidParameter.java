package com.csi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
public class InvalidParameter extends Exception {

	public InvalidParameter(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
