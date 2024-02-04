// Control Module - this module brings together gps data, sensor data, and planning data

// Written by Madhur, Tasbi and Aeraf

public class ControlModule {

    private  GPSData gpsData;

    // write a function to initialize GPS data
    public void setGPSData(GPSData data){
        this.gpsData = data;
    }

    // write a function to adjust speed and direction based on:
    // - the processing of sensor data
    // - the planning of your route
    // - the updating of your route
    // end your journey after 24 hours or within 25km of your destination

    /*
     * Initiates the self-driving simulation based on integrated GPS, sensor, and planning data.
     * The simulation adjusts speed and direction, plans routes, and updates routes until the journey ends.
     * The journey terminates after 24 hours or within 25km of the destination.
     */

    public void startSelfDrive() {
        PlanningModule planningModule = new PlanningModule(gpsData);
        planningModule.updateRoute();
        int tick = 1;

        while (tick < 24) {
            if (planningModule.getDistance() < 25) {
                break;
            }
            planningModule.planNextRoute();
            planningModule.updateRoute();
            tick++;

//            Uncomment this part to make the execution stop for 1 hour.
//            this way the simulation will run for 24 hours (not tested)
//            try {
//                TimeUnit.HOURS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
    }
}
