package th.ac.kutc.computer.show_bru_win.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import th.ac.kutc.computer.show_bru_win.R;
import th.ac.kutc.computer.show_bru_win.utility.FoodAdapter;
import th.ac.kutc.computer.show_bru_win.utility.GetAllData;
import th.ac.kutc.computer.show_bru_win.utility.MyConstant;

public class ServiceFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create ListView
        createListView();


    }   // Main Method

    private void createListView() {
        ListView listView = getView().findViewById(R.id.ListViewFood);
        MyConstant myConstant = new MyConstant();

        try {
            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myConstant.getUrlGetAllFood());

            String jsonString = getAllData.get();

            JSONArray jsonArray = new JSONArray(jsonString);

            String[] foodStrings = new String[jsonArray.length()];
            String[] priceStrings = new String[jsonArray.length()];
            String[] detailStrings = new String[jsonArray.length()];
            String[] imageStrings = new String[jsonArray.length()];

            for (int i=0; i<jsonArray.length(); i+=1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                foodStrings[1] = jsonObject.getString("NameFood");
                priceStrings[1] = jsonObject.getString("Price");
                detailStrings[1] = jsonObject.getString("Detail");
                imageStrings[1] = jsonObject.getString("ImagePath");


            }

            FoodAdapter foodAdapter = new FoodAdapter(getActivity(),
                    imageStrings, foodStrings, priceStrings, detailStrings);
            listView.setAdapter(foodAdapter);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        return view;
    }
}
