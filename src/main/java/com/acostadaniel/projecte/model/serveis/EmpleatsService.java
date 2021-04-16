package com.acostadaniel.projecte.model.serveis;

import com.acostadaniel.projecte.model.entitats.Empleats;
import com.acostadaniel.projecte.repositoris.RepositoriEmpleats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class EmpleatsService {
    @Autowired
    private RepositoriEmpleats repositoriEmpleats;

    private List<Empleats> repositori = new ArrayList<>();

    public void afegir(Empleats emp) {
        repositori.add(emp);
    }

    public List<Empleats> llistat(){
        return repositori;
    }

    public void eliminarEmpleat(int id){
        repositori.removeIf(emp -> emp.getId() == id);
    }

    public void substituirEmpleat(Empleats e){
        for (int i = 0; i < repositori.size(); i++){
            if (repositori.get(i).getId() == e.getId()){
                repositori.set(i, e);
            }
        }
    }

    public Empleats consultaPerId(int id){
        Empleats e = new Empleats();
        for (Empleats x:repositori) {
            if (x.getId() == id){
                e = x;
            }
        }
        return e;
    }

    public List<Empleats> llistatOrdenatPerNom(){
        List<Empleats> sortedList = new ArrayList<>(repositori);

        Collections.sort(sortedList, new Comparator<Empleats>() {
            @Override
            public int compare(Empleats o1, Empleats o2) {
                return o1.getNom().compareTo(o2.getNom());
            }
        });
        return sortedList;
    }

//    @PostConstruct
//    public void init() {
//        repositoriEmpleats.save(new Empleats(1, "Montse Madridejos", "montse@itb.cat", "677123456", true));
//        repositoriEmpleats.save(new Empleats(2, "Alberto Vila", "alberto@itb.cat", "699876543", false));
//        repositoriEmpleats.save(new Empleats(3, "Robert López", "robert@bbc.com", "123456789", true));
////        repositori.addAll(
////                Arrays.asList(
////                        new Empleats(1, "Montse Madridejos", "montse@itb.cat", "677123456", true),
////                        new Empleats(2, "Alberto Vila", "alberto@itb.cat", "699876543", false),
////                        new Empleats(3, "Robert López", "robert@bbc.com", "123456789", true)
////                )
////        );
//    }
}
