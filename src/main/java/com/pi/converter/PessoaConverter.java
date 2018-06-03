package com.pi.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.pi.model.entidade.Pessoa;
import com.pi.model.entidadehibernatedao.PessoaHibernateDAO;

@FacesConverter(forClass=Pessoa.class, value="pessoaConverter")
public class PessoaConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value){
        if(value == null || value.isEmpty()){
            return null;
        }else{
            Pessoa pessoa = new PessoaHibernateDAO().buscarPorNome(value);
            return pessoa;
        } 
    }
    
    @Override
    public String getAsString (FacesContext context, UIComponent component, Object value){
        if (value instanceof String) {
            return value.toString();
        }       
        
        return ((Pessoa)value).getNome();
    }
    
}