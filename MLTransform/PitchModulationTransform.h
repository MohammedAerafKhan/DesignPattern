// PitchModulationTransform.h
#ifndef PitchModulationTransform_h
#define PitchModulationTransform_h

#include "AudioTransform.h"
#include <iostream>

class PitchModulationTransform : public AudioTransform {
public:
    void apply(std::vector<double>& audioData) const override;
};

#endif