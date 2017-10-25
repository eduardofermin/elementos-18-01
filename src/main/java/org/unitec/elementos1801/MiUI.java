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
import com.vaadin.ui.HorizontalLayout;
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
        
        Label etiquetaGuardar = new Label("Guardar mensajes");
        etiquetaGuardar.addStyleName(ValoTheme.LABEL_H2);
        
        TextField textoTitulo = new TextField();
        textoTitulo.setPlaceholder("Escribe el titulo");
        
        TextArea textoArea = new TextArea();
        textoArea.setPlaceholder("Escribe el cuerpo del mensaje");
        
        // Create a grid bound to the list
        Grid<Mensajito> grid = new Grid<>();
        grid.setItems((List)repoMensa.findAll());
        grid.addColumn(Mensajito::getId).setCaption("Id del mensaje");
        grid.addColumn(Mensajito::getTitulo).setCaption("Titulo del mensaje");
        grid.addColumn(Mensajito::getCuerpo).setCaption("Cuepo del mensaje");
        
        Button boton = new Button("Guardar mensaje");
        boton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        boton.addClickListener(evento->{
            if(textoTitulo.getValue().equals("")|| textoArea.getValue().equals("")){
                Notification.show("Los campos estan vacios", Notification.Type.ERROR_MESSAGE);
            }else{
                repoMensa.save(new Mensajito (textoTitulo.getValue(),textoArea.getValue()));
                Notification.show("Se guardo el mensaje", Notification.Type.WARNING_MESSAGE);
                textoTitulo.clear();
                textoArea.clear();
                grid.setItems((List) repoMensa.findAll());
            }
        });

        //Agregamos todas las componentes de los elemtos usados
        layout.addComponent(etiquetaGuardar);
        layout.addComponent(textoTitulo);
        layout.addComponent(textoArea);
        layout.addComponent(boton);
        layout.addComponent(grid);
        
        ///primero creamos un horizontal layout
        HorizontalLayout layout1 = new  HorizontalLayout();
        TextField textoId = new TextField();
        textoId.setPlaceholder("Introduce el ID");
        Button botonBuscarId = new Button("Buscar id");
        botonBuscarId.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        
        layout1.addComponent(textoId);
        layout1.addComponent(botonBuscarId);
        layout.addComponent(layout1);
        
        //creamos otro layout para los campos de 
        HorizontalLayout layout2 = new HorizontalLayout();
        TextField textoBucarId = new TextField();
        TextField textoBucarTitulo = new TextField();
        TextArea textoBucarCuerpo = new TextArea();
        
        layout2.addComponent(textoBucarId);
        layout2.addComponent(textoBucarTitulo);
        layout2.addComponent(textoBucarCuerpo);
        layout.addComponent(layout2);
        
        Button botonActualizar = new Button("Actualizar");
        botonActualizar.addStyleName(ValoTheme.BUTTON_DANGER);
        layout.addComponent(botonActualizar);
        
        setContent(layout);
        
        //vamos a buscar por id
        botonBuscarId.addClickListener(evento->{
            Mensajito mensa = repoMensa.findOne(Integer.parseInt(textoId.getValue()));
            //ajustamos los tres campos con los datos
            //primero el ID
            textoBucarId.setValue(""+mensa.getId());
            textoBucarTitulo.setValue(mensa.getTitulo());
            textoBucarCuerpo.setValue(mensa.getCuerpo());
        });
    }
}
