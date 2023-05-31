import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        request.setAttribute("username",username);
        request.setAttribute("password",password);
        // Create Login object with the provided credentials
        Login login = new Login(username, password);

        // Create LoginDAO object to validate the login
        LoginDAO loginDAO = new LoginDAO();

        // Validate the login credentials
        boolean isValidLogin = loginDAO.validateLogin(login);

        // Determine the next view based on the login result
        String nextView;
        if (isValidLogin) {
            nextView = "success.jsp";
        } else {
            nextView = "error.jsp";
        }

        // Forward the request to the appropriate view
        RequestDispatcher dispatcher = request.getRequestDispatcher(nextView);
        dispatcher.forward(request, response);
    }
}
