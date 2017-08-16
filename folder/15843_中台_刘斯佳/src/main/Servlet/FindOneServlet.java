package main.Servlet;

import main.Entity.Film;
import main.Service.FindAllService;
import main.Service.FindOneService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class FindOneServlet extends HttpServlet {

    private FindOneService fos = new FindOneService();

    public FindOneServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        List<Film> list = fos.findOne(id);

        req.setAttribute("oneList", list);
        req.getRequestDispatcher("update.jsp")
                .forward(req, resp);
    }
}
