package main.Servlet;

import main.Entity.Film;
import main.Service.FindLanService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class FindLanServlet extends HttpServlet {
    private FindLanService fl = new FindLanService();

    public FindLanServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Film> list = fl.findLan();

        req.setAttribute("lanList", list);
        req.getRequestDispatcher("add.jsp")
                .forward(req, resp);
    }
}
