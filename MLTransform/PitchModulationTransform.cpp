// PitchModulationTransform.cpp
#include "PitchModulationTransform.h"

void PitchModulationTransform::apply(std::vector<double>& audioData) const {
    std::cout << "Applying Pitch Modulation Transform\n";
    const double modulationFactor = 1.5;
    for (double& amplitude : audioData) {
        amplitude = amplitude * modulationFactor;
    }
}