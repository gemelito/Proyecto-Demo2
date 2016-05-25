package android.pedro.mx.trenesito_v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.pedro.mx.trenesito_v2.Fragments.FragmentoDirecciones;
import android.pedro.mx.trenesito_v2.Fragments.FragmentoPerfil;
import android.pedro.mx.trenesito_v2.Fragments.FragmentoTarjetas;
import android.pedro.mx.trenesito_v2.Models.Iglesia;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 102A-PedroCanche on 25/05/16.
 */
public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_NAME = "android.pedro.mx.trenesito_v2.name";
    private static final String EXTRA_DRAWABLE = "android.pedro.mx.trenesito_v2.drawable";

    ViewPager mViewPager;


    public static void createInstance(Activity activity, Iglesia title) {
        Intent intent = getLaunchIntent(activity, title);
        activity.startActivity(intent);
    }

    public static Intent getLaunchIntent(Context context, Iglesia iglesia) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_NAME, iglesia.getTitle());
        intent.putExtra(EXTRA_DRAWABLE, iglesia.getImagen());
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setToolbar(); // Añadir la toolbar


        // Setear adaptador al viewpager.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager);

        // Preparar las pestañas
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.setupWithViewPager(mViewPager);
    }

    private void setToolbar() {
        // Añadir la Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupViewPager(ViewPager viewPager) {
        AdaptadorSecciones adapter = new AdaptadorSecciones(getSupportFragmentManager());
        adapter.addFragment(new FragmentoPerfil(), getString(R.string.titulo_tab_perfil));
        adapter.addFragment(new FragmentoDirecciones(), getString(R.string.titulo_tab_direcciones));
        adapter.addFragment(new FragmentoTarjetas(), getString(R.string.titulo_tab_tarjetas));
        viewPager.setAdapter(adapter);
    }



    /**
     * Un {@link FragmentStatePagerAdapter} que gestiona las secciones, fragmentos y
     * títulos de las pestañas
     */
    public class AdaptadorSecciones extends FragmentStatePagerAdapter {
        private final List<android.support.v4.app.Fragment> fragmentos = new ArrayList<>();
        private final List<String> titulosFragmentos = new ArrayList<>();

        public AdaptadorSecciones(FragmentManager fm) {
            super(fm);
        }


        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragmentos.get(position);
        }

        @Override
        public int getCount() {
            return fragmentos.size();
        }

        public void addFragment(android.support.v4.app.Fragment fragment, String title) {
            fragmentos.add(fragment);
            titulosFragmentos.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titulosFragmentos.get(position);
        }
    }

}
