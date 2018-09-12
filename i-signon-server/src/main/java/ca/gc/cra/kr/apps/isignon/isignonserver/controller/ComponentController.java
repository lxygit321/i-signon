package ca.gc.cra.kr.apps.isignon.isignonserver.controller;


import ca.gc.cra.kr.apps.isignon.isignonserver.dao.PacmanComponentDao;
import ca.gc.cra.kr.apps.isignon.isignonserver.domain.PacmanComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComponentController
{
    // private @Autowired HttpServletRequest request;
    private @Autowired PacmanComponentDao dao;

    @GetMapping("/components")
    public List<PacmanComponent> components() {
    	return dao.findAllComponents();
    }
}
