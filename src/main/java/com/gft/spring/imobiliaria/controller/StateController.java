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

import com.gft.spring.imobiliaria.entities.State;
import com.gft.spring.imobiliaria.services.StateService;

@Controller
@RequestMapping("/home")
public class StateController {

	@Autowired
	private StateService stateService;

	@RequestMapping("/estados")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<State> listState = stateService.listAll(keyword);
		model.addAttribute("listState", listState);

		return "state/estados";
	}

	@RequestMapping("/estados/novo")
	public String showNewState(Model model) {
		State state = new State();
		model.addAttribute("state", state);

		return "state/estado";
	}

	@RequestMapping(value = "/estados/save", method = RequestMethod.POST)
	public ModelAndView saveState(@ModelAttribute("state") State state) {
		stateService.save(state);
		ModelAndView mv = new ModelAndView("State/estado");
		mv.addObject("mensagem", "salvo com sucesso");
		return mv;
	}

	@RequestMapping("/estados/editar/{id}")
	public ModelAndView editarState(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("state/editarEstado");

		State state = stateService.get(id);
		mav.addObject("state", state);
		return mav;
	}

	@RequestMapping("/estados/deletar/{id}")
	public String deleteState(@PathVariable(name = "id") Long id) {
		stateService.delete(id);
		return "redirect:/home/estados";
	}

}
