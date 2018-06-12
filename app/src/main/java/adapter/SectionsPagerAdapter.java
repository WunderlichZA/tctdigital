package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragments.SlideOneFragment;
import fragments.SlideThreeFragment;
import fragments.SlideTwoFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SlideOneFragment();
            case 1:
                return new SlideTwoFragment();
            case 2:
                return new SlideThreeFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages
        return 3;
    }
}
