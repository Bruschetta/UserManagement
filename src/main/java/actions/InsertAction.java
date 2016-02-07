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

public class InsertAction extends ActionSupport {

    private User user = new User();
    private UserDao userManager;
    private int id;
    private String oldEmail="";

    public InsertAction() {
        userManager = new UserDao();
    }

    /**
     * Validatore campi di ingresso
     */
    @Override
    public void validate() {
        if (user.getUsername().length() == (0)) {
            this.addFieldError("user.username", "Campo username non può essere vuoto");
        }
        if (user.getPassword().length() == (0)) {
            this.addFieldError("user.password", "Campo password non può essere vuoto");
        }
        if (user.getEmail().length() == (0)) {
            this.addFieldError("user.email", "Campo email non può essere vuoto");
        }
    }

    @Override
    public String execute() {
        String result = "";
        result = userManager.add(user);
        if (result.equalsIgnoreCase("USERNAMEAP")) {
            this.addActionError("Esiste già un utente con username uguale a quello selezionato");
            return ERROR;
        }
        if (result.equalsIgnoreCase("EMAILAP")) {
            this.addActionError("Esiste già un utente associato all'indirizzo mail selezionato");
            return ERROR;
        }
        addActionMessage("L'utente " + user.getUsername() + " è stato creato correttamente");
        return SUCCESS;
    }

    /**
     * Aggiorna l'utente con i nuovi valori
     * 
     */
    public String update() {
        userManager.update(user);
        addActionMessage("L'utente " + user.getUsername() + " è stato modificato correttamente");
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

    /**
     * @return the oldEmail
     */
    public String getOldEmail() {
        return oldEmail;
    }

    /**
     * @param oldEmail the oldEmail to set
     */
    public void setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
    }
}
