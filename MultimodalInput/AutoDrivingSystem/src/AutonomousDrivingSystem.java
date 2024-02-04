// Written by Madhur, Tasbi and Aeraf

public class AutonomousDrivingSystem {

    private final ControlModule controlModule = new ControlModule();

    public void initGpsData(double latitude1, double longitude1, double latitude2, double longitude2) {
        GPSData gpsData = new GPSData();
        gpsData.curr_latitude = latitude1;
        gpsData.curr_longitude = longitude1;
        gpsData.dest_latitude = latitude2;
        gpsData.dest_longitude = longitude2;

        // Set the GPSData in the control module for self-driving simulation
        controlModule.setGPSData(gpsData);
    }

    public void runSimulation() {
        // Start the self-driving simulation using the control module
       controlModule.startSelfDrive();
    }
}