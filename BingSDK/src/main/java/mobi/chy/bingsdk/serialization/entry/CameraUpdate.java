package mobi.chy.bingsdk.serialization.entry;

import mobi.chy.bingsdk.serialization.ISerializable;
import mobi.chy.bingsdk.serialization.SerializationManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonid Veremchuk on 11/2/16.
 */

public class CameraUpdate extends BaseBingEntry implements ISerializable {
    List<Location> mLocationList;

    public CameraUpdate() {
        mLocationList = new ArrayList<>();
    }

    public void addBounds(Location latLng) {
        mLocationList.add(latLng);
    }

    public void setMapOptions(MapOption mapOptions) {
        mValues.put(getEntryName(mapOptions), mapOptions);
    }

    public void setViewOptions(ViewOptions viewOptions) {
        mValues.put(getEntryName(viewOptions), viewOptions);
    }

    public MapOption getMapOptions() {
        return (MapOption) mValues.get(getEntryName(MapOption.class));
    }

    @Override
    public String toJsObject() {
        mValues.put("location", new SerializationManager().serializeToStringArray(mLocationList));
        return toBaseString(mValues);
    }
}
