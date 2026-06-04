package Utilities;

import java.awt.FlowLayout;
import java.time.LocalDate;
import java.time.YearMonth;

import javax.swing.JPanel;

public class DatePickerRounded extends JPanel {
	private ComboBoxRounded<Integer> dia;
    private ComboBoxRounded<Integer> mes;
    private ComboBoxRounded<Integer> anio;

    public DatePickerRounded() {

        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        dia = new ComboBoxRounded<>();
        mes = new ComboBoxRounded<>();
        anio = new ComboBoxRounded<>();
        
        mes.addActionListener(e -> actualizarDias());

        anio.addActionListener(e -> actualizarDias());

        // Días
        for (int i = 1; i <= 31; i++) {
            dia.addItem(i);
        }

        // Meses
        for (int i = 1; i <= 12; i++) {
            mes.addItem(i);
        }

        // Años
        int añoActual = LocalDate.now().getYear();

        for (int i = añoActual - 10; i <= añoActual + 10; i++) {
            anio.addItem(i);
        }

        actualizarDias();
        
        add(dia);
        add(mes);
        add(anio);
    }

    public LocalDate getDate() {

        return LocalDate.of(
            (Integer) anio.getSelectedItem(),
            (Integer) mes.getSelectedItem(),
            (Integer) dia.getSelectedItem()
        );
    }
    
    private void actualizarDias() {
    	
        if (mes.getSelectedItem() == null ||
                anio.getSelectedItem() == null) {
                return;
            }

        int mesSeleccionado =
            (Integer) mes.getSelectedItem();

        int añoSeleccionado =
            (Integer) anio.getSelectedItem();

        int diasMes =
            YearMonth.of(
                añoSeleccionado,
                mesSeleccionado
            ).lengthOfMonth();

        Integer diaActual =
            (Integer) dia.getSelectedItem();

        dia.removeAllItems();

        for (int i = 1; i <= diasMes; i++) {
            dia.addItem(i);
        }

        if (diaActual != null &&
            diaActual <= diasMes) {

            dia.setSelectedItem(diaActual);
        }
    }

    public void setDate(LocalDate fecha) {

        dia.setSelectedItem(fecha.getDayOfMonth());
        mes.setSelectedItem(fecha.getMonthValue());
        anio.setSelectedItem(fecha.getYear());
    }
}
