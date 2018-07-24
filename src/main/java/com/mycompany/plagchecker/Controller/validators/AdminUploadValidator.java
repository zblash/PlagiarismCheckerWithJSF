/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.mail.MessagingException;
import javax.servlet.http.Part;

@FacesValidator("AdminUploadValidator")
public class AdminUploadValidator implements Validator {
      @Override
      public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Part part = (Part) value;
        
        if(part.getSize() > 1024000){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dosya boyutu sınırdan büyük.", "Dosya boyutu sınırdan büyük."));
        }
        if (!part.getContentType().equals("image/jpeg") && !part.getContentType().equals("image/png")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dosya Uzantısı Hatalı", "Dosya Uzantısı Hatalı"));
        }
    }  

}
