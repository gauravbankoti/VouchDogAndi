package layout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gaurav.vouchdog.AddNewIdInfo;
import com.example.gaurav.vouchdog.Identification_Details;
import com.example.gaurav.vouchdog.R;

public class IdentificationFrag extends Fragment {
    Button AddnewId;


    public IdentificationFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_identification, container, false);

      AddnewId =(Button)v.findViewById(R.id.button6);

        AddnewId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AddNewIdInfo.class);
                startActivity(intent);
            }
        });
return v;
    }


}
