// NoiseReductionTransform.cpp
#include "NoiseReductionTransform.h"
#include <cmath>

void NoiseReductionTransform::apply(std::vector<double>& audioData) const {
    std::cout << "Applying Noise Reduction Transform\n";
    const double noiseThreshold = 0.1;
    for (double& amplitude : audioData) {
        if (std::abs(amplitude) < noiseThreshold) {
            amplitude = 0.0;
        }
    }
}