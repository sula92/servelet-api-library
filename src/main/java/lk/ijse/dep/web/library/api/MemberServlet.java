package lk.ijse.dep.web.library.api;

import lk.ijse.dep.web.library.business.custom.BookBO;
import lk.ijse.dep.web.library.business.custom.MemberBO;
import lk.ijse.dep.web.library.dto.BookDTO;
import lk.ijse.dep.web.library.dto.MemberDTO;
import lk.ijse.dep.web.library.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.NoSuchElementException;

@WebServlet(name = "memberServlet", urlPatterns = "/members")
public class MemberServlet extends HttpServlet {

    @Autowired
    MemberBO memberBO;

    @Override
    public void init() throws ServletException {
        memberBO = ((AnnotationConfigApplicationContext)
                (getServletContext().getAttribute("ctx"))).getBean(MemberBO.class);
    }

    public static String getParameter(String queryString, String parameterName) {
        if (queryString == null || parameterName == null || queryString.trim().isEmpty() || parameterName.trim().isEmpty()) {
            return null;
        }

        String[] queryParameters = queryString.split("&");
        for (String queryParameter : queryParameters) {
            if (queryParameter.contains("=") && queryParameter.startsWith(parameterName)) {
                return queryParameter.split("=")[1];
            }
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        resp.setContentType("text/plain");
        try (PrintWriter out = resp.getWriter()) {
            if (id == null) {
                List<MemberDTO> allBooks = memberBO.getAllMembers();
                allBooks.forEach(out::println);
            } else {
                try {
                    MemberDTO Book = memberBO.getMember(id);
                    out.println(Book);
                } catch (NoSuchElementException e) {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String con = request.getParameter("contact");
        String add = request.getParameter("address");

        if (!id.matches("M\\d{3}") || name.trim().length() < 3 || add.trim().length() < 3) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        response.setContentType("text/plain");
        try (PrintWriter out = response.getWriter()) {
            try {
                memberBO.getMember(id);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            } catch (NoSuchElementException e) {
                memberBO.saveMember(id, name, con,add);
                response.setStatus(HttpServletResponse.SC_CREATED);
                out.println("Book has been saved successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryString = req.getQueryString();
        if (queryString == null) {

            return;
        }

        String id = getParameter(queryString, "id");

        if (id == null) {

            return;
        }

        BufferedReader reader = req.getReader();
        String line = null;
        String requestBody = "";

        while ((line = reader.readLine()) != null) {
            requestBody += line;
        }

        String name = getParameter(requestBody, "name");
        String con = getParameter(requestBody, "contact");
        String address = getParameter(requestBody, "address");

        if (!id.matches("M\\d{3}") || name.trim().length() < 3 || address.trim().length() < 3) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        resp.setContentType("text/plain");
        try {
            memberBO.getMember(id);
            memberBO.updateMember(id, name, con, address);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return;
        } catch (NoSuchElementException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryString = req.getQueryString();
        String id = getParameter(queryString, "id");
        if (id == null) {
            return;
        }
        try {
            memberBO.deleteMember(id);
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        System.out.println("Member has been Deleted: " + id);
    }
}
