package login.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm");

	private String cidade, estado, estacao;
	private double km, combustivel;
	private LocalDateTime dataHora;
	private String texto, meta;

	public Registro(String cidade, String estado, double km, double combustivel) {

		this.cidade = cidade;
		this.estado = estado;
		this.dataHora = LocalDateTime.now();
		registraEstacao();
		this.km = km;
		this.combustivel = combustivel;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstacao() {
		return estacao;
	}

	public String getDataHora() {
		return dataHora.format(formatter);
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public double getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(double combustivel) {
		this.combustivel = combustivel;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	private void registraEstacao() {

		if(dataHora.isAfter(LocalDateTime.of(dataHora.getYear(), 
				3, 20, 0, 0)) && dataHora.isBefore(LocalDateTime.of(dataHora.getYear(),
						6, 20, 23, 59)))
			estacao= "outono";
		else if(dataHora.isAfter(LocalDateTime.of(dataHora.getYear(), 
				6, 21, 0, 0)) && dataHora.isBefore(LocalDateTime.of(dataHora.getYear(),
						9, 21, 23, 59)))
			estacao= "inverno";
		else if(dataHora.isAfter(LocalDateTime.of(dataHora.getYear(), 
				9, 22, 0, 0)) && dataHora.isBefore(LocalDateTime.of(dataHora.getYear(),
						12, 20, 23, 59)))
			estacao= "primavera";
		else
			estacao= "verão";
	}
}
