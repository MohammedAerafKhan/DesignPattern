using System;

public class Car
{
    private const double CAPACITY = 50.0; // 50L of fuel
    private const double FUEL_EFFICIENCY = 8.9; // 8.9L/100km
    private const double DOLLARS_PER_LITRE = 1.59; // $1.59/L of gas
    private const double SPEED = 60.0; // averages 60km/hour
    private double fuel = CAPACITY;
    private double totalDistance = 0.0;

    public void CarAddFuel(double amount)
    {
        fuel += amount;
        if (fuel > CAPACITY)
        {
            Console.WriteLine("Fuel overflow, capping at " + CAPACITY + "L.");
            fuel = CAPACITY;
        }
    }

    public double GetCarDistance()
    {
        // Calculate car distance logic
        return totalDistance;
    }

    public double GetCarTime()
    {
        double time = totalDistance / SPEED;
        return time;
    }

    public double GetCarFuelLevel()
    {
        // Calculate car fuel consumption logic
        return fuel;
    }

    public double GetCarFuelCost()
    {
        double cost = totalDistance * FUEL_EFFICIENCY / 100.0 * DOLLARS_PER_LITRE;
        return cost;
    }

    public void CarTravel(double distance)
    {
        double maxDistance = fuel / (FUEL_EFFICIENCY / 100.0);
        if (maxDistance < distance)
        {
            Console.WriteLine("Not enough fuel to travel " + distance + "km. Travelling " + maxDistance + "km instead.");
            totalDistance += maxDistance;
            fuel = 0.0;
        }
        else
        {
            totalDistance += distance;
            fuel -= distance * FUEL_EFFICIENCY / 100.0;
        }
    }
}
