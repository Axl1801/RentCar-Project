package main;

import Controllers.AuthController;

import Views.AuthView;

public class Aplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Llamada a la vista de login e iniciar el programa
		AuthController auth = new AuthController();
		auth.login();

	}

}
