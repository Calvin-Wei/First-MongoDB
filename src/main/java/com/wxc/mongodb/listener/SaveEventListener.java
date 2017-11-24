package com.wxc.mongodb.listener;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.wxc.mongodb.annotation.AutoIncKey;
import com.wxc.mongodb.entity.SeqInfo;

@Component
public class SaveEventListener extends AbstractMongoEventListener<Object> {
	@Autowired
	private MongoTemplate mongo;

	@Override
	public void onBeforeConvert(Object source) {
		if (source != null) {
			ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {

				@Override
				public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
					ReflectionUtils.makeAccessible(field);
					if (field.isAnnotationPresent(AutoIncKey.class)) {
						field.set(source, getNextId(source.getClass().getSimpleName()));
					}
				}
			});
		}
	}

	/**
	 * 获取下一个自增ID
	 * 
	 * @param colName
	 * @return
	 */
	private Long getNextId(String colName) {
		Query query = new Query();
		Update update = new Update();
		update.inc("seqId", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.upsert(true);
		options.returnNew(true);
		SeqInfo seq = mongo.findAndModify(query, update, options, SeqInfo.class);
		return seq.getSeqId();
	}
}
