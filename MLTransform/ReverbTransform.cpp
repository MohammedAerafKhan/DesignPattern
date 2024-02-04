// ReverbTransform.cpp
#include "ReverbTransform.h"

void ReverbTransform::apply(std::vector<double>& audioData) const {
    std::cout << "Applying Reverb Transform\n";
    const double reverbFactor = 0.3;
    for (size_t i = 1; i < audioData.size(); ++i) {
        audioData[i] += reverbFactor * audioData[i - 1];
    }
}