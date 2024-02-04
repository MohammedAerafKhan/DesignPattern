// AudioProcessor.h
#ifndef AudioProcessor_h
#define AudioProcessor_h

#include "AudioTransform.h"

class AudioProcessor {
private:
    const AudioTransform& transformStrategy;

public:
    AudioProcessor(const AudioTransform& strategy);
    void processAudio(std::vector<double>& audioData) const;
};

#endif