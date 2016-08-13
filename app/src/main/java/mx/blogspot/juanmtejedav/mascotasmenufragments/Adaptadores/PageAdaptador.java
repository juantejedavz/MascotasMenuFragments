package mx.blogspot.juanmtejedav.mascotasmenufragments.Adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by juantejeda1 on 08/08/16.
 */
public class PageAdaptador extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;

    public PageAdaptador(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
