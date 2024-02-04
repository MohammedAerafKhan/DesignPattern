// CompositeTransform.h
#ifndef CompositeTransform_h
#define CompositeTransform_h

#include "AudioTransform.h"
#include <vector>

class CompositeTransform : public AudioTransform {
private:
    std::vector<const AudioTransform*> transforms;

public:
    CompositeTransform(std::vector<const AudioTransform*> transforms);
    void apply(std::vector<double>& audioData) const override;
};

#endif
