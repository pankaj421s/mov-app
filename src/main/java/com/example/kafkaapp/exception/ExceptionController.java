package com.example.kafkaapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoCommandException;

@ControllerAdvice
@RestController
public class ExceptionController {
	@ExceptionHandler(MongoCommandException.class)
public String CollectionExistsControler(Exception e)
{
		System.out.println(e);
		System.out.println("In exception handler");
	return "mongo command exception";
}
}
