package com.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.exceptions.FileIsNotImgException;
import com.example.pojo.Page;
import com.example.pojo.Survey;
import com.example.pojo.User;
import com.example.service.SurveyService;
import com.example.utils.DateUtils;
import com.example.utils.ImgUtil;
import com.example.utils.Tools;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	private static final String DEFUALT_PATH="static/image/daoMain.png";

	@Autowired
	private SurveyService surveyService;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/add/",method=RequestMethod.POST)
	public String newSurvey(Survey survey ,
			@RequestParam("file") MultipartFile file,
			HttpServletRequest request,
			HttpSession session) throws IOException{
		String path = DEFUALT_PATH;
		String filename = file.getOriginalFilename();
		if (file != null && filename != null && filename.length() > 0) {
			
			String contentType = file.getContentType();
			if (!contentType.startsWith("image")) {
				throw new FileIsNotImgException("请上传图片!");
			}
			
			InputStream inputStream = file.getInputStream();
			String realPath = request.getRealPath("/surveyLogo");
			System.out.println("图片logo路径 = "+realPath);
			path = ImgUtil.resizeImages(inputStream, realPath);
		}
		User loginUser = (User) Tools.getLoginUser(session);
		
		survey.setUserId(loginUser.getId());
		survey.setLogoPath(path);
		survey.setCreateTime(DateUtils.curDateStr8());
		survey.setStatus("0");
//		System.out.println(survey);
		surveyService.insert(survey);
		
		return "redirect:/survey/list/0";
	}
	
	@RequestMapping("/toUpdateSurvey/{id}")
	public String toUpdate(@PathVariable("id") int id,
			Map<String, Object> map){
		
		Survey survey = surveyService.selectByPrimaryKey(id);
		System.out.println("toUpdate + " +survey);
		map.put("survey", survey);
		
		return "survey/survey_update";
	}
	
	@RequestMapping(value="/update/{id}")
	public String updateSurvey(Survey survey ,
			@RequestParam("file") MultipartFile file,
			HttpServletRequest request,
			HttpSession session) throws IOException{
		System.out.println("update + " + survey);
		String path = DEFUALT_PATH;
		String filename = file.getOriginalFilename();
		if (file != null && filename != null && filename.length() > 0) {
			
			String contentType = file.getContentType();
			if (!contentType.startsWith("image")) {
				throw new FileIsNotImgException("请上传图片!");
			}
			
			InputStream inputStream = file.getInputStream();
			String realPath = request.getRealPath("/surveyLogo");
			System.out.println("图片logo路径 = "+realPath);
			path = ImgUtil.resizeImages(inputStream, realPath);
		}
		User loginUser = (User) Tools.getLoginUser(session);
		
		survey.setUserId(loginUser.getId());
		survey.setLogoPath(path);
		System.out.println("update2 + " + survey);
		
		surveyService.updateByPrimaryKeySelective(survey);
		return "redirect:/survey/list/0";
	}
	
	
	@RequestMapping("/list/{status}")
	public String surveyList(@PathVariable("status") String status,
			@RequestParam(value="nowPage",required=false) String nowPage,
			Map<String, Object> map,
			HttpSession session){
		
		User loginUser = (User) Tools.getLoginUser(session);
		
		Page<Survey> page = surveyService.getPage(status, nowPage, loginUser.getId());
		System.out.println(page);
		map.put("page", page);
		map.put("status", status);
		return "survey/survey_list";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteSurvey(@PathVariable("id") int id){
		int i = surveyService.deleteByPrimaryKey(id);
		return "redirect:/survey/list/0";
		
	}
	
	@RequestMapping("/toEdit/{id}")
	public String toEditSurvey(@PathVariable("id") int id,
			Map<String, Object> map){
		Survey survey = surveyService.selectAllBySurvey(id);
		map.put("survey", survey);
		return "survey/survey_edit";
	}
}
