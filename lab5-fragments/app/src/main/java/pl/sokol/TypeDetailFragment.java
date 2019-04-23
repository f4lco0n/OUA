package pl.sokol;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class TypeDetailFragment extends Fragment {


    private long typeId;


    public TypeDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState != null){
            typeId = savedInstanceState.getLong("typeId");
        }

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        StopwatchFragment stopwatchFragment = new StopwatchFragment();
        fragmentTransaction.replace(R.id.stopwatch_container,stopwatchFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();

        return inflater.inflate(R.layout.fragment_type_detail, container, false);
    }



    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null){
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Type type = Type.TYPES[(int) typeId];
            title.setText(type.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(type.getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("typeId",typeId);
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }


}
