/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;


import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.  Registros;
import modelo.RegistrosDAL;

/**
 *
 * @author jc997
 */


@WebServlet(name = "RegistrosController", urlPatterns = {"/RegistrosController"})
public class RegistrosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RegistrosDAL registrosDAL = null;
        try {
            registrosDAL = new RegistrosDAL();
        } catch (ClassNotFoundException ex) {
        }
        String accion;
        RequestDispatcher dispatcher = null;

        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("Registros/index.jsp");
            List<Registros> listaRegistros = registrosDAL.listarRegistros();
            request.setAttribute("lista", listaRegistros);
            
        } else if (accion.equals("nuevo")) {
            dispatcher = request.getRequestDispatcher("Registros/nuevo.jsp");
            
        } else if (accion.equals("insertar")) {
            String titulo = request.getParameter("titulo");
            String autor  = request.getParameter("autor");
            String año  = request.getParameter("año");

            Registros registro = new Registros(0, titulo, autor, año);
            registrosDAL.insertar(registro);

            dispatcher = request.getRequestDispatcher("Registros/index.jsp");
            List<Registros> listaRegistros = registrosDAL.listarRegistros();
            request.setAttribute("lista", listaRegistros);
            
        } else if (accion.equals("modificar")) {
            dispatcher = request.getRequestDispatcher("Registros/modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Registros registro = registrosDAL.mostarRegistro(id);
            request.setAttribute("registro", registro);
            
        
            
        } else if (accion.equals("eliminar")) {

            int id = Integer.parseInt(request.getParameter("id"));

            registrosDAL.eliminar(id);
            dispatcher = request.getRequestDispatcher("Registros/index.jsp");
            List<Registros> listaRegistros = registrosDAL.listarRegistros();
            request.setAttribute("lista", listaRegistros);
        } else {
            dispatcher = request.getRequestDispatcher("Registros/index.jsp");
            List<Registros> listaRegistros = registrosDAL.listarRegistros();
            request.setAttribute("lista", listaRegistros);
        }

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}



