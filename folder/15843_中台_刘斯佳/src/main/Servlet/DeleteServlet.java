package main.Servlet;

import main.Entity.Film;
import main.Service.DeleteService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class DeleteServlet extends HttpServlet {

    private DeleteService ds = new DeleteService();

    public DeleteServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Film film = new Film();
        film.setFilm_id(id);

        ds.delete(film);
        resp.sendRedirect("findAll");
    }
}
