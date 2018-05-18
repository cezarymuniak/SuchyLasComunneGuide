package android.com.suchylascommuneguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Menu3ShoppingFragment extends android.app.Fragment implements OnMapReadyCallback {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_3, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MapFragment fragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map2);
        fragment.getMapAsync(this);
        getActivity().setTitle("Shopping");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Suchy Las and move the camera
        LatLng suchyLas = new LatLng(52.47304, 16.87553);
        googleMap.setMaxZoomPreference(20.0f);
        googleMap.setMinZoomPreference(15.0f);
        googleMap.addMarker(new MarkerOptions().position(suchyLas).title("Galeria Sucholeska"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(suchyLas));
        googleMap.setBuildingsEnabled(true);
        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

    }
}
