// EqualizationTransform.cpp
#include "EqualizationTransform.h"

void EqualizationTransform::apply(std::vector<double>& audioData) const {
    std::cout << "Applying Equalization Transform\n";
    const double equalizationFactor = 1.5;
    for (double& amplitude : audioData) {
        amplitude *= equalizationFactor;
    }
}