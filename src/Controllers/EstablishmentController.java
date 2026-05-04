package Controllers;

import java.awt.Color;

import javax.swing.JPanel;

import Views.EstablishmentView;

public class EstablishmentController {
	private EstablishmentView ev;
	
	public EstablishmentController(){
		ev = new EstablishmentView();
	}
	
	public JPanel showEstablishment() {
		return ev.showEstablishment();
	}
	

}
