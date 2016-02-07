package actions;

import DAO.UserDao;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import mapping.User;

public class ListAction extends ActionSupport {

    private User user = new User();
    private List<User> userList = new ArrayList<User>();
    private UserDao userManager;
    private int id;

    public ListAction() {
        userManager = new UserDao();
    }

    @Override
    /**
     * Controlla se nel database c'è almeno un utente con username e password
     * corrispondenti a quelli passati
     */
    public String execute() {
        userList = userManager.findUserByUnameMail(user.getUsername(), user.getEmail());
        if (userList.size() > 0) {
            this.setUserList(userList);
            return SUCCESS;
        } else {
            this.addActionError("Non ci sono utenti che soddisfano i criteri di ricerca");
            return ERROR;
        }
    }

    /**
     * Cerca un utente tramite id 
     */
    public String findUserById() {
        user = (userManager.findUserById(getId()));
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
     * @return the userList
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
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
