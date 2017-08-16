package main.Servlet;

import main.Entity.Film;
import main.Service.FindAllService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class FindAllServlet extends HttpServlet {

    private FindAllService fas = new FindAllService();

    public FindAllServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Film> list = fas.findAll();

        req.setAttribute("filmList", list);
        req.getRequestDispatcher("filmList.jsp")
                .forward(req, resp);
    }
}
