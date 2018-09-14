package vizagtour.prakash.com.vizagtourapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class RestaurantTabAdapter extends FragmentPagerAdapter {


    public RestaurantTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new BudgetRestaurantsFragment();

            case 1:
                return new ExpensiveRestaurantsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Budget";
            case 1:
                return "Expensive";
        }
        return null;
    }
}
