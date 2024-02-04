// created by Tasbi on 4th october

using System;

public class BoatAdapter : Vehicle
{
    private Boat boat;

    public BoatAdapter(Boat boat)
    {
        this.boat = boat;
    }

    public override double GetDistance()
    {
        // Delegates the GetDistance method to the Boat class
        return boat.GetBoatDistance();
    }

    public override double GetTime()
    {
        // Delegates the GetTime method to the Boat class
        return boat.GetBoatTime();
    }

    public override double GetFuelLevel()
    {
        // Delegates the GetFuelLevel method to the Boat class
        return boat.GetBoatFuelLevel();
    }

    public override double GetFuelCost()
    {
        // Delegates the GetFuelCost method to the Boat class
        return boat.GetBoatFuelCost();
    }

    public override void Travel(double distance)
    {
        // Delegates the Travel method to the Boat class
        boat.BoatTravel(distance);
    }

    public override void AddFuel(double amount)
    {
        // Delegates the AddFuel method to the Boat class
        boat.BoatAddFuel(amount);
    }
}
