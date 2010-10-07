/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.edu.ucom.integracion.migracion.exceptions;

/**
 * 
 * @author Largonet
 */
public class CuotaExceptionError extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 71577314909950375L;
	private String error;

	public CuotaExceptionError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

}
