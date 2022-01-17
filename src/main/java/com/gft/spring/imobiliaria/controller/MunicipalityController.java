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

import com.gft.spring.imobiliaria.entities.Municipality;
import com.gft.spring.imobiliaria.entities.State;
import com.gft.spring.imobiliaria.services.MunicipalityService;
import com.gft.spring.imobiliaria.services.StateService;


@Controller
@RequestMapping("/home")
public class MunicipalityController {

	@Autowired
	private MunicipalityService municipalityService;

	@Autowired
	private StateService stateService;

	@RequestMapping("/municipios")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {

		List<Municipality> listMunicipality = municipalityService.listAll(keyword);
		model.addAttribute("listMunicipality", listMunicipality);

		return "municipality/municipios";
	}

	@RequestMapping("/municipios/novo")
	public String showNewMunicipality(Model model) {

		List<State> listState = stateService.listAll(null);

		Municipality municipality = new Municipality();

		model.addAttribute("listState", listState);
		model.addAttribute("municipality", municipality);
		
		return "municipality/municipio";
	}
	

	

	@RequestMapping(value = "/municipios/save", method = RequestMethod.POST)
	public ModelAndView saveMunicipality(@ModelAttribute("municipality") Municipality municipality) {
		municipalityService.save(municipality);
		ModelAndView mv = new ModelAndView("Municipality/municipio");
		mv.addObject("mensagem", "salvo com sucesso");
		return mv;
	}

	@RequestMapping("/municipios/editar/{id}")
	public ModelAndView editarMunicipality(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("municipality/editarMunicipio");

		Municipality municipality = municipalityService.get(id);
		mav.addObject("municipality", municipality);
		return mav;
	}

	@RequestMapping("/municipios/deletar/{id}")
	public String deleteMunicipality(@PathVariable(name = "id") Long id) {
		municipalityService.delete(id);
		return "redirect:/home/municipios";
	}

}
