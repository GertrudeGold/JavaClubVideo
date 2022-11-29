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
		super(firstName, lastName, rank, adresse, credit, anniversary, dateRegister, id, dateRegister);
		// TODO Auto-generated constructor stub
	}

	

	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrator(String firstName, String lastName, int rank, String adresse, int credit,
			LocalDate anniversary, LocalDate dateRegister, String email,int id, LocalDate lastGainForAnniversary) {
		super(firstName, lastName, rank, adresse, credit, id, anniversary, dateRegister, email, lastGainForAnniversary);
		// TODO Auto-generated constructor stub
	}

	public Administrator(String firstName, String lastName, int rank, String adresse, int credit, LocalDate anniversary,
			LocalDate dateRegister, int id, LocalDate lastGainForAnniversary) {
		super(firstName, lastName, rank, adresse, credit, anniversary, dateRegister, id, lastGainForAnniversary);
		// TODO Auto-generated constructor stub
	}

	public Administrator(String firstName, String lastName, int rank, String adresse, int credit, LocalDate anniversary,
			LocalDate dateRegister, String email, String password, LocalDate lastGainForAnniversary) {
		super(firstName, lastName, rank, adresse, credit, anniversary, dateRegister, email, password, lastGainForAnniversary);
		// TODO Auto-generated constructor stub
	}
	

}
