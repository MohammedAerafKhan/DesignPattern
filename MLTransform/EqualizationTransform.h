// EqualizationTransform.h
#ifndef EqualizationTransform_h
#define EqualizationTransform_h

#include "AudioTransform.h"
#include <iostream>

class EqualizationTransform : public AudioTransform {
public:
    void apply(std::vector<double>& audioData) const override;
};

#endif