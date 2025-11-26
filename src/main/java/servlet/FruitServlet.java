package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.FruitDAO;
import model.Fruit;

@WebServlet("/FruitServlet")
public class FruitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

 // --- サーブレット初期化時に DB 初期化 ---
    @Override
    public void init() throws ServletException {
        super.init();
        // DB がまだ作られていなければ初期化
        //model.DBInit.initialize();
    }

    // --- GETリクエスト処理 ---
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // JDBC経由でデータ取得
        FruitDAO dao = new FruitDAO();
        List<Fruit> fruits = dao.findAll();

        // 取得データをリクエストスコープに保存
        request.setAttribute("fruits", fruits);

        //JSPにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/fruitEL.jsp");
        dispatcher.forward(request, response);
    }
}
