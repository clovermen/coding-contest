package net.clovermen.coding.contest;

import java.net.StandardSocketOptions;
import java.util.Arrays;
import java.util.List;

public class MarsRover {

    public static void main(String[] args) {

        List<Double> input = Arrays.stream("1.00 1.00 30.00".split(" ")).map(Double::valueOf).toList();

        double wheelBase = input.get(0);
        double distance = input.get(1);
        double steeringAngle = input.get(2);

        double steeringAngleInRadians = Math.toRadians(steeringAngle);


        double turnRadius = wheelBase / Math.sin(steeringAngleInRadians);

        double x = distance / Math.sin(Math.atan(distance / turnRadius)) - turnRadius;
        double y = Math.sqrt((turnRadius * turnRadius) - ((turnRadius - x) * (turnRadius - x)));

        System.out.println(x);
        System.out.println(y);
    }

}
