package model.Authentication;

import model.User.User;

/**
 * Created by Bill Xiong on 3/3/17.
 * Used for authentication
 * Add parameters and methods as necessary
 */

public interface Authenticator {


    /**
     *  Authenticate using username, pass.
     * @param user User to authenticate
     * @return true if successful, else false
     */
    boolean authenticate(User user);


    /**
     * Sign a user up, add to firebase
     * @param user User to sign up
     * @return true if successful, else false
     */

    boolean signUp(User user);
}
