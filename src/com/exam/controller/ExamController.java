package com.exam.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.mapper.ExamMapper;
import com.exam.pojo.Exam;

@Controller
public class ExamController {

	@Autowired
	ExamMapper examMapper;

	@RequestMapping(value = "/insertExam")
	@ResponseBody
	public Map<String, Object> insertExam(HttpServletRequest request, HttpServletResponse response) {

		String examName = null;
		String startTime = null;
		String endTime = null;
		try {
			examName = new String((request.getParameter("examName")).getBytes("iso-8859-1"), "utf-8");
			startTime = new String((request.getParameter("startTime")).getBytes("iso-8859-1"), "utf-8");
			endTime = new String((request.getParameter("endTime")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Exam exam = new Exam();
		exam.setExamName(examName);
		exam.setStartTime(startTime);
		exam.setEndTime(endTime);
		int i = examMapper.insertExam(exam);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", i);
		return result;
	}

	@RequestMapping(value = "/deleteExam")
	@ResponseBody
	public Map<String, Object> deleteExam(HttpServletRequest request, HttpServletResponse response) {

		String examName = null;
		try {
			examName = new String((request.getParameter("examName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = examMapper.deleteExam(examName);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", i);
		return result;

	}

	@RequestMapping(value = "/updateExam")
	@ResponseBody
	public Map<String, Object> updateExam(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));
		String examName = request.getParameter("examName");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		try {
			if (examName != null)
				examName = new String(examName.getBytes("iso-8859-1"), "utf-8");
			if (startTime != null)
				startTime = new String(startTime.getBytes("iso-8859-1"), "utf-8");
			if (endTime != null)
				endTime = new String(endTime.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		Exam exam = new Exam();
		exam.setID(id);
		exam.setExamName(examName);
		exam.setStartTime(startTime);
		exam.setEndTime(endTime);

		int i = examMapper.updateExam(exam);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", i);
		return result;
	}

	@RequestMapping(value = "/selectExam")
	@ResponseBody
	public List<Exam> selectExam(HttpServletRequest request, HttpServletResponse response) {

		List<Exam> exams = examMapper.selectExam();

		return exams;
	}
}
