package com.wxc.mongodb.converter;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * Timestamp to util.date类型转换器
 * @author Administrator
 *
 */
public class TimestampConverter implements Converter<Date, Timestamp> {

	@Override
	public Timestamp convert(Date date) {
		if (date != null) {
			return new Timestamp(date.getTime());
		}
		return null;
	}

}
