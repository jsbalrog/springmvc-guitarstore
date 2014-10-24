package com.guitarstore.web;

import com.guitarstore.domain.Guitar;
import com.guitarstore.domain.GuitarSearchCriteria;
import com.guitarstore.domain.GuitarType;
import com.guitarstore.domain.GuitarTypeEditor;
import com.guitarstore.service.GuitarService;
import com.guitarstore.validation.GuitarValidator;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author etjenkins
 */
@Controller
@SessionAttributes("guitar")
public class GuitarController {

    private GuitarService guitarService;
	private GuitarValidator validator;

	@RequestMapping(value="/index.htm")
    public String index(GuitarSearchCriteria guitarSearchCriteria, ModelMap model) {
        model.addAttribute("date", new Date());
        return "index";
    }

    @RequestMapping(value="/search.htm")
    public String search(GuitarSearchCriteria guitarSearchCriteria, ModelMap model) {
        System.out.println("query: " + guitarSearchCriteria.getQuery());
        List<Guitar> guitars = guitarService.findGuitars(guitarSearchCriteria);
        model.addAttribute("date", new Date());
        model.addAttribute("guitars", guitars);
        return "index";
    }

    @RequestMapping(value = "/details.htm", method = RequestMethod.GET)
    @ModelAttribute("guitar")
    public Guitar details(@RequestParam("id") int id) {
        return guitarService.getGuitar(id);
    }

    @RequestMapping(value = "/new.htm", method = RequestMethod.GET)
    public String setupForm(ModelMap model) {
        Guitar guitar = new Guitar();
        model.addAttribute(guitar);
        return "new";
    }

	@RequestMapping(value = "/new-image.htm", method = RequestMethod.GET)
	public String setupForm(@RequestParam("id") int id) {
		return "new-image";
	}


	// This method is needed so that the sub-objects on the page are converted correctly
	// when the form is saved. The editor applies only when form is posted.
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(GuitarType.class, new GuitarTypeEditor(guitarService));
	}

	@ModelAttribute("guitarTypes")
	public List<GuitarType> populateGuitarTypes() {
            return guitarService.getGuitarTypes();
	}

	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("guitar") Guitar guitar, BindingResult result, @RequestParam("image")MultipartFile image,
			SessionStatus status) throws IOException {
		validator.validate(guitar, result);
		if(result.hasErrors()) {
			return "new";
		} else {
			guitar.setGuitarImage(image.getBytes());
			guitarService.create(guitar);
			status.setComplete();
			return "redirect:index.htm";
		}
	}

	@RequestMapping(value = "/save-image.htm", method = RequestMethod.POST)
    public String handleFormUpload(@ModelAttribute("guitar") Guitar guitar, @RequestParam("image") MultipartFile image) throws IOException {
        if (!image.isEmpty()) {
			guitar.setGuitarImage(image.getBytes());
			guitarService.update(guitar);
           return "redirect:index.htm";
       } else {
           return null;
       }
    }

	@RequestMapping(value="/edit.htm", method = RequestMethod.GET)
	public String edit(@RequestParam("id")int id, ModelMap model) {
		Guitar guitar = guitarService.getGuitar(id);
		System.out.println(guitar.getGuitarType().getName());
		model.addAttribute(guitar);
		return "edit";
	}

	@RequestMapping(value = "/update.htm", method = RequestMethod.POST)
	public String processUpdate(@ModelAttribute("guitar") Guitar guitar, BindingResult result,
			SessionStatus status) {
		System.out.println(guitar.getId());
		validator.validate(guitar, result);

		if(result.hasErrors()) {
			return "edit";
		} else {
			guitarService.update(guitar);
			status.setComplete();
			return "redirect:index.htm";
		}
	}

	@RequestMapping(value="/delete.htm")
	public String delete(@RequestParam("id")int id, @RequestParam("query")String query, ModelMap model) {
		guitarService.deleteGuitar(id);
		
		GuitarSearchCriteria guitarSearchCriteria = new GuitarSearchCriteria(query);
		model.addAttribute("guitars", guitarService.findGuitars(guitarSearchCriteria));
		model.addAttribute("guitarSearchCriteria", guitarSearchCriteria);
		model.addAttribute("date", new Date());
		return "index";
	}


    @Autowired
    public void setGuitarService(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

	@Autowired
	public void setGuitarValidator(GuitarValidator validator) {
		this.validator = validator;
	}
}