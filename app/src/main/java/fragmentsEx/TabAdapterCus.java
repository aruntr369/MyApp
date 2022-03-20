package fragmentsEx;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabAdapterCus extends FragmentStatePagerAdapter {
    int noOfTabs;

    public TabAdapterCus(@NonNull FragmentManager fm,int noOfTabs) {
        super(fm);
        this.noOfTabs=noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                AboutFragment aboutFragment = new AboutFragment();
                return aboutFragment;
            case 2:
                ContactFragment contactFragment = new ContactFragment();
                return contactFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
