package Kinomichi.Activite;

import java.util.LinkedList;
import java.util.List;

public class ListActivites {
    List<Activite> listActivites=new LinkedList<>();
    public ListActivites(){
        this.listActivites=listActivites;
    }
    public List<Activite>getListActivites(){
        return listActivites;
    }
    public void setListActivites(List<Activite> listActivites){
        this.listActivites=listActivites;
    }
}
