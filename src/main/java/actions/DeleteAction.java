/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import DAO.UserDao;
import static com.opensymphony.xwork2.Action.SUCCESS;

import com.opensymphony.xwork2.ActionSupport;
import mapping.User;

public class DeleteAction extends ActionSupport {

    private User user = new User();
    private UserDao userManager;
    private int id;

    public DeleteAction() {
        userManager = new UserDao();
    }

   

    @Override
    /**
     * Elimina l'utente con id corrispondente
     */
    public String execute() {
        userManager.delete(getId());
        return SUCCESS;
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
