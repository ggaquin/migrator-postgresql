/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.edu.ucom.integracion.migracion.exceptions;

/**
 * 
 * @author Largonet
 */
public class PagosExceptionError extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8647181299353467032L;
	private String error;

	public PagosExceptionError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

}
