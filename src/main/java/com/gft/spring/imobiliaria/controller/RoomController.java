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

import com.gft.spring.imobiliaria.entities.Room;
import com.gft.spring.imobiliaria.services.RoomService;

@Controller
@RequestMapping("/home")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping("/quartos")
	public String viewHomePage(Model model,
			@Param("keyword") String keyword) {
		List<Room> listRoom = roomService.listAll(keyword);
		model.addAttribute("listRoom", listRoom);
		
	return "room/quartos";
	}
	
	@RequestMapping("/quartos/novo")
	public String showNewRoom (Model model) {
		Room room = new Room();
		model.addAttribute("room", room);
		
		return "room/quarto";
	}
	
	@RequestMapping(value = "/quartos/save", method = RequestMethod.POST)
	public ModelAndView saveRoom(@ModelAttribute("room") Room room) {
		roomService.save(room);
		ModelAndView mv = new ModelAndView("Room/quarto");
		mv.addObject("mensagem", "salvo com sucesso");
		return mv;
	}
	
	
	@RequestMapping("/quartos/editar/{id}")
	public ModelAndView editarRoom (@PathVariable(name = "id")Long id) {
		ModelAndView mav = new ModelAndView("room/editarQuarto");
		
		Room room = roomService.get(id);
		mav.addObject("room", room);
		return mav;
	}
	
	@RequestMapping("/quartos/deletar/{id}")
	public String deleteRoom (@PathVariable(name = "id")Long id) {
		roomService.delete(id);
		return "redirect:/home/quartos";
	}
	
}	
