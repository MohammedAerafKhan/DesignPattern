// Written by Madhur, Tasbi and Aeraf

import java.text.DecimalFormat;

// Planning Module - plans a route based on GPS data and obstacle information (LIDAR data)
public class PlanningModule {
    private final GPSData data;

    private final CameraData cameraData =  new CameraData();
    private final LidarData lidarData =  new LidarData();
    private final PerceptionModule perceptionModule = PerceptionModule.getInstance();

    // constructor
    PlanningModule(GPSData gpsData) {
        data = gpsData;
    }

    // function to update route based on camera and lidar data
    public void updateRoute() {
        System.out.println("You are at " + getRoundedValue(data.curr_longitude) + " long, " + getRoundedValue(data.curr_latitude) +
                " lat. You want to be at " + getRoundedValue(data.dest_longitude) + " long, " + getRoundedValue(data.dest_latitude)
                + " lat. You are " + getRoundedValue(getDistance()) + " km away from your destination. You need to travel at "
                + getRoundedValue(getDirection()) + " degrees"
        );

        perceptionModule.processCameraData(cameraData);
        perceptionModule.processLidarData(lidarData);
    }

    // function to plan route based on current and destination gps data
    public void planNextRoute() {
        PerceptionModule perceptionModule = PerceptionModule.getInstance();
        perceptionModule.incrementTime();

        // Process GPS data to update the internal state in PerceptionModule
        perceptionModule.processGPSData(data, getSpeed(), getDirection());
    }

    // function to get speed based on camera and lidar data.
    private Double getSpeed() {
        double INITIAL_SPEED = 100d;
        double speed = INITIAL_SPEED;
        if (cameraData.object == CameraData.ObjectType.pedestrian || cameraData.object == CameraData.ObjectType.stopLight
                || lidarData.object == LidarData.ObjectType.largeObstruction) {
            speed = 0;
        }
        if (cameraData.object == CameraData.ObjectType.speedLimit ||
                cameraData.object == CameraData.ObjectType.bicycle ||
                cameraData.object == CameraData.ObjectType.vehicle ||
                lidarData.object == LidarData.ObjectType.smallObstruction)  {
            speed = INITIAL_SPEED - 50;
        }
        if (lidarData.object == LidarData.ObjectType.roadCurvature) {
            speed = INITIAL_SPEED - 30;
        }

        return speed;
    }

    // function to get direction based on gps data
    // https://stackoverflow.com/questions/3932502/calculate-angle-between-two-latitude-longitude-points
    private double getDirection() {
        RadianGPSData radGpsData = getGPSDataInRadian();

        // Calculate the difference in longitude
        double deltaLon = radGpsData.radLon2 - radGpsData.radLon1;

        // Calculate the bearing using spherical law of cosines
        double y = Math.sin(deltaLon) * Math.cos(radGpsData.radLat2);
        double x = Math.cos(radGpsData.radLat1) * Math.sin(radGpsData.radLat2) -
                Math.sin(radGpsData.radLat1) * Math.cos(radGpsData.radLat2) * Math.cos(deltaLon);

        // Calculate the bearing angle in radians and convert to degrees
        double bearing = Math.atan2(y, x);
        bearing = Math.toDegrees(bearing);

        // Normalize the bearing to a range of [0, 360)
        return (bearing + 360) % 360;
    }

    // function to calculate the distance between the current location and the final destination
    public double getDistance() {
        RadianGPSData radGpsData = getGPSDataInRadian();

        // Earth radius in kilometers
        double radius = 6371.0;

        // Differences in coordinates
        double dLat = radGpsData.radLat2 - radGpsData.radLat1;
        double dLon = radGpsData.radLon2 - radGpsData.radLon1;

        // Haversine formula
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(radGpsData.radLat1) * Math.cos(radGpsData.radLat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return radius * c;
    }

    // utility function to round values to 3 decimal
    private double getRoundedValue(double value) {
        DecimalFormat df = new DecimalFormat("#.###");
        String formattedNumber = df.format(value);
        return Double.parseDouble(formattedNumber);
    }

    // converting the current gps data values from degree to radian and creating instances for required functions
    private static class RadianGPSData {
        public final double radLat1;
        public final double radLon1;
        public final double radLat2;
        public final double radLon2;

        public RadianGPSData(double radLat1, double radLon1, double radLat2, double radLon2) {
            this.radLat1 = radLat1;
            this.radLon1 = radLon1;
            this.radLat2 = radLat2;
            this.radLon2 = radLon2;
        }
    }

    private RadianGPSData getGPSDataInRadian() {
        double radLat1 = Math.toRadians(data.curr_latitude);
        double radLon1 = Math.toRadians(data.curr_longitude);
        double radLat2 = Math.toRadians(data.dest_latitude);
        double radLon2 = Math.toRadians(data.dest_longitude);
        return new RadianGPSData(radLat1, radLon1, radLat2, radLon2);
    }
}