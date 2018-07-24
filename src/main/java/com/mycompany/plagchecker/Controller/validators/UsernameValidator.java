/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.validators;

import com.mycompany.plagchecker.queries.DataQuery;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Yusuf Can Çelik
 */
@FacesValidator("SigninUsernameValidator")
public class UsernameValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        boolean isValid;
        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }

        if(value == null){
            return;
        }
        ResourceBundle msg = context.getApplication().evaluateExpressionGet(context, "#{msg}", ResourceBundle.class);
        String username = (String) value;
        DataQuery dataquery = new DataQuery();
        isValid = dataquery.userfindByUsername(username);
        if(!isValid){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("usernameExsistsError"), "error"));
       }
          
    }
    
}
