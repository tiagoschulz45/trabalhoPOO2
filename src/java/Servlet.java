

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dataservices.dao.SerieDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Genero;
import model.Serie;

/**
 *
 * @author Tiago
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

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
            
            out.println("<html>");
            out.println("<body>");
            out.println("chegou!");    
            out.println("</body>");
            out.println("</html>");
            
            String nome = request.getParameter("nome");
            String classificacao = request.getParameter("classificacao");
            String genero = request.getParameter("genero");
            String sinopse = request.getParameter("sinopse");
            String temporadas = request.getParameter("temporadas");
            
            out.println("<html>");
            out.println("<body>");
            out.println("chegou! 2");    
            out.println("</body>");
            out.println("</html>");
            
            Genero gen = null;
            if (Genero.ACAO.equals(genero)) {
                gen = Genero.ACAO;
            }
            if (Genero.COMEDIA.equals(genero)) {
                 gen = Genero.COMEDIA;
            }
            if (Genero.DOCUMENTARIO.equals(genero)) {
                gen = Genero.DOCUMENTARIO;
            }
            if (Genero.DRAMA.equals(genero)) {
                gen = Genero.DRAMA;
            }
            if (Genero.FICCAO.equals(genero)) {
                gen = Genero.FICCAO;
            } 
            
            Integer classific = Integer.parseInt(classificacao);
            Integer tempor = Integer.parseInt(temporadas);
            
            Serie s = new Serie(nome,gen,classific);
            
            SerieDAO dao = new SerieDAO();
            dao.save(s);
            
            out.println("<html>");
            out.println("<body>");
            out.println("Série " + s.getNome() + 
                " adicionada com sucesso");    
            out.println("</body>");
            out.println("</html>");
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
