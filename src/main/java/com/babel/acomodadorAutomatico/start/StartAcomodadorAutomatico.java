package com.babel.acomodadorAutomatico.start;

import com.babel.acomodadorAutomatico.controllers.IMenuController;
import org.springframework.stereotype.Component;

@Component
public class StartAcomodadorAutomatico {
	IMenuController menuController;
	public StartAcomodadorAutomatico(IMenuController menuController){
		this.menuController = menuController;
	}
	public void start(){
		menuController.welcomeUser();
	}
}
