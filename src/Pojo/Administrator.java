package Pojo;

import java.io.Serializable;
import java.time.LocalDate;

public class Administrator extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8811432663168704383L;

	public Administrator(String firstName, String lastName, int rank, String adresse, int credit,
			LocalDate anniversary, LocalDate dateRegister, int id) {
		super(firstName, lastName, rank, adresse, credit, anniversary, dateRegister, id);
		// TODO Auto-generated constructor stub
	}

}
