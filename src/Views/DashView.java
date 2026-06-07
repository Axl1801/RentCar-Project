package Views;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import Controllers.ClientController;
import Controllers.DashController;
import Utilities.Activities;
import Utilities.ActivityManager;
import Utilities.BarRenderRounded;
import Utilities.PanelRounded;

public class DashView {
	DashController control;
	
	private JLabel disp;
	private JLabel rent;
	private JLabel mant;
	private JLabel total;

	public DashView() {

	}
	
	public void setControlador(DashController c) {
	    this.control = c;
	}

	public JPanel Dashboard() {
		JPanel dasboardhPanel = new JPanel();
		dasboardhPanel.setOpaque(true);
		dasboardhPanel.setBackground(Color.decode("#EAEAEA"));
		dasboardhPanel.setVisible(true);
		dasboardhPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		//Panel total de vehiculos
		PanelRounded totalVehiculos = new PanelRounded(10,true,true,true,true);
		totalVehiculos.setOpaque(false);
		totalVehiculos.setVisible(true);
		totalVehiculos.setLayout(new BorderLayout());
		totalVehiculos.setBackground(Color.decode("#FFFFFF"));

		JLabel total_titulo = new JLabel("Total Vehiculos");
		total_titulo.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		total_titulo.setBackground(Color.white);
		total_titulo.setForeground(Color.BLACK);
		total_titulo.setHorizontalAlignment(JLabel.CENTER);
		total_titulo.setFont(new Font("Poppins",Font.PLAIN,25));
		totalVehiculos.add(total_titulo, BorderLayout.NORTH);

		total = new JLabel(Integer.toString(control.numeroVehiculos_total()));
		total.setBackground(Color.white);
		total.setForeground(Color.BLACK);
		total.setHorizontalAlignment(JLabel.CENTER);
		total.setFont(new Font("Poppins",Font.PLAIN,50));
		totalVehiculos.add(total, BorderLayout.CENTER);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20,50,20,20);
		dasboardhPanel.add(totalVehiculos,gbc);

		//Panel Vehiculso Disponibles
		PanelRounded totalDisponibles= new PanelRounded(10,true,true,true,true);
		totalDisponibles.setOpaque(false);
		totalDisponibles.setVisible(true);
		totalDisponibles.setLayout(new BorderLayout());
		totalDisponibles.setBackground(Color.decode("#FFFFFF"));

		JLabel disp_titulo = new JLabel("Disponibles");
		disp_titulo.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		disp_titulo.setBackground(Color.white);
		disp_titulo.setForeground(Color.BLACK);
		disp_titulo.setHorizontalAlignment(JLabel.CENTER);
		disp_titulo.setFont(new Font("Poppins",Font.PLAIN,25));
		totalDisponibles.add(disp_titulo, BorderLayout.NORTH);

		disp = new JLabel(Integer.toString(control.numeroVehiculos_dispo()));
		disp.setBackground(Color.white);
		disp.setForeground(Color.BLACK);
		disp.setHorizontalAlignment(JLabel.CENTER);
		disp.setFont(new Font("Poppins",Font.PLAIN,50));
		totalDisponibles.add(disp, BorderLayout.CENTER);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20,50,20,20);
		dasboardhPanel.add(totalDisponibles,gbc);

		//Panel Vehiculso Rentados
		PanelRounded totalRentados= new PanelRounded(10,true,true,true,true);
		totalRentados.setOpaque(false);
		totalRentados.setVisible(true);
		totalRentados.setLayout(new BorderLayout());
		totalRentados.setBackground(Color.decode("#FFFFFF"));

		JLabel rentado_titulo = new JLabel("Rentados");
		rentado_titulo.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		rentado_titulo.setBackground(Color.white);
		rentado_titulo.setForeground(Color.BLACK);
		rentado_titulo.setHorizontalAlignment(JLabel.CENTER);
		rentado_titulo.setFont(new Font("Poppins",Font.PLAIN,25));
		totalRentados.add(rentado_titulo, BorderLayout.NORTH);

		rent = new JLabel(Integer.toString(control.numeroVehiculos_renta()));
		rent.setBackground(Color.white);
		rent.setForeground(Color.BLACK);
		rent.setHorizontalAlignment(JLabel.CENTER);
		rent.setFont(new Font("Poppins",Font.PLAIN,50));
		totalRentados.add(rent, BorderLayout.CENTER);

		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		dasboardhPanel.add(totalRentados,gbc);

		//Panel Vehiculos en Mantenimiento
		PanelRounded totalMantenimiento= new PanelRounded(10,true,true,true,true);
		totalMantenimiento.setOpaque(false);
		totalMantenimiento.setVisible(true);
		totalMantenimiento.setLayout(new BorderLayout());
		totalMantenimiento.setBackground(Color.decode("#FFFFFF"));

		JLabel mantenimiento_titulo = new JLabel("En Mantenimiento");
		mantenimiento_titulo.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		mantenimiento_titulo.setBackground(Color.white);
		mantenimiento_titulo.setForeground(Color.BLACK);
		mantenimiento_titulo.setHorizontalAlignment(JLabel.CENTER);
		mantenimiento_titulo.setFont(new Font("Poppins",Font.PLAIN,25));
		totalMantenimiento.add(mantenimiento_titulo, BorderLayout.NORTH);

		mant = new JLabel(Integer.toString(control.numeroVehiculos_manteni()));
		mant.setBackground(Color.white);
		mant.setForeground(Color.BLACK);
		mant.setHorizontalAlignment(JLabel.CENTER);
		mant.setFont(new Font("Poppins",Font.PLAIN,50));
		totalMantenimiento.add(mant, BorderLayout.CENTER);

		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		dasboardhPanel.add(totalMantenimiento,gbc);

		//Panel con grafica semanal de vehiculos
		PanelRounded panelStatsMens = new PanelRounded(10,true,true,true,true);
		panelStatsMens.setOpaque(false);
		panelStatsMens.setVisible(true);
		panelStatsMens.setLayout(new BorderLayout());
		panelStatsMens.setBackground(Color.decode("#FFFFFF"));
		
		control.actualizarReporteSemanas();//Actualiza los datos para que se muestren correctamente
		
		DefaultCategoryDataset  DSstats = new DefaultCategoryDataset ();
		DSstats.addValue(control.get_semana_1(), "Semana 1", "Semana 1"); //Asignacion de las ganancias de la semana 1 en la tabla
		DSstats.addValue(control.get_semana_2(), "Semana 2", "Semana 2"); //Asignacion de las ganancias de la semana 2 en la tabla
		DSstats.addValue(control.get_semana_3(), "Semana 3", "Semana 3"); //Asignacion de las ganancias de la semana 3 en la tabla
		DSstats.addValue(control.get_semana_4(), "Semana 4", "Semana 4"); //Asignacion de las ganancias de la semana 4 en la tabla
		DSstats.addValue(control.get_semana_5(), "Semana 5", "Semana 5"); //Asignacion de las ganancias de la semana 5 en la tabla

		JFreeChart statsMensuales = ChartFactory.createBarChart(
				" Rendimiento Mensual",//Titulo de la barra
				"", //Titulo del lateral
				"", //Titulo Inferior
				DSstats
				);

		statsMensuales.getTitle().setFont(new Font("Poppins", Font.PLAIN, 20));

		CategoryPlot plot = statsMensuales.getCategoryPlot();

		//Fondo limpio
		plot.setBackgroundPaint(new Color(245,245,245));
		plot.setOutlineVisible(false);
		plot.setRangeGridlinesVisible(false);
		plot.setDomainGridlinesVisible(false);

		//Quitar bordes
		statsMensuales.setBorderVisible(false);
		statsMensuales.setBackgroundPaint(new Color(245,245,245));

		//Categorias
		plot.getDomainAxis().setLabelFont(new Font("Poppins", Font.BOLD, 14));
		plot.getDomainAxis().setTickLabelFont(new Font("Poppins", Font.PLAIN, 12));

		//Valores
		plot.getRangeAxis().setLabelFont(new Font("Poppins", Font.BOLD, 14));
		plot.getRangeAxis().setTickLabelFont(new Font("Poppins", Font.PLAIN, 12));

		//Barras redondeadas
		BarRenderRounded renderer = new BarRenderRounded(10);
		renderer.setBarPainter(new StandardBarPainter()); // quita gradientes feos
		renderer.setShadowVisible(false);

		// Bordes redondeados simulados
		renderer.setMaximumBarWidth(0.1);
		
		renderer.setSeriesPaint(0, Color.decode("#A0BCE8")); // Semana 1
		renderer.setSeriesPaint(1, Color.decode("#6BE6D3")); // Semana 2
		renderer.setSeriesPaint(2, Color.decode("#000000")); // Semana 3
		renderer.setSeriesPaint(3, Color.decode("#7DBBFF")); // Semana 4
		renderer.setSeriesPaint(4, Color.decode("#A8E68B")); // Semana 5

		plot.setRenderer(renderer);

		plot.getRangeAxis().setVisible(true); // quita números laterales
		plot.getDomainAxis().setTickLabelFont(new Font("Poppins", Font.PLAIN, 12));
		plot.getDomainAxis().setAxisLineVisible(false);
		plot.getDomainAxis().setTickMarksVisible(false);

		statsMensuales.getTitle().setFont(new Font("Poppins", Font.BOLD, 18));
		statsMensuales.getTitle().setPaint(Color.BLACK);
		statsMensuales.getTitle().setHorizontalAlignment(HorizontalAlignment.LEFT);

		ChartPanel graficaBarras = new ChartPanel(statsMensuales);

		//Remover leyenda
		statsMensuales.removeLegend();

		statsMensuales.setBackgroundPaint(new Color(0,0,0,0));//Eliminar color del Background para que sea transparente
		plot.setBackgroundPaint(new Color(245,245,245));//Cambiar color del Background para que sea transparente
		plot.setBackgroundPaint(new Color(0,0,0,0));//Eliminar color del Background para que sea transparente
		graficaBarras.setOpaque(false);// ELiminar el opaque para que se pueda ver el panel redondeado
		graficaBarras.setBackground(new Color(0,0,0,0));//cambiar color del Background para que sea transparente
		graficaBarras.setMouseWheelEnabled(false);
		graficaBarras.setMouseZoomable(false);
		graficaBarras.setDomainZoomable(false);
		graficaBarras.setRangeZoomable(false);
		//Agregamos la grafica de barras al panel
		panelStatsMens.add(graficaBarras, BorderLayout.CENTER);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		gbc.weightx = 1;
		gbc.weighty = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 50, 20, 20);
		dasboardhPanel.add(panelStatsMens,gbc);

		//Panel para grafica de pastel
		PanelRounded panelStatsSuc = new PanelRounded(10,true,true,true,true);
		panelStatsSuc.setOpaque(false);
		panelStatsSuc.setVisible(true);
		panelStatsSuc.setLayout(new BorderLayout());
		panelStatsSuc.setBackground(Color.decode("#FFFFFF"));

		DefaultPieDataset DSsucu = new DefaultPieDataset();

		DSsucu.setValue("Disponibles", (100 * control.numeroVehiculos_dispo())/control.numeroVehiculos_total());
		DSsucu.setValue("Rentados", (100 * control.numeroVehiculos_renta())/control.numeroVehiculos_total());
		DSsucu.setValue("Mantenimiento", (100 * control.numeroVehiculos_manteni())/control.numeroVehiculos_total());
		DSsucu.setValue("Desactivados", (100 * control.numeroVehiculos_Desactivados())/control.numeroVehiculos_total());
		
		RingPlot plotPie = new RingPlot(DSsucu);

		JFreeChart chart = new JFreeChart(
			    "Estado de Vehículos",
			    JFreeChart.DEFAULT_TITLE_FONT,
			    plotPie,
			    true
			);

		ChartPanel graficaPastel = new ChartPanel(chart);
		graficaPastel.setOpaque(false);
		graficaPastel.setBackground(new Color(0,0,0,0));

		//Personalizacion de la tabla
		plotPie.setSectionDepth(0.25);
		plotPie.setSeparatorsVisible(false);
		plotPie.setShadowPaint(null);
		plotPie.setOutlineVisible(false);
		plotPie.setSectionOutlinesVisible(false);
		plotPie.setLabelGenerator(null);
		plotPie.setLabelLinksVisible(false);

		// Fondo transparente (para que respete el PanelRounded)
		chart.setBackgroundPaint(new Color(0,0,0,0));
		chart.getLegend().setPosition(RectangleEdge.RIGHT);
		chart.getLegend().setItemFont(new Font("Poppins", Font.PLAIN, 12));
		chart.getLegend().setItemFont(new Font("Poppins", Font.BOLD, 12));
		plotPie.setBackgroundPaint(new Color(0,0,0,0));
		plotPie.setOutlineVisible(false);

		plotPie.setLabelGenerator(null);
		plotPie.setLabelLinksVisible(false);

		plotPie.setLegendLabelGenerator(
				new StandardPieSectionLabelGenerator(
						"{0}: {2}", // nombre + porcentaje
						new DecimalFormat("0"),
						new DecimalFormat("0.0%")
						)
				);

		// Quitar bordes
		plotPie.setShadowPaint(null);
		plotPie.setLabelOutlinePaint(null);
		plotPie.setLabelShadowPaint(null);

		// Colores personalizados
		plotPie.setSectionPaint("Disponibles", Color.decode("#000000"));
		plotPie.setSectionPaint("Rentados", Color.decode("#7DBBFF"));
		plotPie.setSectionPaint("Mantenimiento", Color.decode("#6BE6D3"));
		plotPie.setSectionPaint("Desactivados", Color.decode("#A0BCE8"));

		plotPie.setLabelFont(new Font("Poppins", Font.BOLD, 12));
		plotPie.setSimpleLabels(true);

		panelStatsSuc.add(graficaPastel, BorderLayout.CENTER);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.weightx = 2;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20,50,20,20);


		dasboardhPanel.add(panelStatsSuc, gbc);

		//Panel para mostrar rendimiento Operativo
		PanelRounded panelRendimiento = new PanelRounded(10,true,true,true,true);
		panelRendimiento.setOpaque(false);
		panelRendimiento.setVisible(true);
		panelRendimiento.setLayout(new BorderLayout());
		panelRendimiento.setBackground(Color.decode("#000D56"));

		JLabel tituloRendimiento = new JLabel("Rendimiento Operativo");
		tituloRendimiento.setOpaque(false);
		tituloRendimiento.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		tituloRendimiento.setForeground(Color.decode("#FFFFFF"));
		tituloRendimiento.setHorizontalAlignment(JLabel.CENTER);
		tituloRendimiento.setFont(new Font("Poppins",Font.BOLD,25));
		panelRendimiento.add(tituloRendimiento, BorderLayout.NORTH);

		JPanel panelContPer = new JPanel();
		panelContPer.setOpaque(false);
		panelContPer.setVisible(true);
		panelContPer.setLayout(new GridLayout(2,1,0,0));

		JPanel panelPer = new JPanel();
		panelPer.setOpaque(false);
		panelPer.setVisible(true);
		panelPer.setLayout(new BorderLayout());
		panelContPer.add(panelPer,BorderLayout.CENTER);
		
		double porcentajeRend = control.get_totalMes();
		double porcentajeRendAnt =  control.get_ganancia_mes_anterior();
		int porcentaje;
		
		if(porcentajeRendAnt != 0) {
			 porcentaje = (int) ((porcentajeRend * 100) / porcentajeRendAnt);			
		}else {
			 porcentaje = 100;
		}
		

		JLabel percentage = new JLabel(String.valueOf(porcentaje) + " %");
		percentage.setFont(new Font("Poppins",Font.BOLD,50));
		percentage.setHorizontalAlignment(JLabel.CENTER);
		percentage.setForeground(Color.white);
		percentage.setVisible(true);
		percentage.setOpaque(false);
		panelPer.add(percentage,BorderLayout.CENTER);
		
		double gananciaMesAntepasado = control.ganancia_mes_anterior_anterior();
		double porcentajeAnterior = (porcentajeRendAnt * 100) / gananciaMesAntepasado;
		int mejora = (int)(porcentaje - porcentajeAnterior);
		
		

		JLabel cambioRend = new JLabel();
		if(mejora < 0) {
			cambioRend.setForeground(Color.red);
			cambioRend.setText("- " + mejora + " vs mes anterior");
		}else if(mejora > 0){
			cambioRend.setForeground(Color.decode("#308C52"));
			cambioRend.setText("+ " + mejora + " vs mes anterior");
		}
		else {
			cambioRend.setText(" ");
		}
		cambioRend.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 80));
		cambioRend.setForeground(Color.decode("#308C52"));
		cambioRend.setFont(new Font("Poppins",Font.BOLD,12));
		cambioRend.setVisible(true);
		cambioRend.setOpaque(false);
		panelPer.add(cambioRend,BorderLayout.EAST);

		panelContPer.add(panelPer);

		panelRendimiento.add(panelContPer, BorderLayout.CENTER);

		JPanel panelBarra = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panelBarra.setOpaque(false);
		panelBarra.setVisible(true);
		panelContPer.add(panelBarra,BorderLayout.CENTER);

		//Barra de porcentaje
		JProgressBar barra = new JProgressBar(0, 100);
		barra.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
			@Override
			protected void paintDeterminate(Graphics g, JComponent c) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int width = barra.getWidth();
				int height = barra.getHeight();

				// fondo
				g2.setColor(Color.decode("#515151"));
				g2.fillRoundRect(0, 0, width, height, 20, 20);

				// progreso
				int progressWidth = (int) (width * barra.getPercentComplete());
				g2.setColor(Color.decode("#FFFFFF"));
				g2.fillRoundRect(0, 0, progressWidth, height, 20, 20);
			}
		});
		
		
		
		barra.setPreferredSize(new Dimension(300, 10)); // tamaño exacto de la barra para que se vea estetica
		barra.setValue(porcentaje); // porcentaje (0–100)
		barra.setStringPainted(false);
		barra.setBackground(Color.decode("#000D56")); // fondo
		barra.setBorderPainted(false);

		panelBarra.add(barra,BorderLayout.NORTH);

		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20,0,20,20);

		dasboardhPanel.add(panelRendimiento, gbc);

		PanelRounded PanelActReciente = new PanelRounded(10,true,true,true,true);
		PanelActReciente.setBackground(Color.white);
		PanelActReciente.setVisible(true);
		PanelActReciente.setOpaque(false);
		PanelActReciente.setLayout(new BorderLayout());
		
		JLabel actividadesCreadas = new JLabel("Actividad Reciente");
		actividadesCreadas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
		actividadesCreadas.setForeground(Color.decode("#000000"));
		actividadesCreadas.setFont(new Font("Poppins",Font.BOLD,15));
		actividadesCreadas.setVisible(true);
		actividadesCreadas.setOpaque(false);
		PanelActReciente.add(actividadesCreadas,BorderLayout.NORTH);

		JPanel panelActividades = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;

				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int xLinea = 12;
				int yInicio = 0;
				int yFin = getHeight();

				g2.setColor(new Color(200,200,200));
				g2.setStroke(new BasicStroke(2));

				g2.drawLine(xLinea, yInicio, xLinea, yFin);
			}
		};
		panelActividades.setLayout(new BoxLayout(panelActividades, BoxLayout.Y_AXIS));
		panelActividades.setOpaque(false);

		
		ActivityManager.addPanel(panelActividades, 5);
		actualizarEstadisticas();

		PanelActReciente.add(panelActividades,BorderLayout.CENTER);

		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.weightx = 1;
		gbc.weighty = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0,0,20,20);

		dasboardhPanel.add(PanelActReciente, gbc);

		return dasboardhPanel;
	}

	public void actualizarEstadisticas() {
		if (control != null) {
			total.setText(Integer.toString(control.numeroVehiculos_total()));
			disp.setText(Integer.toString(control.numeroVehiculos_dispo()));
			rent.setText(Integer.toString(control.numeroVehiculos_renta()));
			mant.setText(Integer.toString(control.numeroVehiculos_manteni()));
		}
	}
	
}
