package main.Servlet;

import main.Dao.Dao;
import main.DaoImpl.DaoImpl;
import main.Entity.Film;
import main.Service.FindOneService;
import main.Service.UpdateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class UpdateServlet extends HttpServlet {

    private UpdateService us = new UpdateService();

    public UpdateServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        int lang_id = Integer.parseInt(req.getParameter("language"));

        Film film = new Film();
        film.setFilm_id(id);
        film.setTitle(title);
        film.setDescription(desc);
        film.setLanguage_id(lang_id);

        us.Update(film);
        resp.sendRedirect("findAll");
    }

}
