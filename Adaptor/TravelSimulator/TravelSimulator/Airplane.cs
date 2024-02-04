using System;

public class Airplane
{
    private const double CAPACITY = 100000.0; // 100000L of fuel
    private const double FUEL_CONSUMPTION = 5400.0; // 5400L/hour
    private const double DOLLARS_PER_LITRE = 0.75; // $0.75/L of fuel
    private const double SPEED = 800.0; // averages 800.0km/hour
    private double fuel = CAPACITY;
    private double totalDistance = 0.0;

    public void AirplaneAddFuel(double amount)
    {
        fuel += amount;
        if (fuel > CAPACITY)
        {
            Console.WriteLine("Fuel overflow, capping at " + CAPACITY + "L.");
            fuel = CAPACITY;
        }
    }

    public double GetAirplaneDistance()
    {
        // Calculate airplane distance logic
        return totalDistance;
    }

    public double GetAirplaneTime()
    {
        double time = totalDistance / SPEED;
        return time;
    }

    public double GetAirplaneFuelLevel()
    {
        // Calculate airplane fuel consumption logic
        return fuel;
    }

    public double GetAirplaneFuelCost()
    {
        double cost = FUEL_CONSUMPTION * GetAirplaneTime() * DOLLARS_PER_LITRE;
        return cost;
    }

    public void AirplaneTravel(double distance)
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
