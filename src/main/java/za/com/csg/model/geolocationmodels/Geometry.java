package za.com.csg.model.geolocationmodels;

public class Geometry {

    Bounds Bounds;
    Location location;
    private String locationType;
    Viewport Viewport;

    public za.com.csg.model.geolocationmodels.Bounds getBounds() {
        return Bounds;
    }

    public void setBounds(za.com.csg.model.geolocationmodels.Bounds bounds) {
        Bounds = bounds;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public za.com.csg.model.geolocationmodels.Viewport getViewport() {
        return Viewport;
    }

    public void setViewport(za.com.csg.model.geolocationmodels.Viewport viewport) {
        Viewport = viewport;
    }
}
