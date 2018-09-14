package music.prakash.com.musicalstructureapp.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import music.prakash.com.musicalstructureapp.activity.R;
import music.prakash.com.musicalstructureapp.fragment.AlbumFragment;
import music.prakash.com.musicalstructureapp.fragment.ArtistFragment;
import music.prakash.com.musicalstructureapp.fragment.PaymentFragment;
import music.prakash.com.musicalstructureapp.fragment.PlaylistFragment;
import music.prakash.com.musicalstructureapp.fragment.SongFragment;

public class MusicAdapter extends FragmentStatePagerAdapter {

    private static int count = 5;

    public MusicAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new SongFragment();
            case 1:
                return new ArtistFragment();
            case 2:
                return new AlbumFragment();
            case 3:
                return new PlaylistFragment();
            case 4:
                return new PaymentFragment();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);
        switch (position) {
            case 0:
                return "Songs";
            case 1:
                return "Artists";
            case 2:
                return "Albums";
            case 3:
                return "PlayLists";
            case 4:
                return "Payments";
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return count;
    }
}
