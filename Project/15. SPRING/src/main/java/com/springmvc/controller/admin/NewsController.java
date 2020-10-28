package com.springmvc.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dto.NewsDTO;
import com.springmvc.service.ICategoryService;
import com.springmvc.service.INewService;
import com.springmvc.util.MessageUtils;

@Controller(value = "admin-news-controller")
public class NewsController {
	
	@Autowired
	private INewService newService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private MessageUtils messageUtils;
	
	@RequestMapping(value = "/admin/news/list", method = RequestMethod.GET)
	public ModelAndView listNews(@RequestParam("page") int page, 
								@RequestParam("limit") int limit, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("admin/news/list");
		NewsDTO newsDTO = new NewsDTO();
		newsDTO.setPage(page);
		newsDTO.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		newsDTO.setListResult(newService.findAll(pageable));
		newsDTO.setTotalItem(newService.getTotalItem());
		newsDTO.setTotalPage((int) Math.ceil((double) newsDTO.getTotalItem() / newsDTO.getLimit()));
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", newsDTO);
		return mav;
	}
	
	@RequestMapping(value = "/admin/news/edit", method = RequestMethod.GET)
	public ModelAndView editNews(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/news/edit");
		NewsDTO model = new NewsDTO();
		if(id != null) {
			model = newService.findById(id);
		}
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}
}
