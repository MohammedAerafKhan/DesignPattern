// CompositeTransform.cpp
#include "CompositeTransform.h"

CompositeTransform::CompositeTransform(std::vector<const AudioTransform*> transforms) : transforms(transforms) {}

void CompositeTransform::apply(std::vector<double>& audioData) const {
    for (const AudioTransform* transform : transforms) {
        transform->apply(audioData);
    }
}
