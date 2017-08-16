package main.Servlet;

import main.Entity.Film;
import main.Service.AddService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class AddServlet extends HttpServlet {

    private AddService as = new AddService();

    public AddServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        int lang_id = Integer.parseInt(req.getParameter("language"));

        Film film = new Film();
        film.setTitle(title);
        film.setDescription(desc);
        film.setLanguage_id(lang_id);

        as.Add(film);
        resp.sendRedirect("findAll");
    }
}
