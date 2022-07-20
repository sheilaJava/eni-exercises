package fr.eni.doctorsAppt.test;

import java.time.LocalDate;

import fr.eni.doctorsAppt.bo.Address;
import fr.eni.doctorsAppt.bo.Patient;

public class TestPatient {

	public static void main(String[] args) {
		Address nio = new Address(19, null, "avenue Léo Lagrange", 79000, "Niort");
		Address sh = new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
		Address comp = new Address(4, null, "Rue des Glatiniers", 2100, "Saint-Quentin");

		System.out.println("__________________________ Patient _______________________________");
		Patient hillary = new Patient("Vambuce", "Hillary", "0123456789", 'F', 287060244010154l,
				LocalDate.of(1987, 6, 2), "Allergie aux arachides", comp);
		Patient ines = new Patient("Perret", "Inès", "0698745123", 'F', 245021067034521l, LocalDate.of(1945, 2, 10),
				null, nio);
		Patient adhemar = new Patient("Pamamobe", "Adhémar", "0753428619", 'M', 192112192020142l,
				LocalDate.of(1992, 11, 21), null, comp);
		
		hillary.display();
		System.out.println("------------------------------------------------------------------");
		ines.display();
		System.out.println("------------------------------------------------------------------");
		adhemar.display();
	}
}
