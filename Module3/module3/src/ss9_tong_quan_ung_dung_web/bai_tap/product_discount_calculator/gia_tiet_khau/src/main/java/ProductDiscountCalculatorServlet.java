import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductDiscountCalculatorServlet", urlPatterns = "/discount")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listPrince = request.getParameter("listPrice");
        String discountPercent = request.getParameter("discountPercent");
        double discountAmount = Double.parseDouble(listPrince) * Double.parseDouble(discountPercent) * 0.01;
        double discountPrice = Double.parseDouble(listPrince) - discountAmount;
        request.setAttribute("discountAmount", discountAmount);
        request.setAttribute("discountPrice", discountPrice);
        request.getRequestDispatcher("run.jsp");
    }
}
