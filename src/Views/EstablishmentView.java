package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ui.HorizontalAlignment;

import Utilities.ButtonRounded;
import Utilities.PanelRounded;

public class EstablishmentView {
	public EstablishmentView(){
		
	}
	
	public JPanel showEstablishment() {
		JPanel EstablishmentPanel = new JPanel();
		EstablishmentPanel.setOpaque(true);
		EstablishmentPanel.setBackground(Color.decode("#EAEAEA"));
		EstablishmentPanel.setVisible(true);
		EstablishmentPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		// Panel total de vehiculos
		JPanel mapPanel = new JPanel();
		mapPanel.setOpaque(true);
		mapPanel.setVisible(true);
		mapPanel.setLayout(new BorderLayout());
		mapPanel.setBackground(Color.decode("#FFFFFF"));
		
		ImageIcon imagenMap = new ImageIcon(
       		 getClass().getResource("/Imagenes-sprites/mapa.png")
       		);
		
		//Label contenedor de la imagen con metodo para escalarla
		JLabel mapContenedor = new JLabel() {
       	 @Override
       	    protected void paintComponent(Graphics g) {
       	        super.paintComponent(g);
       	        g.drawImage(imagenMap.getImage(), 10, 10, getWidth(), getHeight(), this);
       	 	}
      	};
       
      	mapPanel.add(mapContenedor, BorderLayout.CENTER);
       
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.weightx = 4;
	    gbc.weighty = 3;
	    gbc.gridwidth = 4;
	    gbc.gridheight = 3;
	    gbc.insets = new Insets(0, 50, 0, 50); // 
	    gbc.fill = GridBagConstraints.BOTH;
       	EstablishmentPanel.add(mapPanel,gbc);
       
		//Icono y escalador del boton añadir
		ImageIcon ubicacionIcon = new ImageIcon(getClass().getResource("/Iconos/adicionales/ubicacion.png"));
		Image ubicacionEscalar = ubicacionIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon ubicacionEscalada = new ImageIcon(ubicacionEscalar);
       
		//Boton Añadir
		ButtonRounded seleccionarUbi = new ButtonRounded("Seleccionar Ubicacion",10,1);
		seleccionarUbi.setOpaque(false);
		seleccionarUbi.setBackground(Color.decode("#FFFFFF"));
		seleccionarUbi.setForeground(Color.white);
		seleccionarUbi.setFont(new Font("Poppins",Font.PLAIN,20));
		seleccionarUbi.setHorizontalTextPosition(JLabel.LEFT);
		seleccionarUbi.setIcon(ubicacionEscalada);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.insets = new Insets(0, 0, 0, 0); // 
	    gbc.fill = GridBagConstraints.NONE;
	    EstablishmentPanel.add(seleccionarUbi,gbc);
	    
		//Icono y escalador del boton añadir
		ImageIcon añadirIcon = new ImageIcon(getClass().getResource("/Iconos/adicionales/agregar_white.png"));
		Image añadirEscalar = añadirIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon añadirEscalada = new ImageIcon(añadirEscalar);
       
		//Boton Añadir
		ButtonRounded añadirUbi = new ButtonRounded("Añadir Ubicacion",10,1);
		añadirUbi.setOpaque(false);
		añadirUbi.setBackground(Color.decode("#FFFFFF"));
		añadirUbi.setForeground(Color.white);
		añadirUbi.setFont(new Font("Poppins",Font.PLAIN,20));
		añadirUbi.setHorizontalTextPosition(JLabel.LEFT);
		añadirUbi.setIcon(añadirEscalada);
		
		gbc.gridx = 3;
		gbc.gridy = 3;
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.insets = new Insets(0, 0, 0, 0); // 
	    gbc.fill = GridBagConstraints.NONE;
	    EstablishmentPanel.add(añadirUbi,gbc);
		
		return EstablishmentPanel;
	}
}
