// NoiseReductionTransform.h
#ifndef NoiseReductionTransform_h
#define NoiseReductionTransform_h

#include "AudioTransform.h"
#include <iostream>

class NoiseReductionTransform : public AudioTransform {
public:
    void apply(std::vector<double>& audioData) const override;
};

#endif