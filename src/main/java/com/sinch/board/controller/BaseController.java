package com.sinch.board.controller;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Sunilkumar Mohandas
 *
 */
@Transactional(propagation = Propagation.REQUIRED)
public abstract class BaseController {

	protected List<String> getErrorMessages(BindingResult errors) {
		return errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(Collectors.toList());
	}
}
