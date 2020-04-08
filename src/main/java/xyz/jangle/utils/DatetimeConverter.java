package xyz.jangle.utils;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DatetimeConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		return Jutils.datetimeParser(source);
	}

}
