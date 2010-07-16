/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.edu.ucom.integracion.migracion.exceptions;

/**
 * 
 * @author Largonet
 */
@SuppressWarnings("serial")
public class CreditosExceptionError extends Exception {
	private String error;

	public CreditosExceptionError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

}
