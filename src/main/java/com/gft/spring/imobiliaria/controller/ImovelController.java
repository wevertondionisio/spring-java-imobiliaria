package com.gft.spring.imobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.spring.imobiliaria.entities.Business;
import com.gft.spring.imobiliaria.entities.Category;
import com.gft.spring.imobiliaria.entities.District;
import com.gft.spring.imobiliaria.entities.Municipality;
import com.gft.spring.imobiliaria.entities.Room;
import com.gft.spring.imobiliaria.entities.State;
import com.gft.spring.imobiliaria.model.Imovel;
import com.gft.spring.imobiliaria.services.BusinessService;
import com.gft.spring.imobiliaria.services.CategoryService;
import com.gft.spring.imobiliaria.services.DistrictService;
import com.gft.spring.imobiliaria.services.ImovelService;
import com.gft.spring.imobiliaria.services.MunicipalityService;
import com.gft.spring.imobiliaria.services.RoomService;
import com.gft.spring.imobiliaria.services.StateService;


@Controller
@RequestMapping("/")
public class ImovelController {
	
	@Autowired
	private ImovelService imovelService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private BusinessService businessService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private MunicipalityService municipalityService;
	
	
	@RequestMapping("/home")
	public String viewHomePage(Model model) {
		
		List<Imovel> listImovel = imovelService.listAll();
		model.addAttribute("listImovel", listImovel);

		return "Index";
		
	}
	
	@RequestMapping("/home/imovel")
	
		public String showState (Model model) {
			
			List<State> listState = stateService.listAll(null); 
			model.addAttribute("listState", listState);
			
			List<Category> listCategory = categoryService.listAll(null); 
			model.addAttribute("listCategory", listCategory);
			
			List<District> listDistrict = districtService.listAll(null); 
			model.addAttribute("listDistrict", listDistrict);
			
			List<Business> listBusiness = businessService.listAll(null); 
			model.addAttribute("listBusiness", listBusiness);
			
			List<Room> listRoom = roomService.listAll(null); 
			model.addAttribute("listRoom", listRoom);
			
			List<Municipality> listMunicipality = municipalityService.listAll(null); 
			model.addAttribute("listMunicipality", listMunicipality);
				
			return "Imovel/imovel";
			
		}
	
	

	
	@RequestMapping(value = "/home/imovel/save", method = RequestMethod.POST)
	public ModelAndView saveImovel(@ModelAttribute("imovel") Imovel imovel) {
		imovelService.save(imovel);
		ModelAndView mv = new ModelAndView("redirect:/home/imovel/save");
		mv.addObject("mensagem", "salvo com sucesso");
		return mv;
	}

	@RequestMapping("/home/imovel/editar/{id}")
	public ModelAndView editarImovel(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("Imovel/editarImovel");

		Imovel imovel = imovelService.get(id);
		mav.addObject("imovel", imovel);
		return mav;
	}

	@RequestMapping("/home/imovel/deletar/{id}")
	public String deleteImovel(@PathVariable(name = "id") Long id) {
		imovelService.delete(id);
		return "redirect:/home";
	}
	
}	
