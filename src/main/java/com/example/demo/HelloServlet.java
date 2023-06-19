package com.example.demo;

import java.io.*;

import com.example.demo.user.services.dao.UserDao;
import com.example.demo.user.services.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("id");
        User user = userDao.getByID(Integer.parseInt(userId));
        PrintWriter writer = response.getWriter();
        writer.println(user);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        String userSurname = req.getParameter("surname");
        String userAge = req.getParameter("age");
        userDao.createUser(new User(userName, userSurname, Integer.parseInt(userAge)));

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        String name = req.getParameter("name");
//        String surname = req.getParameter("surname");
//        String age = req.getParameter("age");
//        userDao.updateUser(new User(Integer.parseInt(id),name,surname,Integer.parseInt(age)));
//    }

    public void destroy() {
    }
}


//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");