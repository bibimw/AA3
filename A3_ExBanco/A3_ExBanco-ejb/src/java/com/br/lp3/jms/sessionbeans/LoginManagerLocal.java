package com.br.lp3.jms.sessionbeans;

import javax.ejb.Local;

/**
 *
 * @author Bianca
 */
@Local
public interface LoginManagerLocal {
    boolean authorize(String username, String password);
}
