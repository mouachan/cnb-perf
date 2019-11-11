package com.sample.cnb.modele;

import java.time.LocalDate;

public class ElementDate {
	private LocalDate dateDebut;
	private LocalDate dateFin;

	public ElementDate(LocalDate debut, LocalDate fin) {
		this.dateDebut = debut;
		this.dateFin = fin;

	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

}
