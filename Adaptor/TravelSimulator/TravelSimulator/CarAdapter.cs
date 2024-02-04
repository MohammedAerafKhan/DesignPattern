// created by Madhur Saluja on 4th october

using System;

public class CarAdapter : Vehicle
{
    private Car car;

    public CarAdapter(Car car)
    {
        this.car = car;
    }

    public override double GetDistance()
    {
        // Delegates the GetDistance method to the Car class
        return car.GetCarDistance();
    }

    public override double GetTime()
    {
        // Delegates the GetTime method to the Car class
        return car.GetCarTime();
    }

    public override double GetFuelLevel()
    {
        // Delegates the GetFuelLevel method to the Car class
        return car.GetCarFuelLevel();
    }

    public override double GetFuelCost()
    {
        // Delegates the GetFuelCost method to the Car class
        return car.GetCarFuelCost();
    }

    public override void Travel(double distance)
    {
        // Delegates the Travel method to the Car class
        car.CarTravel(distance);
    }

    public override void AddFuel(double amount)
    {
        // Delegates the AddFuel method to the Car class
        car.CarAddFuel(amount);
    }
}
