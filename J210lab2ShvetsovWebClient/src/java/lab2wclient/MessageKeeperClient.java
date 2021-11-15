/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2wclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
//import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author User
 */
@WebServlet(name = "MessageKeeperClient", urlPatterns = {"/MessageKeeperClient"})
public class MessageKeeperClient extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/J210lab2Shvetsov-war/IDemo?WSDL")// LINK isp pri sozdanii (view WSDL posle testa web service, iz adresnoy stroki)

    private IDemo service;//Link na slyjby

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String addMsg = request.getParameter("addMsg");
        String getMsg = request.getParameter("getMsg");
        String allMsg = request.getParameter("allMsg");

        IDemoImpl port = service.getIDemoImplPort();

        if (addMsg != null) {
            String user = request.getParameter("user");
            String msg = request.getParameter("msg");
            if (user.equals("")) {
                request.setAttribute("response", "User name is empty");
            } else {
                port.add(user, msg);
                request.setAttribute("response", "Message added for " + user);
            }

        }

        if (getMsg != null) {
            String user = request.getParameter("user");
            String msg = request.getParameter("msg");
            try {
                int index = Integer.parseInt(msg);
                String message = null;
                try {
                    message = port.getMessage(user, index);
                } catch (InvalidParameterException e) {
                    request.setAttribute("response", "User or Index invalid");
                }
                request.setAttribute("response", "Message " + index + " User name: " + user + " Text: " + message);
            } catch (NumberFormatException e) {
                request.setAttribute("response", "Index is not a number or User name is empty");
            }
        }

        if (allMsg != null) {
            String user = request.getParameter("user");
            List<String> listMessages = port.getAllMessage(user);
            if (listMessages != null && !user.equals("")) {//!user.equals("")
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (String message : listMessages) {
                    
                    if (count != 0) {
                        sb.append("<li>");
                        sb.append(" ");
                        sb.append("Message index: ");
                        sb.append(count);
                        sb.append(" Text: ");
                        sb.append(message);
                        sb.append("</li>");
                        count++;
                    } else {
                        count++;
                    }
                    
                }

                request.setAttribute("response", sb.toString() );//+ "sdsdsds"
                
            } else {
                
                request.setAttribute("response", "For User: " + user + " messages not found");
               
            }
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MessageKeeperClient</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MessageKeeperClient at " + request.getContextPath() + "</h1>");

            out.println("<h1>Service = " + service + "</h1>");
            //IDemo port = null;//napishem polnostbu IDemoImpl - oshibka privedeniya
            //IDemoImpl port = null;
//            if (service != null) {
//                port = service.getIDemoImplPort();//esli slujba y nas estb, to poluchaem port////(IDemo) - ybiraem privedenie
//            }
            //VbIzov slyjbbI iz servleta
//            List<String> ms = port.getAllMessage("uuu");//Client otpr message v Web Slujby "IDemoImpl", a ona perenapravliaet soobshenie v EJB "MessageKeeper"
//            
//            for (int i = 0; i < ms.size(); i++) {
//                out.println("User uuu, message " + i + " : " + ms.get(i));
//                
//            }

            //out.println("<h1>Port = " + port + "</h1>");
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
