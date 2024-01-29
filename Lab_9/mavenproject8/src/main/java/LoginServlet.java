/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author saninzulphi
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            // User is already logged in
            String existingUsername = (String) session.getAttribute("username");
            Date loginTime = (Date) session.getAttribute("loginTime");
            String profilePictureUrl = (String) session.getAttribute("profilePicture");

            // Check if the requested username matches the existing session username
            if (existingUsername.equals(username)) {
                // Provide details about the existing session
                PrintWriter out = response.getWriter();
                out.println("<p>You are already logged in as " + existingUsername + "</p>");
                out.println("<p>Login Time: " + loginTime + "</p>");
                out.println("<img src='" + profilePictureUrl + "' alt='Profile Picture' style='width: 150px; height: 150px;'>");
                out.println("<p><a href='logout.jsp'>Logout</a></p>");
                return; // Stop further processing
            } else {
                // Different user with the same username is trying to log in
                PrintWriter out = response.getWriter();
                out.println("<p>User " + existingUsername + " is already logged in. Please logout first.</p>");
                return; // Stop further processing
            }
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Login", "root", "");

            PreparedStatement pst = con.prepareStatement("SELECT * FROM Log WHERE username=? AND password=?");
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String profilePictureUrl = rs.getString("profile_picture_url");
                session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("loginTime", new Date());
                session.setAttribute("profilePicture", profilePictureUrl); // Add the profile picture URL to the session
                insertLoginRecord(con, username);
                response.sendRedirect("welcome.jsp");
            } else {
                // Login failed
                PrintWriter out = response.getWriter();
                out.println("Invalid username or password");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void insertLoginRecord(Connection con, String username) throws Exception {
        String selectQuery = "SELECT * FROM user_sessions WHERE username = ?";
    String insertQuery = "INSERT INTO user_sessions (username, login_time) VALUES (?, ?)";
    String updateQuery = "UPDATE user_sessions SET login_time = ? WHERE username = ?";

    try (PreparedStatement selectStatement = con.prepareStatement(selectQuery)) {
        selectStatement.setString(1, username);
        ResultSet resultSet = selectStatement.executeQuery();

        if (resultSet.next()) {
            // Update login time if the record exists
            try (PreparedStatement updateStatement = con.prepareStatement(updateQuery)) {
                updateStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                updateStatement.setString(2, username);
                updateStatement.executeUpdate();
            }
        } else {
            // Insert a new record if the record does not exist
            try (PreparedStatement insertStatement = con.prepareStatement(insertQuery)) {
                insertStatement.setString(1, username);
                insertStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                insertStatement.executeUpdate();
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
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
    

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
