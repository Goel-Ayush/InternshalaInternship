package com.example.android.internshalaintern;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.database.Cursor;
import android.view.ViewGroup;
import android.widget.ListView;

public class DashboardFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int DASHBOARD_LOADER=1;
    private DashboardDbHelper mDbHelper;
    private DashboardAdapter mCursorAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View rootView = inflater.inflate(R.layout.fragment_dashboard,container,false);
      getLoaderManager().initLoader(DASHBOARD_LOADER,null,this);

      ListView listView = (ListView)rootView.findViewById(R.id.list);
      View emptyView = rootView.findViewById(R.id.empty_view);
      listView.setEmptyView(emptyView);

      mDbHelper = new DashboardDbHelper(this.getContext());
      mCursorAdapter = new DashboardAdapter(this.getContext(),null);

      listView.setAdapter(mCursorAdapter);
      return rootView;
    }


    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        String[] projection = {
                DashboardContract.DashboardEntry._ID,
                DashboardContract.DashboardEntry.COLUMN_COURSE_NAME,
                DashboardContract.DashboardEntry.COLUMN_ABOUT_COURSE
        };

        return new CursorLoader(this.getContext(), DashboardContract.DashboardEntry.CONTENT_URI,projection,null,null,null);

    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        mCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mCursorAdapter.swapCursor(null);
    }
}
