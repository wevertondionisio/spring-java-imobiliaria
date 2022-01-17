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

import com.gft.spring.imobiliaria.entities.Category;
import com.gft.spring.imobiliaria.services.CategoryService;

@Controller
@RequestMapping("/home")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/categorias")
	public String viewHomePage(Model model,
			@Param("keyword") String keyword) {
		List<Category> listCategory = categoryService.listAll(keyword);
		model.addAttribute("listCategory", listCategory);
		
	return "category/categoria";
	}
	
	@RequestMapping("/categorias/novo")
	public String showNewCategory (Model model){
		Category category = new Category();
		model.addAttribute("category", category);
		return "category/cadastro";
	}
	
	@RequestMapping(value = "/categorias/save", method = RequestMethod.POST)
	public ModelAndView saveCategoria(@ModelAttribute("category") Category category) {
		categoryService.save(category);
		ModelAndView mv = new ModelAndView("category/cadastro");
		mv.addObject("mensagem", "salvo com sucesso");
		return mv;
	}		

	@RequestMapping("/categorias/editar/{id}")
	public ModelAndView editarCategory (@PathVariable(name = "id")Long id) {
		ModelAndView mav = new ModelAndView("category/editarCadastro");
		
		Category category = categoryService.get(id);
		mav.addObject("category", category);
		return mav;
	}
	
	@RequestMapping("/categorias/deletar/{id}")
	public String deleteCategory (@PathVariable(name = "id")Long id) {
		categoryService.delete(id);
		return "redirect:/home/categorias";
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String exluir(@PathVariable Long id) {
		categoryService.delete(id);
		
		return "redirect:/home/categorias";
	}
 	
}	
