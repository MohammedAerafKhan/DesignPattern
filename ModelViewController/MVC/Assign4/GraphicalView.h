#include <iostream>
#include"View.h"

#ifndef _GRAPHICALVIEW_H_
#define _GRAPHICALVIEW_H_

class GraphicalView : public View {
public:
    // display predictions graphically
    void displayPrediction(double prediction) override {
        std::cout << "Graphical Prediction: " << prediction << std::endl;
    }
};

#endif