import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Counter extends HttpServlet {

    public static int counter = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = resp.getWriter();
        out.println("Your counter = " + counter);
        System.out.println("get ");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = resp.getWriter();
        counter += 1;
        out.println("post");
        System.out.println("post");
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Here is Header: " + req.getHeader("Subtraction-Value"));
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = resp.getWriter();
        int i = req.getIntHeader("Subtraction-Value");
        counter -= i;
        System.out.println(("Now counter is " + counter));
        out.println("Now counter is " + counter);
    }
}
