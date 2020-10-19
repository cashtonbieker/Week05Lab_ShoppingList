package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cashton
 */

public class ShoppingListServlet extends HttpServlet {
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String user = (String) session.getAttribute("user");
        
        String action = request.getParameter("action");
        
        if (action != null){
            if (action.equals("logout")){
                session.invalidate();
                session = request.getSession();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

            }
        }
        
        if (user == null){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        
        request.setAttribute("user", user);
        
        
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            
        request.setAttribute("items", items);
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        
        if (action.equals("register")){
            String user = request.getParameter("user");
            
            session.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        }
        
        if (action.equals("add")){
            
            
            String item = request.getParameter("item");
            
            if (item == null){
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            }
            
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            
            if(items == null){
                items = new ArrayList<> ();
            }
            
            items.add(item);
            
            session.setAttribute("items", items);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            
        }
        
        if (action.equals("delete")){
            String listItem = request.getParameter("listItem");
            
            if (listItem == null){
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            }
            
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            
            if(items == null){
                items = new ArrayList<> ();
            }
            
            for (int i = 0; i < items.size(); i++){
                if (items.get(i).equals(listItem)){
                    items.remove(i);
                }
            }
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            
        }
    }
}
