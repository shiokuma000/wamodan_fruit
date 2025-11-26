package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.FruitDAO;
import model.Fruit;

@WebServlet("/AddFruitServlet")
public class AddFruitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action"); // add か delete


        	FruitDAO dao = new FruitDAO();

        	if("add".equals(action)) {
        		String name = request.getParameter("name");
        		int price = Integer.parseInt(request.getParameter("price"));
        		String desc = request.getParameter("desc");
        		String image = request.getParameter("image");
        		dao.addFruit(new Fruit(name,price,desc,image));

        	} else if("delete".equals(action)) {
        		String name = request.getParameter("name");
        		dao.deleteFruit(name);
        	}

        	response.sendRedirect("FruitServlet");
        }



    }


