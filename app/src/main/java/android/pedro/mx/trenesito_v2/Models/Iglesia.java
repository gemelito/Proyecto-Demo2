package android.pedro.mx.trenesito_v2.Models;

import android.pedro.mx.trenesito_v2.R;

import java.util.Random;

/**
 * Created by 102A-PedroCanche on 25/05/16.
 */
public class Iglesia {
    private String title;
    private int imagen;

    public Iglesia(String title, int imagen){
        this.title = title;
        this.imagen = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
