package proto.idss.maplebear;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class DrawableMapOverlay extends Overlay implements OnTouchListener{
	
	

  private static final double MAX_TAP_DISTANCE_KM = 3;
  // Rough approximation - one degree = 50 nautical miles
  private static final double MAX_TAP_DISTANCE_DEGREES = MAX_TAP_DISTANCE_KM * 0.5399568 * 50;
  private GeoPoint geoPoint;
  private Context context;
  private int drawable;

  /**
   * @param context the context in which to display the overlay
   * @param point the geographical point where the overlay is located
   * @param drawable the ID of the desired drawable
 * @return 
   */
  public DrawableMapOverlay(Context context, GeoPoint point, int drawable) {
    this.context = context;
    this.geoPoint = point;
    this.drawable = drawable;
    
    
    
  }

  public DrawableMapOverlay(Location context2, Point point, int pin) {
	// TODO Auto-generated constructor stub
}

@Override
  public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when) {
    super.draw(canvas, mapView, shadow);

    // Convert geo coordinates to screen pixels
    Point screenPoint = new Point();
    mapView.getProjection().toPixels(geoPoint, screenPoint);

    // Read the image
    Bitmap markerImage = BitmapFactory.decodeResource(context.getResources(), drawable);

    // Draw it, centered around the given coordinates
    	canvas.drawBitmap(markerImage,
        screenPoint.x - markerImage.getWidth() / 2,
        screenPoint.y - markerImage.getHeight() / 2, null);
    
   
    
    return true;
  }

  @Override
  public boolean onTap(GeoPoint p, MapView mapView) {
    // Handle tapping on the overlay here
    return true;
  }

@Override
public boolean onTouch(View v, MotionEvent event) {
	// TODO Auto-generated method stub
	return false;
}
}


