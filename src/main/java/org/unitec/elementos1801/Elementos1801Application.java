package org.unitec.elementos1801;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Elementos1801Application implements CommandLineRunner {

    @Autowired RepositorioMensajito repoMensa;
    @Autowired RepositorioUsuario repoUsuario;
    @Autowired RepositorioDireccion repoDireccion;

	public static void main(String[] args) {
		SpringApplication.run(Elementos1801Application.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        /*
        //guardar
        //repoMensa.save(new Mensajito("17 de octubre", "No temblo"));
        
        System.out.println("vamos a buscar todos");
        
        //buscar todos
        for( Mensajito mensa : repoMensa.findAll()){
            //System.out.println(mensa.getTitulo());
            System.out.println(mensa);
        }
            
            //buscar por id
            System.out.println("Vamos a buscar por ID");
            System.out.println(repoMensa.findOne(1));
            
            //Actualizar
            repoMensa.save(new Mensajito(1,"Nuevo titulo","Nuevo cuerpo"));
            System.out.println(repoMensa.findOne(1));
            
            //borrar por id
            //repoMensa.delete(1);
            //System.out.println("Se borro exitosamente");
            
            //busqueda personaizada
            System.out.println("Busqueda personalizada");
           for(Mensajito mensa : repoMensa.findByTitulo("Nuevo titulo")){
                System.out.println(mensa);
            }*/
        
        //para el repositorio usuario, generamos el primer usuario
        //Usuario u = new Usuario(15254L, "Eduardo fermin", "kiqo95@hotmail.com");
        //repoUsuario.save(u);
        
        //para el repositorio direccion, generamos direccion
        //Direccion d = new Direccion(new Usuario(15254L), "C. laguna", 55070, "Ecatepec");
        //repoDireccion.save(d);
        
        //haremos el join
        //Direccion d2 = repoDireccion.findOne(1L);
        //System.out.println("Correo: " + d2.getU().getEmail() + "CP: " + d2.getMunicipio());
    }
}
