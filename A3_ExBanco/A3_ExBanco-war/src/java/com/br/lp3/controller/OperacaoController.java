package com.br.lp3.controller;

import com.br.lp3.jms.sessionbeans.ProducerSessionBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bianca
 */
public class OperacaoController extends HttpServlet {
    
    @EJB
    private ProducerSessionBeanLocal producerSB;   
    
    
    OperacaoManagerSBLocal contaManagerSB = lookupOperacaoManagerSBLocal();
    
    
    
    
    
    String command;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            if(command.endsWith("saldo")){
                try {
                    producerSB.sendMessage("Saldo consultado");
                } catch (JMSException ex) {
                    Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("conta", contaManagerSB.buscarConta());
                RequestDispatcher rd = request.getRequestDispatcher("/saldo.jsp");
                    rd.forward(request, response);
            } else if(command.endsWith("transferir")){
                request.setAttribute("conta", contaManagerSB.buscarConta());
                RequestDispatcher rd = request.getRequestDispatcher("/transferencia.jsp");
                    rd.forward(request, response);
                
            } else if(command.endsWith("saque")){
                request.setAttribute("conta", contaManagerSB.buscarConta());
                RequestDispatcher rd = request.getRequestDispatcher("/saque.jsp");
                rd.forward(request, response);         
                
            } else if(command.endsWith("tranferir")){
                int id1 = Integer.parseInt(request.getParameter("id1"));
                int id2 = Integer.parseInt(request.getParameter("id2"));
                Double valor = Double.parseDouble(request.getParameter("valor"));
                boolean resp = contaManagerSB.transferir(id1, id2, valor);
                if(resp){
                    RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
                    rd.forward(request, response);         
                } else{
                    RequestDispatcher rd = request.getRequestDispatcher("/erro2.jsp");
                    rd.forward(request, response); 
                }
                    
                
            } else if(command.endsWith("sacar")){
                int id = Integer.parseInt(request.getParameter("id"));
                Double valor = Double.parseDouble(request.getParameter("valor"));
                boolean resp = contaManagerSB.sacar(id, valor);
                if(resp){
                    RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
                    rd.forward(request, response);
                } else{
                    RequestDispatcher rd = request.getRequestDispatcher("/erro2.jsp");
                    rd.forward(request, response);
                }
            }
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
