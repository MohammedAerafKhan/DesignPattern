// AudioTransform.h

#ifndef AudioTransform_h
#define AudioTransform_h

#include <vector>

class AudioTransform {
public:
    virtual void apply(std::vector<double>& audioData) const = 0;
    virtual ~AudioTransform() = default;
};

#endif