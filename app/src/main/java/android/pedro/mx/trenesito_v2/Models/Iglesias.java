package android.pedro.mx.trenesito_v2.Models;

import android.pedro.mx.trenesito_v2.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 102A-PedroCanche on 25/05/16.
 */
public class Iglesias {
    public static List<Iglesia> Iglesias = new ArrayList<Iglesia>();
    static{
        Iglesias.add(new Iglesia("Saban", R.drawable.saban));
        Iglesias.add(new Iglesia("Sacalaca",  R.drawable.sacalaca));
        Iglesias.add(new Iglesia("Xcabil",  R.drawable.xcabil));
        Iglesias.add(new Iglesia("Huay max",  R.drawable.huaymax));
        Iglesias.add(new Iglesia("Tepich", R.drawable.tepich));
        Iglesias.add(new Iglesia("Tihosuco", R.drawable.tihosuco));

    }
    /*public static final String[] iglesiasTitle = {
            "Saban","Tihosuco","Huay Max", "Xcabil", "Sacalaca", "Tepich"
    };

    public static List<Iglesia> List(int count){

        List<Iglesia> items = new ArrayList<>();



        while (items.listIterator()) {
            items.add(new Iglesia((iglesiasTitle[(iglesiasTitle.length)])));
        }

        return new ArrayList<>(items);
    }*/
}
