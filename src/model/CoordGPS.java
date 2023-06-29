package model;

import java.lang.reflect.GenericSignatureFormatError;

public class CoordGPS {
	private double latitude;
	private double longitude;
	
	public CoordGPS(String geometry) {
		this(getLatitudeFromGeometry(geometry),getLongitudeFromGeometry(geometry));
	}
	
	public CoordGPS(double lat, double lon) {
		latitude = lat;
		longitude = lon;
	}
	
	private static String[] extractLatLongFromGeometry(String geometry) {
		String extract = geometry.substring(2, geometry.length()-1);
		String[] coord = extract.split(", ");
		return coord;
	}
	
	private static double getLatitudeFromGeometry(String geometry) {
		return Double.parseDouble(extractLatLongFromGeometry(geometry)[0]);
	}
	
	private static double getLongitudeFromGeometry(String geometry) {
		return Double.parseDouble(extractLatLongFromGeometry(geometry)[1]);
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public double distanceToParis() {
		// RAyon de la terre
		final int R = 6371;
		// Coordonnées de Paris
		CoordGPS refCoord = new CoordGPS(2.3478812232800306,48.85393138855701);
		// Calcul de la distance entre la ville et Paris
		double dLat = Math.toRadians(refCoord.getLatitude()-latitude);
		double dLon = Math.toRadians(refCoord.getLongitude()-longitude);
		double lat1 = Math.toRadians(latitude);
		double lat2 = Math.toRadians(refCoord.getLatitude());
		double a 	= Math.pow(Math.sin(dLat/2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
		double c 	= 2 * Math.asin(Math.sqrt(a));
		double d 	= R * c;

		 // Affichage de la distance entre la ville et Paris
		return d;
	}

	@Override
	public String toString() {
		return "CoordGPS [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
