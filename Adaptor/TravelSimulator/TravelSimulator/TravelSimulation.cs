// modified by tasbi madhur and aeraf on 5th october

using System;

class TravelSimulation
{
    static void Main()
    {

        Vehicle car = new CarAdapter(new Car());
        Vehicle airplane = new AirplaneAdapter(new Airplane());
        Vehicle boat = new BoatAdapter(new Boat());

        // the boat travels 100km and information about the boat is printed
        boat.Travel(100.0);
        VehicleUtility.PrintVehicleInformation(boat, "Boat");

        // the car travels 1000km and information about the car is printed
        car.Travel(1000.0);
        VehicleUtility.PrintVehicleInformation(car, "Car");

        // the airplane travels 10000km and information about the airplane is printed
        airplane.Travel(10000.0);
        VehicleUtility.PrintVehicleInformation(airplane, "Airplane");

        // Add fuel to each
        Console.WriteLine();
        Console.WriteLine("Adding fuel...");
        Console.WriteLine();

        boat.AddFuel(120);
        car.AddFuel(40);
        airplane.AddFuel(50000);

        // Travel again
        // Boat
        boat.Travel(100.0);
        VehicleUtility.PrintVehicleInformation(boat, "Boat");

        // Car
        car.Travel(1000.0);
        VehicleUtility.PrintVehicleInformation(car, "Car");

        // Airplane
        airplane.Travel(10000.0);
        VehicleUtility.PrintVehicleInformation(airplane, "Airplane");

        Console.ReadLine();
    }
}
