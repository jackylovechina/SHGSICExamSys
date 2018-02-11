package com.exam.mapper;

import java.util.List;

import com.exam.pojo.Exam;

public interface ExamMapper {

	public int insertExam(Exam exam);

	public int deleteExam(String examName);

	public int updateExam(Exam exam);

	public List<Exam> selectExam();

}
