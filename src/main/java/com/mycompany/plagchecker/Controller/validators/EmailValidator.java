/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.validators;

import com.mycompany.plagchecker.queries.DataQuery;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("SigninEmailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        boolean isRegular,isValid;
        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }

        if(value == null){
            return;
        }
        String email = (String) value;
        ResourceBundle msg = context.getApplication().evaluateExpressionGet(context, "#{msg}", ResourceBundle.class);
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        isRegular = matcher.find();
       
        
        if(!isRegular){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("emailValidatorError"), "error"));
        }
        DataQuery dataquery = new DataQuery();
        isValid = dataquery.userfindByEmail(email);
        if(!isValid){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("emailExsistsError"), "error"));
       }
          
    }
    
}
