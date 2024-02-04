// ReverbTransform.h
#ifndef ReverbTransform_h
#define ReverbTransform_h

#include "AudioTransform.h"
#include <iostream>

class ReverbTransform : public AudioTransform {
public:
    void apply(std::vector<double>& audioData) const override;
};

#endif