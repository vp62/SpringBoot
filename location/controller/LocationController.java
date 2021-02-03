package com.villain.location.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.villain.location.entities.Location;
import com.villain.location.repo.LocationRepo;
import com.villain.location.service.LocationServiceImpl;
import com.villain.location.util.EmailUtil;
import com.villain.location.util.ReportUtil;

@Controller
public class LocationController {
	@Autowired
private LocationServiceImpl service;
	@Autowired
	private EmailUtil util;
	@Autowired
	LocationRepo repo;
	@Autowired
	ServletContext sc;
	@Autowired
	ReportUtil report;	
	
	@RequestMapping("/showCreate")
	public String show() {
		return "createLocation";
	}
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location loc,ModelMap map) {
		
		Location saved=service.saveLocation(loc);
		String msg="Location saved with id : "+saved.getId();
		map.addAttribute("msg", msg);
		util.sendMail("vishnupriyan021@gmail.com", "Location saved","Your detail saved successfully for "+saved.getName());
		return "createLocation";
	}
	@RequestMapping("/displayAll")
	public String displayAllLoc(ModelMap map ) {
		List<Location> loc=service.getAllLoc();
		map.addAttribute("locations",loc);
		return"displayLocation";
	}
	@RequestMapping("removeLocation")
	public String removeLoc(@RequestParam("id") int id,ModelMap map) {
		service.deleteLocation(id);
		List<Location> loc=service.getAllLoc();
		map.addAttribute("locations",loc);
		return"displayLocation";
	}
	@RequestMapping("edit")
	public String editLoc(@RequestParam("id") int id,ModelMap map) {
				map.addAttribute("location",service.getLocationById(id));
		return"editLocation";
	}
	@RequestMapping("/updateLoc")
	public String updateLoc(@ModelAttribute("location") Location loc,ModelMap map ) {
		service.updateLocation(loc);
		List<Location> loca=service.getAllLoc();
		map.addAttribute("locations",loca);
		return "displayLocation";
	}
	@RequestMapping("/generateReport")
	public String reportChart() {
		List<Object[]> list=repo.findTypeAndCount();
		report.generatPieChart(sc.getRealPath("/"),list);
		return "report";
	}
}
