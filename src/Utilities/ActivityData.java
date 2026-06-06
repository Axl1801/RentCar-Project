package Utilities;

import java.awt.Color;
import java.time.LocalTime;

public class ActivityData {
    private String titulo;
    private String subtitulo;
    private LocalTime tiempo;
    private Color color;

    public ActivityData(String titulo,String subtitulo,LocalTime tiempo,Color color) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.tiempo = tiempo;
        this.color = color;
    }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public LocalTime getTiempo() {
		return tiempo;
	}

	public void setTiempo(LocalTime tiempo) {
		this.tiempo = tiempo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
   
}
