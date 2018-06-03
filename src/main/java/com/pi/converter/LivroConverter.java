package com.pi.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.pi.model.entidade.Livro;
import com.pi.model.entidadehibernatedao.LivroHibernateDAO;

@FacesConverter(forClass = Livro.class, value = "livroConverter")
public class LivroConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty()){
            return null;
        }else{
            Livro livro = new LivroHibernateDAO().buscarPorTitulo(value);
            return livro;
        }  
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof String) {
            return value.toString();
        } 
        return ((Livro)value).getTitulo();
    }
}