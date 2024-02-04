// modified by Tasbi, Madhur And Aeraf on 5th october

using System;

public abstract class Vehicle 
{
    // These methods are declared as abstract, thus must be implemented by derived classes.
    public abstract double GetDistance();
    public abstract double GetTime();
    public abstract double GetFuelLevel();
    public abstract double GetFuelCost();
    public abstract void Travel(double distance);
    public abstract void AddFuel(double amount);
}

public static class VehicleUtility
{
    public static void PrintVehicleInformation(Vehicle vehicle, string vehicleType)
    {
        Console.WriteLine("Vehicle Type: " + vehicleType);
        Console.WriteLine("Travel Distance: " + Math.Round(vehicle.GetDistance(), 3) + "km");
        Console.WriteLine("Travel Time: " + Math.Round(vehicle.GetTime(), 4) + " hours");
        Console.WriteLine("Current Fuel Level: " + Math.Round(vehicle.GetFuelLevel(), 2) + "L");
        Console.WriteLine("Fuel Cost: $" + Math.Round(vehicle.GetFuelCost(), 2));
        Console.WriteLine();
    }
}
