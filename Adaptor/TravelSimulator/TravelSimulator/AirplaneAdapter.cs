// created by Mohammed Aeraf Khan on 4th october

using System;

public class AirplaneAdapter : Vehicle
{
    private Airplane airplane;

    public AirplaneAdapter(Airplane airplane)
    {
        this.airplane = airplane;
    }

    public override double GetDistance()
    {
        // Delegates the GetDistance method to the Airplane class
        return airplane.GetAirplaneDistance();
    }

    public override double GetTime()
    {
        // Delegates the GetTime method to the Airplane class
        return airplane.GetAirplaneTime();
    }

    public override double GetFuelLevel()
    {
        // Delegates the GetFuelLevel method to the Airplane class
        return airplane.GetAirplaneFuelLevel();
    }

    public override double GetFuelCost()
    {
        // Delegates the GetFuelCost method to the Airplane class
        return airplane.GetAirplaneFuelCost();
    }

    public override void Travel(double distance)
    {
        // Delegates the Travel method to the Airplane class
        airplane.AirplaneTravel(distance);
    }

    public override void AddFuel(double amount)
    {
        // Delegates the AddFuel method to the Airplane class
        airplane.AirplaneAddFuel(amount);
    }
}
