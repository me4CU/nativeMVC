/**
 * 
 */
package com.jone;

/**
 * @author Administrator
 *
 */
public class ActionFactory {
    public static Action getAction(String actionName) {  
        if (LoginAction.class.getSimpleName().equals(actionName)) {  
            return new LoginAction();  
        }  
        return null;  
    }  
}
