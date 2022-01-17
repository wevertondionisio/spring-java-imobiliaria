package com.gft.spring.imobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.spring.imobiliaria.entities.Business;
import com.gft.spring.imobiliaria.services.BusinessService;

@Controller
@RequestMapping("/home")
public class BusinessController {

	@Autowired
	private BusinessService businessService;

	@RequestMapping("/negocios")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Business> listBusiness = businessService.listAll(keyword);
		model.addAttribute("listBusiness", listBusiness);

		return "business/negocios";
	}

	@RequestMapping("/negocios/novo")
	public String showNewBusiness(Model model) {
		Business business = new Business();
		model.addAttribute("business", business);

		return "business/negocio";
	}

	@RequestMapping(value = "/negocios/save", method = RequestMethod.POST)
	public ModelAndView saveBusiness(@ModelAttribute("business") Business business) {
		businessService.save(business);
		ModelAndView mv = new ModelAndView("business/negocio");
		mv.addObject("mensagem", "salvo com sucesso");
		return mv;
	}

	@RequestMapping("/negocios/editar/{id}")
	public ModelAndView editarBusiness(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("business/editarNegocio");

		Business business = businessService.get(id);
		mav.addObject("business", business);
		return mav;
	}

	@RequestMapping("/negocios/deletar/{id}")
	public String deleteBusiness(@PathVariable(name = "id") Long id) {
		businessService.delete(id);
		return "redirect:/home/negocios";
	}

}
