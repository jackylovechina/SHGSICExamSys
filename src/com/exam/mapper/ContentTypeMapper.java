package com.exam.mapper;

import java.util.List;

import com.exam.pojo.ContentType;

public interface ContentTypeMapper {
	
	public int insertContentType(String ContentName);
	
	public int deleteContentType(String ContentName);
	
	public int updateContentType(ContentType contentType);
	
	public List<ContentType> selectContentType();
	

}
