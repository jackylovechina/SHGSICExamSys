package com.exam.mapper;

import java.util.List;

import com.exam.pojo.QuestionType;

public interface QuestionTypeMapper {

	public int insertQuestionType(String typeName);

	public int deleteQuestionType(String typeName);

	public int updateQuestionType(QuestionType questionType);

	public List<QuestionType> selectQuestionType();

}
