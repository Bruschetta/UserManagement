/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import DAO.UserDao;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import mapping.User;

public class LoginAction extends ActionSupport {

    private User user = new User();
    private List<User> userList = new ArrayList<User>();

    private UserDao userManager;

    public LoginAction() {
        userManager = new UserDao();
    }

    /**
     * Validatore campi di ingresso
     */
    @Override
    public void validate() {
        if (user.getUsername().length() == (0)) {
            this.addFieldError("user.username", "Username non può essere vuoto");
        }
        if (user.getPassword().length() == (0)) {
            this.addFieldError("user.password", "Password non può essere vuoto");
        }
    }

    @Override
    /**
     * Controlla se nel database c'è un utente con username e password
     * corrispondenti a quelli passati
     */
    public String execute() {
        if (userManager.findUserForLogin(user.getUsername(), user.getPassword()).size() > 0) {
            return SUCCESS;
        } else {
            this.addActionError("Username e password errati.Prego riprovare");
            return ERROR;
        }
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}
