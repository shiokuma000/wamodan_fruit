package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DBInit;

@WebServlet("/AddFruitServlet")
public class AddFruitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action"); // add か delete

        try (Connection conn = DBInit.getConnection()) {

            if ("add".equals(action)) {
                // --- 追加処理 ---
                String name = request.getParameter("name");
                int price = Integer.parseInt(request.getParameter("price"));
                String desc = request.getParameter("desc");
                String image = request.getParameter("image");

                String sqlAdd = "INSERT INTO FRUIT(NAME, PRICE, DESC_TEXT, IMAGE) " +
                                "SELECT ?, ?, ?, ? " +
                                "WHERE NOT EXISTS (SELECT * FROM FRUIT WHERE NAME = ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sqlAdd)) {
                    pstmt.setString(1, name);
                    pstmt.setInt(2, price);
                    pstmt.setString(3, desc);
                    pstmt.setString(4, image);
                    pstmt.setString(5, name);
                    pstmt.executeUpdate();
                }

            } else if ("delete".equals(action)) {
            	String name = request.getParameter("name");
            	String sqlDel = "DELETE FROM FRUIT WHERE NAME = ?";
            	try (PreparedStatement pstmt = conn.prepareStatement(sqlDel)) {
            	    pstmt.setString(1, name);
            	    pstmt.executeUpdate();
            	}

            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 処理後、一覧ページへリダイレクト
        response.sendRedirect("FruitServlet");
    }

}
