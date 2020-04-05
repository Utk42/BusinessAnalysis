package BIA.Business.Impact.Analysis.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BIA.Business.Impact.Analysis.Model.Employees;
import BIA.Business.Impact.Analysis.Model.ProductionSteps;
import BIA.Business.Impact.Analysis.Model.Resources;
import BIA.Business.Impact.Analysis.Service.ProductionStepsService;
import BIA.Business.Impact.Analysis.Service.ResourcesService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ResourcesController {

	@Autowired
	private ResourcesService service;
	
	@Autowired
	private ProductionStepsService service1;

	@RequestMapping("/Resourceslist")
	public String viewHomePage(Model model) {
		List<Resources> Resourceslist = service.listAll();
		model.addAttribute("Resourceslist", Resourceslist);
		return "Manage_Financial_Resources";
	}

	@RequestMapping("/NewResources")
	public String showNewResourcesPage(Model model) {
		Resources Resources = new Resources();
		model.addAttribute("Resources", Resources);
		List<ProductionSteps> ProductionSteps = service1.listAll();
		model.addAttribute("ProductionStepslist", ProductionSteps);
		
		return "Add_FinancialResources";
	}

	@RequestMapping(value = "/saveResources", method = RequestMethod.POST)
	public String saveResources(@ModelAttribute("Resources") Resources Resources) {
		service.save(Resources);
		return "redirect:/Resourceslist";
	}

	@RequestMapping("/EditResources/{id}")
	public ModelAndView showEditResourcePage(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("Edit_Recourses");
		Resources Resources = service.get(id);
		mav.addObject("Resources", Resources);
		return mav;
	}

	@RequestMapping("/DeleteResources/{id}")
	public String deleteResources(@PathVariable(name = "id") String id) {
		service.delete(id);
		return "redirect:/Resourceslist";
	}
}
