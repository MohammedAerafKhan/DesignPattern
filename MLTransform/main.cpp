// main.cpp
#include <iostream>
#include <vector>
#include "EqualizationTransform.h"
#include "NoiseReductionTransform.h"
#include "PitchModulationTransform.h"
#include "ReverbTransform.h"
#include "CompositeTransform.h"
#include "AudioProcessor.h"

int main() {
    std::vector<double> audioData = { 0.5, 0.8, 1.2, 0.9, 1.5 };

    EqualizationTransform equalizationTransform;
    NoiseReductionTransform noiseReductionTransform;
    PitchModulationTransform pitchModulationTransform;
    ReverbTransform reverbTransform;

    const AudioTransform* transformSequence[] = { &equalizationTransform, &noiseReductionTransform, &pitchModulationTransform, &reverbTransform };
    CompositeTransform compositeTransform({ transformSequence, transformSequence + 4 });

    AudioProcessor compositeProcessor(compositeTransform);
    compositeProcessor.processAudio(audioData);

    std::cout << "Modified Audio Data (Composite Transform): ";
    for (const double& amplitude : audioData) {
        std::cout << amplitude << " ";
    }
    std::cout << std::endl;

    return 0;
}