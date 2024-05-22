package controller;

import model.Wallet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/wallet")
public class WalletServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Wallet wallet;

    @Override
    public void init() throws ServletException {
        wallet = new Wallet();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("balance", wallet.getBalance());
        request.getRequestDispatcher("view/wallet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        double amount = Double.parseDouble(request.getParameter("amount"));

        try {
            if ("deposit".equals(action)) {
                wallet.deposit(amount);
            } else if ("withdraw".equals(action)) {
                wallet.withdraw(amount);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }

        request.setAttribute("balance", wallet.getBalance());
        request.getRequestDispatcher("view/wallet.jsp").forward(request, response);
    }
}
