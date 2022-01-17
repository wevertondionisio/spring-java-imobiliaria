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

import com.gft.spring.imobiliaria.entities.District;
import com.gft.spring.imobiliaria.entities.Municipality;
import com.gft.spring.imobiliaria.entities.State;
import com.gft.spring.imobiliaria.services.DistrictService;
import com.gft.spring.imobiliaria.services.MunicipalityService;
import com.gft.spring.imobiliaria.services.StateService;

@Controller
@RequestMapping("/home")
public class DistrictController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private MunicipalityService municipalityService;
	
	@Autowired
	private DistrictService districtService;
	
	@RequestMapping("/bairros")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<District> listDistrict = districtService.listAll(keyword);
		model.addAttribute("listDistrict", listDistrict);

		return "district/bairros";
	}

	@RequestMapping("/bairros/novo")
	public String showNewDistrict(Model model) {
		
		List<State> listState = stateService.listAll(null);
		model.addAttribute("listState", listState);
		
		List<Municipality> listMunicipality = municipalityService.listAll(null);
		model.addAttribute("listMunicipality", listMunicipality);
		
		
		District district = new District();
		model.addAttribute("district", district);

		return "district/bairro";
	}

	@RequestMapping(value = "/bairros/save", method = RequestMethod.POST)
	public ModelAndView saveDistrict(@ModelAttribute("district") District district) {
		districtService.save(district);
		ModelAndView mv = new ModelAndView("district/bairro");
		mv.addObject("mensagem", "salvo com sucesso");
		return mv;

	}

	@RequestMapping("/bairros/editar/{id}")
	public ModelAndView editarDistrict(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("district/editarBairro");

		District district = districtService.get(id);
		mav.addObject("district", district);
		return mav;
	}

	@RequestMapping("/bairros/deletar/{id}")
	public String deleteDistrict(@PathVariable(name = "id") Long id) {
		districtService.delete(id);
		return "redirect:/home/bairros";
	}

}
