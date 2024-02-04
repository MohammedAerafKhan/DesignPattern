using System;

public class Boat
{
    private const double CAPACITY = 150.0; // 150L of fuel
    private const double FUEL_CONSUMPTION = 20.0; // 20L/hour
    private const double DOLLARS_PER_LITRE = 1.69; // $1.69/L of fuel
    private const double SPEED = 20.0; // averages 20.0km/hour
    private double fuel = CAPACITY;
    private double totalDistance = 0.0;

    public void BoatAddFuel(double amount)
    {
        fuel += amount;
        if (fuel > CAPACITY)
        {
            Console.WriteLine("Fuel overflow, capping at " + CAPACITY + "L.");
            fuel = CAPACITY;
        }
    }

    public double GetBoatDistance()
    {
        // Calculate boat distance logic
        return totalDistance;
    }

    public double GetBoatTime()
    {
        double time = totalDistance / SPEED;
        return time;
    }

    public double GetBoatFuelLevel()
    {
        // Calculate boat fuel consumption logic
        return fuel;
    }

    public double GetBoatFuelCost()
    {
        double cost = FUEL_CONSUMPTION * GetBoatTime() * DOLLARS_PER_LITRE;
        return cost;
    }

    public void BoatTravel(double distance)
    {
        double time = distance / SPEED;
        double maxTime = fuel / FUEL_CONSUMPTION;
        if (maxTime < time)
        {
            double maxDistance = maxTime * SPEED;
            Console.WriteLine("Not enough fuel to travel " + distance + "km. Travelling " + maxDistance + "km instead.");
            totalDistance += maxDistance;
            fuel = 0.0;
        }
        else
        {
            totalDistance += distance;
            fuel -= time * FUEL_CONSUMPTION;
        }
    }
}

