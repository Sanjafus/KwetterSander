package Controller;

import Service.TweetServiceInterface;
import Model.Tweet;
import Model.User;
import Service.TweetServiceInterfaceImpl;
import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.TweetProvider;
import logic.TweetProviderImpl;
import logic.UserProvider;
import logic.UserProviderImpl;

/**
 *
 * @author Sander
 */
@WebServlet(urlPatterns = {"/testKaas"})
@Stateless
public class KwetterServlet extends HttpServlet {

    @Inject
    private TweetServiceInterface tweetService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        tweetService = new TweetServiceInterfaceImpl();
        tweetService.setTweetProvider(new TweetProviderImpl());
        tweetService.setUserProvider(new UserProviderImpl());
        User user2 = new User("test", "test", "test");
        ArrayList<Tweet> al = new ArrayList<Tweet>();
        al.add(new Tweet(user2, "allo"));
        user2.setTweets(al);
        tweetService.createUser(user2);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Very nice yes!";
    }// </editor-fold>

}
