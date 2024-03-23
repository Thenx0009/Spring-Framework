package com.example.demo.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface CourseCode {

//	public String value() default "LUV";
	String value() default "LUV";
	
	public String message() default "must start with LUV";
	
	//define default groups 
	public Class<?>[] groups() default {};
	
	//define default payloads 
	public Class<? extends Payload>[] payload() default{};

	

	
}
