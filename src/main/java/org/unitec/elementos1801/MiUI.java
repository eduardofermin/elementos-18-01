/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.elementos1801;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author T-107
 */

@SpringUI
@Theme("valo")
public class MiUI extends UI{
    
    //para guardar secrea un atributo para guardar
    @Autowired RepositorioMensajito repoMensa;

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        
        //generamos etiqueta
        Label etiqueta = new Label("Aplicaciones con mensajes");
        etiqueta.addStyleName(ValoTheme.LABEL_H1);
        layout.addComponent(etiqueta);
        setContent(layout);
        
        Label etiquetaGuardar = new Label("Guardar mensajes");
        etiquetaGuardar.addStyleName(ValoTheme.LABEL_H2);
        
        TextField textoTitulo = new TextField();
        textoTitulo.setPlaceholder("Escribe el titulo");
        
        TextArea textoArea = new TextArea();
        textoArea.setPlaceholder("Escribe el cuerpo del mensaje");
        
        Button boton = new Button("Guardar mensaje");
        boton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        boton.addClickListener(evento->{
            if(textoTitulo.getValue().equals("")&&textoArea.getValue().equals("")){
                Notification.show("Los campos estan vacios", Notification.Type.ERROR_MESSAGE);
            }else{
                repoMensa.save(new Mensajito (textoTitulo.getValue(),textoArea.getValue()));
                Notification.show("Se guardo el mensaje", Notification.Type.WARNING_MESSAGE);
                textoTitulo.clear();
                textoArea.clear();
            }
        });

        // Create a grid bound to the list
        Grid<Mensajito> grid = new Grid<>();
        grid.setItems((List)repoMensa.findAll());
        grid.addColumn(Mensajito::getTitulo).setCaption("Titulo del mensaje");
        grid.addColumn(Mensajito::getCuerpo).setCaption("Cuepo del mensaje");
        
        //Agregamos todas las componentes de los elemtos usados
        layout.addComponent(etiquetaGuardar);
        layout.addComponent(textoTitulo);
        layout.addComponent(textoArea);
        layout.addComponent(boton);
        layout.addComponent(grid);
        
    }
}
