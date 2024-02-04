public class CameraData {
    enum ObjectType {
        none,
        vehicle,
        pedestrian,
        bicycle,
        stopLight,
        speedLimit
    }

    ObjectType object;
}
